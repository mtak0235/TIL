package com.mtakworld.itemservice.upload.controller;

import java.io.IOException;
import java.net.MalformedURLException;
import java.nio.charset.StandardCharsets;
import java.util.List;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.core.io.Resource;
import org.springframework.core.io.UrlResource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import org.springframework.web.util.UriUtils;

import com.mtakworld.itemservice.upload.domain.Item;
import com.mtakworld.itemservice.upload.domain.ItemRepository;
import com.mtakworld.itemservice.upload.domain.UploadFile;
import com.mtakworld.itemservice.upload.file.FileStore;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Controller("forUploadingController")
public class ItemController {
	private final FileStore fileStore;

	private final ItemRepository itemRepository;

	public ItemController(@Qualifier("forUploadItemRepository") ItemRepository itemRepository, FileStore fileStore) {
		this.itemRepository = itemRepository;
		this.fileStore = fileStore;
	}

	@GetMapping("/items/new")
	public String newItem(@ModelAttribute ItemForm form) {
		return "upload/item-form";
	}

	@PostMapping("/items/new")
	public String saveItem(@ModelAttribute ItemForm form, RedirectAttributes redirectAttributes) throws IOException {
		UploadFile attachFile = fileStore.storeFile(form.getAttachFile());
		List<UploadFile> storeImageFiles = fileStore.storeFiles(form.getImageFiles());
		//데이터베이스에 저장
		Item item = new Item();
		item.setItemName(form.getItemName());
		item.setAttachFile(attachFile);
		item.setImageFiles(storeImageFiles);
		itemRepository.save(item);
		redirectAttributes.addAttribute("itemId", item.getId());
		return "redirect:/items/uploadEx/{itemId}";
	}

	@GetMapping("/items/uploadEx/{id}")
	public String items(@PathVariable Long id, Model model) {
		Item item = itemRepository.findById(id);
		model.addAttribute("item", item);
		return "upload/item-view";
	}

	@ResponseBody
	@GetMapping("/images/{filename}")
	public Resource downloadImage(@PathVariable String filename) throws MalformedURLException {
		return new UrlResource("file:" + fileStore.getFullPath(filename));
	}

	@GetMapping("/attach/{itemId}")
	public ResponseEntity<Resource> downloadAttach(@PathVariable Long itemId) throws MalformedURLException {
		Item item = itemRepository.findById(itemId);
		String storeFileName = item.getAttachFile()
								   .getStoreFileName();
		String uploadFileName = item.getAttachFile()
									.getUploadFileName();
		UrlResource resource = new UrlResource("file:" + fileStore.getFullPath(storeFileName));
		log.info("uploadFileName={}", uploadFileName);
		String encodedUploadFileName = UriUtils.encode(uploadFileName, StandardCharsets.UTF_8);
		String contentDisposition = "attachment; filename=\"" + encodedUploadFileName + "\"";
		return ResponseEntity.ok()
							 .header(HttpHeaders.CONTENT_DISPOSITION, contentDisposition)
							 .body(resource);
	}
}
