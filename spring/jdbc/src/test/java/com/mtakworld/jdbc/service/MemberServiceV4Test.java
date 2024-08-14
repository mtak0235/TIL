package com.mtakworld.jdbc.service;

import static org.assertj.core.api.Assertions.*;

import java.sql.SQLException;

import javax.sql.DataSource;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.TestConfiguration;
import org.springframework.context.annotation.Bean;

import com.mtakworld.jdbc.domain.Member;
import com.mtakworld.jdbc.repository.MemberRepositoryV3;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@SpringBootTest
class MemberServiceV4Test {
	public static final String MEMBER_A = "member_a";
	public static final String MEMBER_B = "member_b";
	public static final String MEMBER_EX = "member_ex";
	@Autowired
	private MemberRepositoryV3 memberRepository;
	@Autowired
	private MemberServiceV3_3 memberService;

	@AfterEach
	void after() throws SQLException {
		memberRepository.deleteAll();
	}

	@Test
	@DisplayName("정상 이체")
	void accountTransfer() throws SQLException {
		//given
		Member memberA = new Member(MEMBER_A, 10000);
		Member memberB = new Member(MEMBER_B, 10000);
		memberRepository.save(memberA);
		memberRepository.save(memberB);
		//when
		memberService.accountTransfer(memberA.getMemberId(), memberB.getMemberId(), 2000);
		//then
		Member findMemberA = memberRepository.findById(memberA.getMemberId());
		Member findMemberB = memberRepository.findById(memberB.getMemberId());
		assertThat(findMemberA.getMoney()).isEqualTo(8000);
		assertThat(findMemberB.getMoney()).isEqualTo(12000);
	}

	@Test
	@DisplayName("이체중 예외 발생")
	void accountTransferEx() throws SQLException {
		//given
		Member memberA = new Member(MEMBER_A, 10000);
		Member memberEx = new Member(MEMBER_EX, 10000);
		memberRepository.save(memberA);
		memberRepository.save(memberEx);
		//when
		assertThatThrownBy(
			() -> memberService.accountTransfer(memberA.getMemberId(), memberEx.getMemberId(), 2000)).isInstanceOf(
			IllegalStateException.class);
		//then
		Member findMemberA = memberRepository.findById(memberA.getMemberId());
		Member findMemberEx = memberRepository.findById(memberEx.getMemberId());
		//memberA의 돈이 롤백 되어야함
		assertThat(findMemberA.getMoney()).isEqualTo(10000);
		assertThat(findMemberEx.getMoney()).isEqualTo(10000);
	}

	@TestConfiguration
	@AllArgsConstructor
	static class TestConfig {
		private final DataSource dataSource;
		@Bean
		MemberRepositoryV3 memberRepositoryV3() {
			return new MemberRepositoryV3(dataSource);
		}

		@Bean
		MemberServiceV3_3 memberService() {
			return new MemberServiceV3_3(memberRepositoryV3());
		}
	}

}