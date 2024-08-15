package com.mtakworld.jdbc.repository;

import com.mtakworld.jdbc.domain.Member;

public interface MemberRepository {
	Member save(Member member);

	Member findById(String memberId);

	void update(String memberId, int money);

	void delete(String memberId);

	void deleteAll();

}
