package com.mtakworld.springmvc.basic.response;

import java.io.IOException;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

import com.mtakworld.springmvc.basic.HelloData;

import jakarta.servlet.http.HttpServletResponse;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Controller
public class ResponseBodyController {
	@GetMapping("/response-body-string-v1")
	public void responseBodyStringV1(HttpServletResponse response) throws IOException {
		response.getWriter().write("ok");
	}

	@GetMapping("/response-body-string-v2")
	public ResponseEntity<String> responseBodyStringV1() throws IOException {
		return new ResponseEntity<>("ok", HttpStatus.OK);
	}

	@ResponseBody
	@GetMapping("/resonse-body-string-v3")
	public String responseBodyStringV3() throws IOException {
		return "ok";
	}

	@GetMapping("/response-body-json-v1")
	public ResponseEntity<HelloData> responseBodyJsonV1() {
		HelloData data = new HelloData();
		data.setAge(26);
		data.setUsername("mtak");
		return new ResponseEntity<>(data, HttpStatus.OK);
	}

	@ResponseBody
	@ResponseStatus(HttpStatus.OK)
	@GetMapping("/response-body-json-v2")
	public HelloData responseBodyJsonV2()  {
		HelloData data = new HelloData();
		data.setAge(26);
		data.setUsername("mtak");
		return data;
	}

}
