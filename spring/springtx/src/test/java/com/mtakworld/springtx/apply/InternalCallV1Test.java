package com.mtakworld.springtx.apply;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.TestConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.transaction.support.TransactionSynchronizationManager;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@SpringBootTest
public class InternalCallV1Test {
	@Autowired
	CallsService callsService;

	@Test
	void printProxy() {
		log.info("callService={}", callsService.getClass());
	}

	@Test
	void internalCall() {
		callsService.internal();
	}

	@Test
	void externalCall() {
		callsService.external();
	}
	@TestConfiguration
	static class InternalCallV1TestConfiguration {
		@Bean
		CallsService callsService() {
			return new CallsService();
		}
	}

	@Slf4j
	static class CallsService {
		public void external() {
			log.info("call external");
			printTxInfo();
			internal();

		}

		@Transactional
		public void internal() {
			log.info("call internal");
			printTxInfo();
		}

		private void printTxInfo() {
			boolean active = TransactionSynchronizationManager.isActualTransactionActive();
			log.info("active is {}", active);
		}
	}
}
