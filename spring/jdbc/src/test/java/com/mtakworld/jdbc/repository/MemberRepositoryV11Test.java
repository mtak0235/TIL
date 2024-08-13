package com.mtakworld.jdbc.repository;

import static com.mtakworld.jdbc.connection.ConnectionConst.*;
import static org.assertj.core.api.Assertions.*;

import java.sql.SQLException;
import java.util.NoSuchElementException;
import java.util.UUID;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

import com.mtakworld.jdbc.connection.ConnectionConst;
import com.mtakworld.jdbc.domain.Member;
import com.zaxxer.hikari.HikariDataSource;

import lombok.extern.slf4j.Slf4j;

@Slf4j
class MemberRepositoryV11Test {
	MemberRepositoryV1 repository;

	@BeforeEach
	void beforeEach() {
		// DriverManagerDataSource dataSource = new DriverManagerDataSource(URL, USERNAME, PASSWORD);
		HikariDataSource dataSource = new HikariDataSource();
		dataSource.setJdbcUrl(URL);
		dataSource.setPassword(PASSWORD);
		dataSource.setUsername(USERNAME);
		dataSource.setMaximumPoolSize(5);

		repository = new MemberRepositoryV1(dataSource);

	}

	@Test
	void crud() throws SQLException, InterruptedException {
		Member doyun = new Member(UUID.randomUUID()
									  .toString()
									  .substring(0, 10), 10000);
		repository.save(doyun);
		Member byId = repository.findById(doyun.getMemberId());
		log.info("findMember={}", byId);
		assertThat(byId).isEqualTo(doyun);

		repository.update(doyun.getMemberId(), 30000);
		Member byId1 = repository.findById(doyun.getMemberId());
		assertThat(byId1.getMoney()).isEqualTo(30000);

		repository.delete(doyun.getMemberId());
		assertThatThrownBy(() -> repository.findById(doyun.getMemberId())).isInstanceOf(NoSuchElementException.class);
		Thread.sleep(1000);

	}
}