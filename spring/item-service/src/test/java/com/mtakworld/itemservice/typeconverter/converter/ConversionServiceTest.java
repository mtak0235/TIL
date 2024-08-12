package com.mtakworld.itemservice.typeconverter.converter;

import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.Test;
import org.springframework.core.convert.support.DefaultConversionService;

import com.mtakworld.itemservice.typeconverter.type.IpPort;

public class ConversionServiceTest {
	@Test
	void conversionService() {
		DefaultConversionService service = new DefaultConversionService();
		service.addConverter(new StringToIntegerConverter());
		service.addConverter(new IntegerToStringConverter());
		service.addConverter(new StringToIpPortConverter());
		service.addConverter(new IpPortToStringConverter());
		assertThat(service.convert("10", Integer.class)).isEqualTo(10);
		assertThat(service.convert(10, String.class)).isEqualTo("10");
		assertThat(service.convert(new IpPort("127.0.0.1", 8080), String.class)).isEqualTo("127.0.0.1:8080");
		assertThat(service.convert("127.0.0.1:8080", IpPort.class)).isEqualTo(new IpPort("127.0.0.1", 8080));

	}
}
