package com.mtakworld.itemservice.web.basic;

import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.mtakworld.itemservice.web.form.ItemSaveForm;

import lombok.extern.slf4j.Slf4j;

@RestController
@Slf4j
@RequestMapping("/validation/api/items")
public class ValidationItemApiController {
	@PostMapping("/add")
	public Object addItem(@RequestBody @Validated ItemSaveForm form, BindingResult bindingResult) {
		log.info("API 호출");
		if (bindingResult.hasErrors()) {
			log.info("검증 오류 발생 errors={}", bindingResult);
			return bindingResult.getAllErrors();
		}
		return form;
	}
}
