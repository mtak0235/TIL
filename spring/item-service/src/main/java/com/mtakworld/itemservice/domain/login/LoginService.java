package com.mtakworld.itemservice.domain.login;

import org.springframework.stereotype.Service;

import com.mtakworld.itemservice.domain.member.Member;
import com.mtakworld.itemservice.domain.member.MemberRepository;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Service
@RequiredArgsConstructor
public class LoginService {
	private final MemberRepository memberRepository;

	public Member login(String loginId, String password) {
		/*Optional<Member> byLoginId = memberRepository.findByLoginId(loginId);
		Member member = byLoginId.get();
		if (member.getPassword().equals(password)) {
			return member;
		} else {
			return null;
		}*/
		return memberRepository.findByLoginId(loginId)
			.filter(m -> m.getPassword().equals(password))
			.orElse(null);
	}
}
