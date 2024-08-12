package com.mtakworld.itemservice.typeconverter.formatter;

import static org.assertj.core.api.Assertions.*;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.format.support.DefaultFormattingConversionService;

import com.mtakworld.itemservice.typeconverter.converter.IpPortToStringConverter;
import com.mtakworld.itemservice.typeconverter.converter.StringToIpPortConverter;
import com.mtakworld.itemservice.typeconverter.type.IpPort;

public class FormattingConversionServiceTest {
	@Test
	void formattingConversionService() {
		DefaultFormattingConversionService service = new DefaultFormattingConversionService();
		service.addConverter(new StringToIpPortConverter());
		service.addConverter(new IpPortToStringConverter());
		service.addFormatter(new MyNumberFormatter());

		Integer port = 8989;
		String ip = "123.3.3.1";
		String address = ip + ":" + port;
		assertThat(service.convert(address, IpPort.class)).isEqualTo(new IpPort(ip, port));

		assertThat(service.convert(1000, String.class)).isEqualTo("1,000");
		assertThat(service.convert("1,000", Long.class)).isEqualTo(1000L);
	}
}
