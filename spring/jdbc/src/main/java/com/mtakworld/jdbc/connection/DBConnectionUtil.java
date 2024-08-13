package com.mtakworld.jdbc.connection;

import static com.mtakworld.jdbc.connection.ConnectionConst.*;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class DBConnectionUtil {

	private static Connection connection;

	public static Connection getConnection() {
		try {
			connection = DriverManager.getConnection(URL, USERNAME, PASSWORD);
			log.info("get connection={}, class={}", connection, connection.getClass());
		} catch (SQLException e) {
			throw new IllegalStateException(e);
		}

		return connection;
	}
}
