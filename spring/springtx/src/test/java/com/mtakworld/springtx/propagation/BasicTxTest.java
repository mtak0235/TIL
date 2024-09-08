package com.mtakworld.springtx.propagation;

import javax.sql.DataSource;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.TestConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.TransactionDefinition;
import org.springframework.transaction.TransactionStatus;
import org.springframework.transaction.UnexpectedRollbackException;
import org.springframework.transaction.support.DefaultTransactionDefinition;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@SpringBootTest
public class BasicTxTest {
	@Autowired
	PlatformTransactionManager transactionManager;

	@Test
	void commit() {
		log.info("트랜잭션 시작");
		TransactionStatus status = transactionManager.getTransaction(new DefaultTransactionDefinition());
		log.info("트랜잭션 커밋 시작");
		transactionManager.commit(status);
		log.info("트랜잭션 커밋 완료");
	}

	@Test
	void rollback() {
		log.info("트랜잭션 시작");
		TransactionStatus status = transactionManager.getTransaction(new DefaultTransactionDefinition());
		log.info("트랜잭션 롤백 시작");
		transactionManager.rollback(status);
		log.info("트랜잭션 롤백 완료");
	}

	@Test
	void doubleCommit() {
		log.info("트랜잭션1 시작");
		TransactionStatus status = transactionManager.getTransaction(new DefaultTransactionDefinition());
		log.info("트랜잭션1 커밋 시작");
		transactionManager.commit(status);
		log.info("트랜잭션1 커밋 완료");

		log.info("트랜잭션2 시작");
		TransactionStatus status2 = transactionManager.getTransaction(new DefaultTransactionDefinition());
		log.info("트랜잭션2 커밋 시작");
		transactionManager.commit(status2);
		log.info("트랜잭션2 커밋 완료");
	}

	@Test
	void doubleCommitRollback() {
		log.info("트랜잭션1 시작");
		TransactionStatus status = transactionManager.getTransaction(new DefaultTransactionDefinition());
		log.info("트랜잭션1 커밋 시작");
		transactionManager.commit(status);
		log.info("트랜잭션1 커밋 완료");

		log.info("트랜잭션2 시작");
		TransactionStatus status2 = transactionManager.getTransaction(new DefaultTransactionDefinition());
		log.info("트랜잭션2 rollback 시작");
		transactionManager.rollback(status2);
		log.info("트랜잭션2 커밋 완료");
	}

	@Test
	void innerCommit() {
		log.info("외부 트랜잭션 시작");
		TransactionStatus outer = transactionManager.getTransaction(new DefaultTransactionDefinition());
		log.info("outer.isNewTransaction() = {}", outer.isNewTransaction());
		inner();
		log.info("외부 트랜잭션 커밋");
		transactionManager.commit(outer);
	}

	private void inner() {
		log.info("내부 트랜잭션 시작");
		TransactionStatus inner = transactionManager.getTransaction(new DefaultTransactionDefinition());
		log.info("inner.isNewTransaction() = {}", inner.isNewTransaction());
		log.info("내부 트랜잭션 커밋");
		transactionManager.commit(inner);
	}

	private void innerR() {
		log.info("내부 트랜잭션 시작");
		TransactionStatus inner = transactionManager.getTransaction(new DefaultTransactionDefinition());
		log.info("inner.isNewTransaction() = {}", inner.isNewTransaction());
		log.info("내부 트랜잭션 롤백");
		transactionManager.rollback(inner);
	}

	@Test
	void outerRollback() {
		log.info("외부 트랜잭션 시작");
		TransactionStatus outer = transactionManager.getTransaction(new DefaultTransactionDefinition());
		log.info("outer.isNewTransaction() = {}", outer.isNewTransaction());
		inner();
		log.info("외부 트랜잭션 롤백");
		transactionManager.rollback(outer);
	}
	@Test
	void innerRollback() {
		log.info("외부 트랜잭션 시작");
		TransactionStatus outer = transactionManager.getTransaction(new DefaultTransactionDefinition());
		log.info("outer.isNewTransaction() = {}", outer.isNewTransaction());
		innerR();
		log.info("외부 트랜잭션 커밋");
		Assertions.assertThatThrownBy(()-> transactionManager.commit(outer)).isInstanceOf(UnexpectedRollbackException.class);
	}

	@Test
	void innerRollbackRequiresNew() {
		log.info("외부 트랜잭션 시작");
		TransactionStatus outer = transactionManager.getTransaction(new DefaultTransactionDefinition());
		log.info("outer.isNewTransaction() = {}", outer.isNewTransaction());

		log.info("내부 트랜잭션 시작");
		DefaultTransactionDefinition definition = new DefaultTransactionDefinition();
		definition.setPropagationBehavior(TransactionDefinition.PROPAGATION_REQUIRES_NEW);
		TransactionStatus inner = transactionManager.getTransaction(definition);
		log.info("inner.isNewTransaction() = {}", inner.isNewTransaction());
		log.info("내부 트랜잭션 롤백");
		transactionManager.rollback(inner);

		log.info("외부 트랜잭션 커밋");
		transactionManager.commit(outer);

	}

	@TestConfiguration
	static class Config {
		@Bean
		public PlatformTransactionManager transactionManager(DataSource dataSource) {
			return new DataSourceTransactionManager(dataSource);
		}
	}
}
