package com.mtakworld.jdbc.service;

import java.sql.Connection;
import java.sql.SQLException;

import javax.sql.DataSource;

import com.mtakworld.jdbc.domain.Member;
import com.mtakworld.jdbc.repository.MemberRepositoryV2;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@RequiredArgsConstructor
public class MemberServiceV2 {

	private final DataSource dataSource;
	private final MemberRepositoryV2 memberRepository;

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
		Connection connection = dataSource.getConnection();
		try {
			connection.setAutoCommit(false);
			Member fromMember = memberRepository.findById(connection, fromId);
			Member toMember = memberRepository.findById(connection, toId);
			memberRepository.update(connection, fromId, fromMember.getMoney() - money);
			validation(toMember);
			memberRepository.update(connection, toId, toMember.getMoney() + money);
			connection.commit();

		} catch (Exception e) {
			connection.rollback();
			throw new IllegalStateException(e);
		} finally {
			release(connection);
		}
	}

	private void validation(Member member) {
		if (member.getMemberId()
				  .contains("ex")) {
			throw new IllegalStateException("이체중 예외 발생!!");
		}
	}
}
