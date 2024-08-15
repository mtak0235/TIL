package com.mtakworld.jdbc.exception.basic;

import static org.assertj.core.api.Assertions.*;

import java.net.ConnectException;
import java.sql.SQLException;

import org.junit.jupiter.api.Test;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class UncheckedAppTest {

	@Test
	void unchecked() {
		Controller controller = new Controller();
		assertThatThrownBy(controller::request).isInstanceOf(RuntimeConnectException.class);
	}

	static class Controller {
		Service service = new Service();

		public void request() throws RuntimeConnectException {
			service.logic();

		}
	}

	static class Service {
		Repository repository = new Repository();
		NetworkClient networkClient = new NetworkClient();

		public void logic() {
			repository.call();
			networkClient.call();
		}
	}

	static class NetworkClient {
		public void call() {
			throw new RuntimeConnectException("connection failed");
		}
	}

	static class Repository {
		public void call() {
			try {
				runSQL();
			} catch (SQLException e) {
				throw new RuntimeConnectException(e);
			}
		}

		public void runSQL() throws SQLException {
			throw new SQLException("ex");
		}
	}

	static class RuntimeConnectException extends RuntimeException {
		public RuntimeConnectException(Throwable cause) {
			super(cause);
		}

		public RuntimeConnectException(String message) {
			super(message);
		}
	}

	@Test
	void printEx() {
		Controller controller = new Controller();
		try {
			controller.request();
		} catch (RuntimeConnectException e) {
			log.info("ex", e);
		}

	}
}
