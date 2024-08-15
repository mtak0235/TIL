package com.mtakworld.jdbc.exception.basic;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class UncheckedTest {
	static class MyUncheckedException extends RuntimeException {
		public MyUncheckedException(String message) {
			super(message);
		}
	}

	static class Repository {
		public void call() {
			throw new MyUncheckedException("ex");
		}
	}

	static class Service {
		Repository repository = new Repository();

		public void callCatch() {
			try {
				repository.call();
			} catch (MyUncheckedException e) {
				log.info("message={}", e.getMessage(), e);
			}
		}

		public void callThrow() {
			repository.call();
		}
	}

	@Test
	void unchecked_catch() {
		Service service = new Service();
		service.callCatch();
	}

	@Test
	void unchecked_throw() {
		Service service = new Service();
		Assertions.assertThatThrownBy(service::callThrow)
				  .isInstanceOf(MyUncheckedException.class);
	}
}
