package com.mtakworld.jdbc.repository;

import static org.assertj.core.api.Assertions.*;

import java.sql.SQLException;
import java.util.NoSuchElementException;
import java.util.UUID;

import org.junit.jupiter.api.Test;

import com.mtakworld.jdbc.domain.Member;

import lombok.extern.slf4j.Slf4j;

@Slf4j
class MemberRepositoryV10Test {
	MemberRepositoryV0 repository = new MemberRepositoryV0();

	@Test
	void crud() throws SQLException {
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

	}
}