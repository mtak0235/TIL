package com.mtakworld.itemservice.typeconverter.controller;

import java.time.LocalDateTime;

import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.format.annotation.NumberFormat;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import lombok.Data;

@Controller
public class FormatterController {
	@GetMapping("/formatter/edit")
	public String formatter(Model model) {
		Form form = new Form();
		form.setNumber(10000);
		form.setLocalDateTime(LocalDateTime.now());
		model.addAttribute("form", form);
		return "formatter/formatter-form";
	}

	@PostMapping("/formatter/edit")
	public String formatEdit(@ModelAttribute Form form) {
		return "formatter/formatter-view";
	}

	@Data
	static class Form {

		@NumberFormat(pattern = "###,###")
		private Integer number;
		@DateTimeFormat(pattern = "yyy-MM-dd HH:mm:ss")
		private LocalDateTime localDateTime;
	}
}
