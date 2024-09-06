package com.mtakworld.springtx.apply.exception;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.TestConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.transaction.annotation.Transactional;

import lombok.extern.slf4j.Slf4j;

@SpringBootTest
public class RollBackTest {
	@Autowired
	RollbackService service;

	@Test
	void runtimeException() {
		Assertions
			.assertThatThrownBy(() -> service.runtimeException())
			.isInstanceOf(RuntimeException.class);
	}

	@Test
	void checkedException() {
		Assertions
			.assertThatThrownBy(() -> service.checkedException())
			.isInstanceOf(MyException.class);
	}
	@Test
	void rollbackFor() {
		Assertions
			.assertThatThrownBy(() -> service.rollbackFor())
			.isInstanceOf(MyException.class);
	}

	@TestConfiguration
	static class RollBackTestConfiguration {
		@Bean
		RollbackService rollbackService() {
			return new RollbackService();
		}
	}

	@Slf4j
	static class RollbackService {
		@Transactional
		public void runtimeException() {
			log.error("runtimeException");
			throw new RuntimeException("runtimeException");
		}

		@Transactional
		public void checkedException() throws MyException {
			log.error("checkedException");
			throw new MyException();
		}

		@Transactional(rollbackFor = MyException.class)
		public void rollbackFor() throws MyException {
			log.error("rollbackFor");
			throw new MyException();
		}
	}

	static class MyException extends Exception {
	}
}
