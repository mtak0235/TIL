package com.mtakworld.basic.lifecycle;

import org.springframework.beans.factory.DisposableBean;
import org.springframework.beans.factory.InitializingBean;

import jakarta.annotation.PostConstruct;
import jakarta.annotation.PreDestroy;

public class NetworkClient /*implements InitializingBean, DisposableBean*/ {
	private String url;

	public NetworkClient() {
		System.out.println("constructor: " + url);

	}

	public void setUrl(String url) {
		this.url = url;
	}

	public void connect() {
		System.out.println("connect: " + url);
	}

	public void call(String msg) {
		System.out.println("call: " + url + " msg = " + msg);
	}

	public void disconnect() {
		System.out.println("close: " + url);
	}

	@PostConstruct
	public void init() {
		System.out.println("NetworkClient.init");
		connect();
		call("초기화 연결 메시지");
	}

	@PreDestroy
	public void close() {
		System.out.println("NetworkClient.closes");
		disconnect();
	}
	// @Override
	// public void afterPropertiesSet() throws Exception {
	// 	connect();
	// 	call("초기화 연결 메시지");
	// }
	//
	// @Override
	// public void destroy() throws Exception {
	// 	disconnect();
	// }
}
