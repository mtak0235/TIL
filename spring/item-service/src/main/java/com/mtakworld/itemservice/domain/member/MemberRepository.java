package com.mtakworld.itemservice.domain.member;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import org.springframework.stereotype.Repository;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Repository
public class MemberRepository {
	private static final Map<Long, Member> store = new HashMap<>();
	private static long sequence = 0L;

	public Member save(Member member) {
		member.setId(++sequence);
		log.info("save: member={}", member);
		store.put(member.getId(), member);
		return member;
	}

	public Member findById(Long id) {
		return store.get(id);
	}

	public Optional<Member> findByLoginId(String longinId) {
		/*List<Member> all = findAll();
		for (Member m : all) {
			if (m.getLoginId().equals(longinId)) {
				return Optional.of(m);
			}
		}
		return Optional.empty();*/
		return findAll().stream().filter(m -> m.getLoginId().equals(longinId)).findFirst();
	}

	public List<Member> findAll() {
		return new ArrayList<>(store.values());
	}

}
