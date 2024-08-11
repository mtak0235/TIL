package com.mtakworld.itemservice.exception.api;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.mtakworld.itemservice.exception.exception.UserException;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@RestController
public class ApiExceptionV2Controller {

	@GetMapping("/api2/members/{id}")
	public MemberDto getMember(@PathVariable String id) {

		if (id.equals("ex")) {
			throw new RuntimeException("wrong accesssss");
		}
		if (id.equals("bad")) {
			throw new IllegalArgumentException("wrong inputtt");
		}
		if (id.equals("user-ex")) {
			throw new UserException("user errorrrr");
		}
		return new MemberDto(id, "hello " + id);
	}

}
