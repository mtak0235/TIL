package com.mtakworld.itemservice.exception.api;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import com.mtakworld.itemservice.exception.exception.BadRequestException;
import com.mtakworld.itemservice.exception.exception.UserException;

import lombok.extern.slf4j.Slf4j;

@RestController
@Slf4j
public class ApiExceptionController {
	@GetMapping("/api/members/{id}")
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

	@GetMapping("/api/response-status-ex1")
	public String responseStatusEx1() {
		throw new BadRequestException();
	}

	@GetMapping("/api/response-status-ex2")
	public String responseStatusEx2() {
		throw new ResponseStatusException(HttpStatus.NOT_FOUND, "error.bad", new IllegalArgumentException());
	}

	@GetMapping("/api/default-handler-ex")
	public String defauleException(@RequestParam Integer data) {
		return "okay";
	}
}
