package com.mtakworld.basic.singleton;

import static org.assertj.core.api.Assertions.*;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class SingletonService {
	private static final SingletonService instance = new SingletonService();

	private SingletonService() {
	}

	public static SingletonService getInstance() {
		return instance;
	}

	public void logic() {
		System.out.println("executed logic");
	}

	@Test
	@DisplayName("use singleton instance")
	void singletonServiceTest() {
		SingletonService instance = SingletonService.getInstance();
		SingletonService instance2 = SingletonService.getInstance();
		assertThat(instance).isSameAs(instance2);
	}
}
