package com.mtakworld.jdbc.service;

import java.sql.SQLException;

import com.mtakworld.jdbc.domain.Member;
import com.mtakworld.jdbc.repository.MemberRepositoryV1;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class MemberServiceV1 {

	private final MemberRepositoryV1 memberRepository;

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
