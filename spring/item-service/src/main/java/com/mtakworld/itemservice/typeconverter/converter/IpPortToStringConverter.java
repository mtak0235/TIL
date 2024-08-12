package com.mtakworld.itemservice.typeconverter.converter;

import org.springframework.core.convert.converter.Converter;

import com.mtakworld.itemservice.typeconverter.type.IpPort;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class IpPortToStringConverter implements Converter<IpPort, String> {
	@Override
	public String convert(IpPort source) {
		log.info("converter sourcr={}", source);
		return source.getIp() + ":" + source.getPort();
	}
}