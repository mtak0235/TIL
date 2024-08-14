package com.mtakworld.jdbc.service;

import java.sql.Connection;
import java.sql.SQLException;

import javax.sql.DataSource;

import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.TransactionStatus;
import org.springframework.transaction.support.DefaultTransactionDefinition;

import com.mtakworld.jdbc.domain.Member;
import com.mtakworld.jdbc.repository.MemberRepositoryV2;
import com.mtakworld.jdbc.repository.MemberRepositoryV3;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@RequiredArgsConstructor
public class MemberServiceV3_1 {

	private final MemberRepositoryV3 memberRepository;
	private final PlatformTransactionManager transactionManager;

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
		TransactionStatus status = transactionManager.getTransaction(new DefaultTransactionDefinition());
		try {
			Member fromMember = memberRepository.findById(fromId);
			Member toMember = memberRepository.findById(toId);
			memberRepository.update(fromId, fromMember.getMoney() - money);
			validation(toMember);
			memberRepository.update(toId, toMember.getMoney() + money);
			transactionManager.commit(status);

		} catch (Exception e) {
			transactionManager.rollback(status);
			throw new IllegalStateException(e);
		}
	}

	private void validation(Member member) {
		if (member.getMemberId()
				  .contains("ex")) {
			throw new IllegalStateException("이체중 예외 발생!!");
		}
	}
}
