package com.mtakworld.basic;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.FilterType;

import com.mtakworld.basic.member.MemberRepository;
import com.mtakworld.basic.member.MemoryMemberRepository;

@Configuration
@ComponentScan(
	basePackages = "com.mtakworld.basic",
	basePackageClasses = AutoAppConfig.class,
	excludeFilters = @ComponentScan.Filter(type = FilterType.ANNOTATION, classes = Configuration.class))
public class AutoAppConfig {
	// @Bean(name = "memoryMemberRepository")
	// public MemberRepository memoryMemberRepository() {
	// 	return new MemoryMemberRepository();
	// }
}
