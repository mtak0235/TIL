package com.mtakworld.itemservice.web.session;

import java.util.Date;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@RestController
public class SessionInfoController {
	@GetMapping("/session-info")
	public String sessionInfo(HttpServletRequest request) {
		HttpSession session = request.getSession(false);
		if (session == null) {
			return "no session";
		}
		session.getAttributeNames()
			   .asIterator()
			   .forEachRemaining(name -> log.info("session name={} value={}", name, session.getAttribute(name)));
		log.info("sessionId={}", session.getId());
		log.info("maxInactiveInterval={}", session.getMaxInactiveInterval());
		log.info("creationTime={}", new Date(session.getCreationTime()));
		log.info("lastAccessedTime={}", new Date(session.getLastAccessedTime()));
		log.info("isNew={}", session.isNew());
		return "세션 출력";
	}
}
