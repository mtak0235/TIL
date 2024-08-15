package com.mtakworld.jdbc.service;

import org.springframework.transaction.annotation.Transactional;

import com.mtakworld.jdbc.domain.Member;
import com.mtakworld.jdbc.repository.MemberRepository;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@RequiredArgsConstructor
public class MemberServiceV4 {

	private final MemberRepository memberRepository;

	@Transactional
	public void accountTransfer(String fromId, String toId, int money) {
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
