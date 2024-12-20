package com.mtakworld.springtx.apply;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.TestConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.transaction.support.TransactionSynchronizationManager;

import lombok.extern.slf4j.Slf4j;

@SpringBootTest
public class TxLevelTest {
	@Autowired
	LevelService service;

	@Test
	void orderTest() {
		service.write();
		service.read();
	}
	@TestConfiguration
	static class TxLevelTestConfig {
		@Bean
		LevelService levelService() {
			return new LevelService();
		}
	}

	@Slf4j
	@Transactional(readOnly = true)
	static class LevelService {
		@Transactional(readOnly = false)
		public void write() {
			log.info("call write");
			printTxInfo();
		}

		public void read() {
			log.info("call read");
			printTxInfo();
		}

		private void printTxInfo() {
			boolean active = TransactionSynchronizationManager.isActualTransactionActive();
			log.info("active is {}", active);
			boolean currentTransactionReadOnly = TransactionSynchronizationManager.isCurrentTransactionReadOnly();
			log.info("currentTransactionReadOnly is {}", currentTransactionReadOnly);
		}
	}
}
