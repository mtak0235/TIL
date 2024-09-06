package com.mtakworld.springtx.apply;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.TestConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.EnableMBeanExport;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.transaction.support.TransactionSynchronizationManager;

import net.bytebuddy.utility.nullability.MaybeNull;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@SpringBootTest
public class InternalCallV2Test {
	@Autowired
	CallsService callsService;

	private static void printTxInfo() {
		boolean active = TransactionSynchronizationManager.isActualTransactionActive();
		log.info("active is {}", active);
	}

	@Test
	void printProxy() {
		log.info("callService={}", callsService.getClass());
	}



	@Test
	void externalCall() {
		callsService.external();
	}

	@TestConfiguration
	static class InternalCallV1TestConfiguration {
		@Bean
		CallsService callsService() {
			return new CallsService(internalService());
		}

		@Bean
		InternalService internalService() {
			return new InternalService();
		}
	}

	@Slf4j
	@RequiredArgsConstructor
	static class CallsService {
		private final InternalService internalService;

		public void external() {
			log.info("call external");
			printTxInfo();
			internalService.internal();

		}

	}

	static class InternalService {
		@Transactional
		public void internal() {
			log.info("call internal");
			printTxInfo();
		}
	}
}
