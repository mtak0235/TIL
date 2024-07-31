package com.mtakworld.itemservice.web.basic;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.mtakworld.itemservice.domain.item.Item;
import com.mtakworld.itemservice.domain.item.ItemRepository;

import jakarta.annotation.PostConstruct;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Controller
@RequestMapping("/basic/items")
@RequiredArgsConstructor
public class BasicItemController {
	private final ItemRepository itemRepository;

	@GetMapping
	public String items(Model model) {

		List<Item> items = itemRepository.findAll();
		model.addAttribute("items", items);
		return "basic/items";
	}

	@GetMapping("/{itemId}")
	public String item(@PathVariable/*("itemId")*/ Long itemId, Model model) {
		Item item = itemRepository.findById(itemId);
		model.addAttribute("item", item);
		return "basic/item";
	}

	@ModelAttribute("regions")
	public Map<String, String> model(Model model) {
		LinkedHashMap<String, String> regions = new LinkedHashMap<>();
		regions.put("SEOUL", "서울");
		regions.put("BUSAN", "부산");
		regions.put("JEJU", "제주");
		return regions;
	}

	@GetMapping("/add")
	public String addForm(Model model) {
		model.addAttribute("item", new Item());
		return "basic/addForm";
	}

	/*@PostMapping("/add")
	public String save(@RequestParam String itemName,@RequestParam int price, @RequestParam Integer quantity, Model model) {
		Item item = new Item(itemName, price, quantity);
		itemRepository.save(item);
		model.addAttribute("item", item);
		return "basic/item";
	}*/

	/*@PostMapping("/add")
	public String save(@ModelAttribute Item item, Model model) {
		itemRepository.save(item);
		model.addAttribute("item", item);
		return "basic/item";
	}*/

/*	@PostMapping("/add")
	public String save(@ModelAttribute("item") Item item) {
		itemRepository.save(item);
		return "basic/item";
	}*/

	/*@PostMapping("/add")
	public String save(@ModelAttribute Item item) {
		itemRepository.save(item);
		return "basic/item";
	}*/

	/*@PostMapping("/add")
	public String save(Item item) {
		itemRepository.save(item);
		return "basic/item";
	}*/

	/*@PostMapping("/add")
	public String save(Item item) {
		itemRepository.save(item);
		return "redirect:/basic/items/" + item.getId();
	}*/

	@PostMapping("/add")
	public String save(Item item, RedirectAttributes redirectAttributes) {

		log.info("item.open={}", item.getOpen());
		log.info("item.regions={}", item.getRegions());

		itemRepository.save(item);
		redirectAttributes.addAttribute("itemId", item.getId());
		redirectAttributes.addAttribute("status", true);
		return "redirect:/basic/items/{itemId}";
	}

	@GetMapping("/{itemId}/edit")
	public String editForm(@PathVariable Long itemId, Model model) {
		Item item = itemRepository.findById(itemId);
		model.addAttribute("item", item);
		return "basic/editForm";
	}

	@PostMapping("/{itemId}/edit")
	public String edit(@PathVariable Long itemId, @ModelAttribute Item item) {
		itemRepository.update(itemId, item);
		return "redirect:/basic/items/{itemId}";
	}

	@PostConstruct
	public void init() {
		itemRepository.save(new Item("후우링", 10000, 10));
		itemRepository.save(new Item("파란 후우링", 20000, 20));

	}
}
