package com.mtakworld.mvc.servlet.domain.member;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MemberRepository {
	private static Map<Long, Member> members = new HashMap<Long, Member>();
	private static long sequence = 0L;
	private static final MemberRepository store = new MemberRepository();

	public static MemberRepository getInstance() {
		return new MemberRepository();}
	private MemberRepository() {
	}

	public Member save(Member member) {
		member.setId(++sequence);
		members.put(member.getId(), member);
		return member;
	}
	public Member findById(Long id) {
		return members.get(id);
	}

	public void clear() {
		store.clear();
	}

	public List<Member> findAll() {
		return new ArrayList<>(members.values());
	}
}
