package com.mtakworld.itemservice;

import java.util.List;

import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.method.support.HandlerMethodArgumentResolver;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import com.mtakworld.itemservice.web.argumentResolver.LoginMemberArgumentResolver;
import com.mtakworld.itemservice.web.filter.LogFilter;
import com.mtakworld.itemservice.web.filter.LoginCheckFilter;
import com.mtakworld.itemservice.web.interceptor.LogInterceptor;
import com.mtakworld.itemservice.web.interceptor.LoginCheckInterceptor;

import jakarta.servlet.DispatcherType;
import jakarta.servlet.Filter;

@Configuration
public class WebConfig implements WebMvcConfigurer {

	// @Bean
	public FilterRegistrationBean logFilter() {
		FilterRegistrationBean<Filter> filterFilterRegistrationBean = new FilterRegistrationBean<>();
		filterFilterRegistrationBean.setFilter(new LogFilter());
		filterFilterRegistrationBean.setOrder(1);
		filterFilterRegistrationBean.addUrlPatterns("/*");
		filterFilterRegistrationBean.setDispatcherTypes(DispatcherType.ERROR, DispatcherType.REQUEST);

		return filterFilterRegistrationBean;
	}

	// @Bean
	public FilterRegistrationBean loginCheckFilter() {
		FilterRegistrationBean<Filter> filterFilterRegistrationBean = new FilterRegistrationBean<>();
		filterFilterRegistrationBean.setFilter(new LoginCheckFilter());
		filterFilterRegistrationBean.setOrder(2);
		filterFilterRegistrationBean.addUrlPatterns("/*");
		return filterFilterRegistrationBean;
	}

	@Override
	public void addInterceptors(InterceptorRegistry registry) {
		registry.addInterceptor(new LogInterceptor())
				.order(1)
				.addPathPatterns("/**")
				.excludePathPatterns("/css/**", "/*.ico", "/error", "/error-page/**");

		// registry.addInterceptor(new LoginCheckInterceptor())
		// 		.order(2)
		// 		.addPathPatterns("/**")
		// 		.excludePathPatterns("/css/**", "/*.ico", "/error", "/login", "/logout", "/", "members/add");
	}

	@Override
	public void addArgumentResolvers(List<HandlerMethodArgumentResolver> resolvers) {
		resolvers.add(new LoginMemberArgumentResolver());
	}
}
