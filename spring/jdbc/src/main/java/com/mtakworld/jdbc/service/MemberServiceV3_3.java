package com.mtakworld.jdbc.service;

import java.sql.SQLException;

import org.springframework.transaction.annotation.Transactional;

import com.mtakworld.jdbc.domain.Member;
import com.mtakworld.jdbc.repository.MemberRepositoryV3;

import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@RequiredArgsConstructor
public class MemberServiceV3_3 {

	private final MemberRepositoryV3 memberRepository;

	@Transactional
	public void accountTransfer(String fromId, String toId, int money) throws SQLException {
		Member fromMember = memberRepository.findById(fromId);
		Member toMember = memberRepository.findById(toId);
		memberRepository.update(fromId, fromMember.getMoney() - money);
		validation(toMember);
		memberRepository.update(toId, toMember.getMoney() + money);
	}

	private void validation(Member member) {
		if (member.getMemberId()
				  .contains("ex")) {
			throw new IllegalStateException("이체중 예외 발생!!");
		}
	}
}
