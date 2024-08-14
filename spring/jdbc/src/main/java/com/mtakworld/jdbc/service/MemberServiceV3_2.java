package com.mtakworld.jdbc.service;

import java.sql.Connection;
import java.sql.SQLException;

import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.support.TransactionTemplate;

import com.mtakworld.jdbc.domain.Member;
import com.mtakworld.jdbc.repository.MemberRepositoryV3;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class MemberServiceV3_2 {

	private final MemberRepositoryV3 memberRepository;
	private final TransactionTemplate transactionTemplate;

	public MemberServiceV3_2(MemberRepositoryV3 memberRepository, PlatformTransactionManager transactionManager) {
		this.memberRepository = memberRepository;
		this.transactionTemplate = new TransactionTemplate(transactionManager);

	}

	private static void release(Connection connection) {
		if (connection != null) {
			try {
				connection.setAutoCommit(true);
				connection.close();
			} catch (Exception e) {
				log.info("error", e);
			}
		}
	}

	public void accountTransfer(String fromId, String toId, int money) throws SQLException {
		transactionTemplate.executeWithoutResult((status) -> {
			Member fromMember = null;
			try {
				fromMember = memberRepository.findById(fromId);
				Member toMember = memberRepository.findById(toId);
				memberRepository.update(fromId, fromMember.getMoney() - money);
				validation(toMember);
				memberRepository.update(toId, toMember.getMoney() + money);
			} catch (SQLException e) {
				throw new IllegalStateException(e);
			}
		});
	}

	private void validation(Member member) {
		if (member.getMemberId()
				  .contains("ex")) {
			throw new IllegalStateException("이체중 예외 발생!!");
		}
	}
}
