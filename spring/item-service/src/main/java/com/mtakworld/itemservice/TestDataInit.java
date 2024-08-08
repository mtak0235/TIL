package com.mtakworld.itemservice;

import java.util.Optional;

import org.springframework.stereotype.Component;

import com.mtakworld.itemservice.domain.item.Item;
import com.mtakworld.itemservice.domain.item.ItemRepository;
import com.mtakworld.itemservice.domain.member.Member;
import com.mtakworld.itemservice.domain.member.MemberRepository;

import jakarta.annotation.PostConstruct;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import lombok.extern.slf4j.XSlf4j;

@Component
@RequiredArgsConstructor
@Slf4j
public class TestDataInit {

	private final ItemRepository itemRepository;
	private final MemberRepository memberRepository;

	/**
	 * 테스트용 데이터 추가
	 */
	@PostConstruct
	public void init() {
		itemRepository.save(new Item("itemA", 10000, 10));
		itemRepository.save(new Item("itemB", 20000, 20));
		Member member = new Member();
		member.setLoginId("mtak");
		member.setPassword("mtak!");
		member.setName("탁민경");
		memberRepository.save(member);
		Optional<Member> mtak = memberRepository.findByLoginId("mtak");
	}
}