package com.mtakworld.itemservice.typeconverter;

import org.springframework.context.annotation.Configuration;
import org.springframework.format.FormatterRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import com.mtakworld.itemservice.typeconverter.converter.IntegerToStringConverter;
import com.mtakworld.itemservice.typeconverter.converter.IpPortToStringConverter;
import com.mtakworld.itemservice.typeconverter.converter.StringToIntegerConverter;
import com.mtakworld.itemservice.typeconverter.converter.StringToIpPortConverter;
import com.mtakworld.itemservice.typeconverter.formatter.MyNumberFormatter;

@Configuration("webConfig4Converter")
public class WebConfig implements WebMvcConfigurer {

	@Override
	public void addFormatters(FormatterRegistry registry) {
		// registry.addConverter(new StringToIntegerConverter());
		// registry.addConverter(new IntegerToStringConverter());
		registry.addConverter(new IpPortToStringConverter());
		registry.addConverter(new StringToIpPortConverter());

		registry.addFormatter(new MyNumberFormatter());

	}
}
