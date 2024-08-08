package com.mtakworld.itemservice.domain.member;

import static org.assertj.core.api.Assertions.*;

import java.util.Optional;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class MemberRepositoryTest {
	MemberRepository memberRepository = new MemberRepository();

	@BeforeEach
	public void before() {
		// save();
	}

	@Test
	void save() {
		String name = "mtak";
		String pwd = "0000";
		String loginId = "hellomtak";

		Member member = new Member();
		member.setName(name);
		member.setPassword(pwd);
		member.setLoginId(loginId);

		Member saved = memberRepository.save(member);

		assertThat(saved.getName()).isEqualTo(name);
		assertThat(saved.getLoginId()).isEqualTo(loginId);
		assertThat(saved.getPassword()).isEqualTo(pwd);
	}

	@Test
	void findById() {
		String name = "mtak";
		String pwd = "0000";
		String loginId = "hellomtak";

		Member member = new Member();
		member.setName(name);
		member.setPassword(pwd);
		member.setLoginId(loginId);

		Member saved = memberRepository.save(member);

		Member byId = memberRepository.findById(saved.getId());
		assertThat(byId).isNotNull();

	}

	@Test
	void findByLoginId() {
		String name = "mtak";
		String pwd = "0000";
		String loginId = "hellomtak";

		Member member = new Member();
		member.setName(name);
		member.setPassword(pwd);
		member.setLoginId(loginId);

		Member saved = memberRepository.save(member);
		Optional<Member> byLoginId = memberRepository.findByLoginId(loginId);
		assertThat(byLoginId.get()).isNotNull();
	}
}