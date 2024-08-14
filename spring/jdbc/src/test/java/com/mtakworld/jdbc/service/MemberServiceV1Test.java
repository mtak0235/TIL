package com.mtakworld.jdbc.service;

import static com.mtakworld.jdbc.connection.ConnectionConst.*;
import static org.assertj.core.api.Assertions.*;

import java.sql.SQLException;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

import com.mtakworld.jdbc.domain.Member;
import com.mtakworld.jdbc.repository.MemberRepositoryV1;

class MemberServiceV1Test {
	public static final String member_a = "member_a";
	public static final String member_b = "member_b";
	public static final String member_ex = "member_ex";
	private MemberRepositoryV1 memberRepository;
	private MemberServiceV1 memberService;

	@BeforeEach
	void before() throws SQLException {
		DriverManagerDataSource dataSource = new DriverManagerDataSource(URL, USERNAME, PASSWORD);
		memberRepository = new MemberRepositoryV1(dataSource);
		memberService = new MemberServiceV1(memberRepository);
	}

	@AfterEach
	void after() throws SQLException {
		memberRepository.deleteAll();
	}

	@DisplayName("정상 이체")
	@Test
	void accountTransfer() throws SQLException {
		Member memberA = new Member(member_a, 10000);
		Member memberB = new Member(member_b, 10000);
		memberRepository.save(memberA);
		memberRepository.save(memberB);
		memberService.accountTransfer(memberA.getMemberId(), memberB.getMemberId(), 2000);
		Member findMemberA = memberRepository.findById(memberA.getMemberId());
		Member findMemberB = memberRepository.findById(memberB.getMemberId());
		assertThat(findMemberA.getMoney()).isEqualTo(8000);
		assertThat(findMemberB.getMoney()).isEqualTo(12000);
	}

	@DisplayName("비정상 이체")
	@Test
	void accountTransferEx() throws SQLException {
		Member memberA = new Member(member_a, 10000);
		Member memberEx = new Member(member_ex, 10000);
		memberRepository.save(memberA);
		memberRepository.save(memberEx);
		Assertions.assertThatThrownBy(
					  () -> memberService.accountTransfer(memberA.getMemberId(), memberEx.getMemberId(), 2000))
				  .isInstanceOf(IllegalStateException.class);
		Member findMemberA = memberRepository.findById(memberA.getMemberId());
		Member findMemberB = memberRepository.findById(memberEx.getMemberId());
		assertThat(findMemberA.getMoney()).isEqualTo(8000);
		assertThat(findMemberB.getMoney()).isEqualTo(10000);
	}
}