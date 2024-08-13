package com.mtakworld.jdbc.connection;

import static com.mtakworld.jdbc.connection.ConnectionConst.*;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import javax.sql.DataSource;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

import com.zaxxer.hikari.HikariDataSource;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class ConnectionTest {
	@Test
	void driverManager() throws SQLException {
		Connection con1 = DriverManager.getConnection(URL, USERNAME, PASSWORD);
		Connection con2 = DriverManager.getConnection(URL, USERNAME, PASSWORD);
		Assertions.assertThat(con1)
				  .isNotEqualTo(con2);
	}

	@Test
	void dataSourceDriverManager() throws SQLException {
		DriverManagerDataSource dataSource = new DriverManagerDataSource(URL, USERNAME, PASSWORD);
		useDataSource(dataSource);

	}

	private void useDataSource(DataSource dataSource) throws SQLException {
		Connection con1 =dataSource.getConnection();
		Connection con2 = dataSource.getConnection();
		log.info("connection={}, class={}", con1, con1.getClass());
		log.info("connection={}, class={}", con2, con2.getClass());
		Assertions.assertThat(con1)
				  .isNotEqualTo(con2);

	}

	@Test
	void datasourceConnectionPool() throws SQLException, InterruptedException {
		HikariDataSource dataSource = new HikariDataSource();
		dataSource.setJdbcUrl(URL);
		dataSource.setUsername(USERNAME);
		dataSource.setPassword(PASSWORD);
		dataSource.setMaximumPoolSize(10);
		dataSource.setPoolName("mtakPool");
		useDataSource(dataSource);
		Thread.sleep(1000);

	}
}
