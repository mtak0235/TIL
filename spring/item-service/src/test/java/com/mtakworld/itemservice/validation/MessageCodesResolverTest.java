package com.mtakworld.itemservice.validation;

import static org.assertj.core.api.Assertions.*;

import java.util.Arrays;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.validation.DefaultMessageCodesResolver;
import org.springframework.validation.MessageCodesResolver;
import org.springframework.validation.ObjectError;

public class MessageCodesResolverTest {
	MessageCodesResolver codesResolver = new DefaultMessageCodesResolver();

	@Test
	void messageCodesResolverObject() {
		String[] codes = codesResolver.resolveMessageCodes("required", "item");
		System.out.println("codes = " + Arrays.toString(codes));
		assertThat(codes).containsExactly("required.item", "required");
	}

	@Test
	void messageCodesResolverField() {
		String[] codes = codesResolver.resolveMessageCodes("required", "item", "itemName", String.class);
		System.out.println("codes = " + Arrays.toString(codes));
		assertThat(codes).containsExactly("required.item.itemName", "required.itemName", "required.java.lang.String", "required");
	}
}
