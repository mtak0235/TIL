package com.mtakworld.itemservice.typeconverter.converter;

import org.springframework.core.convert.converter.Converter;

import com.mtakworld.itemservice.typeconverter.type.IpPort;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class StringToIpPortConverter implements Converter<String, IpPort> {

	@Override
	public IpPort convert(String source) {
		log.info("converter source={}", source);
		String[] strings = source.split(":");
		String ip = strings[0];
		Integer port = Integer.valueOf(strings[1]);
		return new IpPort(ip, port);

	}
}
