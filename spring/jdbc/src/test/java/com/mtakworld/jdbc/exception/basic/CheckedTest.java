package com.mtakworld.jdbc.exception.basic;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class CheckedTest {
	static class MyCheckedExceptin extends Exception {
		public MyCheckedExceptin(String message) {
			super(message);
		}

	}

	static class Service {
		Repository repository = new Repository();

		public void callCatch() {
			try {
				repository.call();
			} catch (MyCheckedExceptin e) {
				log.info("message={}",e.getMessage(), e);
			}
		}

		public void callThrow() throws MyCheckedExceptin {
			repository.call();
		}
	}

	static class Repository {
		public void call() throws MyCheckedExceptin {
			throw new MyCheckedExceptin("ex");
		}
	}

	@Test
	void checked_catch() {
		Service service = new Service();
		service.callCatch();
	}

	@Test
	void checked_throw() throws MyCheckedExceptin {
		Service service = new Service();
		Assertions.assertThatThrownBy(service::callThrow)
				  .isInstanceOf(MyCheckedExceptin.class);
	}

}
