package com.mtakworld.jdbc.exception.translator;

import static com.mtakworld.jdbc.connection.ConnectionConst.*;
import static org.assertj.core.api.Assertions.*;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import javax.sql.DataSource;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.BadSqlGrammarException;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.jdbc.support.SQLErrorCodeSQLExceptionTranslator;

public class SpringExceltionTranslatorTest {
	DataSource dataSource;

	@BeforeEach
	void init() {
		dataSource = new DriverManagerDataSource(URL, USERNAME, PASSWORD);
	}

	@Test
	void sqlExceptionErrorCode() {
		String sql = "select bad query";
		try {
			Connection connection = dataSource.getConnection();
			PreparedStatement preparedStatement = connection.prepareStatement(sql);
			preparedStatement.executeUpdate();
		} catch (SQLException e) {
			assertThat(e.getErrorCode()).isEqualTo(42122);
		}

	}

	@Test
	void exceptionTranslator() {
		String sql = "select bad query";
		try {
			Connection connection = dataSource.getConnection();
			PreparedStatement preparedStatement = connection.prepareStatement(sql);
			preparedStatement.executeUpdate();
		} catch (SQLException e) {
			assertThat(e.getErrorCode()).isEqualTo(42122);
			SQLErrorCodeSQLExceptionTranslator translator = new SQLErrorCodeSQLExceptionTranslator(
				dataSource);
			DataAccessException dataAccessException = translator.translate("select", sql, e);
			assertThat(dataAccessException.getClass()).isEqualTo(BadSqlGrammarException.class);
		}
	}
}
