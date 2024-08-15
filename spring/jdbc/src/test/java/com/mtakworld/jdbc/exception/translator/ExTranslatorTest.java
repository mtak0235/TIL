package com.mtakworld.jdbc.exception.translator;

import static com.mtakworld.jdbc.connection.ConnectionConst.*;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Random;

import javax.sql.DataSource;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.jdbc.support.JdbcUtils;

import com.mtakworld.jdbc.connection.ConnectionConst;
import com.mtakworld.jdbc.domain.Member;
import com.mtakworld.jdbc.repository.ex.MyDBException;
import com.mtakworld.jdbc.repository.ex.MyDuplicatedKeyException;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public class ExTranslatorTest {
	Repository repository;
	Service service;

	@BeforeEach
	void init() {
		DriverManagerDataSource dataSource = new DriverManagerDataSource(URL, USERNAME, PASSWORD);
		repository = new Repository(dataSource);
		service = new Service(repository);
	}
	@RequiredArgsConstructor
	static class Service {
		private final Repository repository;

		public void create(String memberId) {
			try {
				repository.save(new Member(memberId, 0));
				log.info("saveId={}", memberId);
			} catch (MyDuplicatedKeyException e) {
				log.info("키 중복, 복구 시도 ");
				String retriedId = generateNewID(memberId);
				log.info("retriedId={}", retriedId);
				repository.save(new Member(retriedId, 0));
			} catch (MyDBException e) {
				log.info("데이터 접근 계측 예외");
				throw e;
			}

		}

		private String generateNewID(String memberId) {
			return memberId + new Random().nextInt(100);
		}
	}

	@RequiredArgsConstructor
	static class Repository {
		private final DataSource dataSource;

		public Member save(Member member) {
			String sql = "insert into member (member_id, money) values (?,?)";
			Connection connection = null;
			PreparedStatement preparedStatement = null;

			try {
				connection = dataSource.getConnection();
				preparedStatement = connection.prepareStatement(sql);
				preparedStatement.setString(1, member.getMemberId());
				preparedStatement.setInt(2, member.getMoney());
				preparedStatement.executeUpdate();
				return member;
			} catch (SQLException e) {
				if (e.getErrorCode() == 23505) {
					throw new MyDuplicatedKeyException(e);
				}
				throw new MyDBException(e);
			} finally {
				JdbcUtils.closeStatement(preparedStatement);
				JdbcUtils.closeConnection(connection);
			}
		}
	}

	@Test
	void duplicateKeySave() {
		service.create("mtak");
		service.create("mtak");

	}
}
