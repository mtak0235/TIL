package com.mtakworld.springtx.order;

import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.*;

import java.util.Optional;

import org.aspectj.weaver.ast.Not;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import lombok.extern.slf4j.Slf4j;

@SpringBootTest
@Slf4j
class OrderServiceTest {
@Autowired
OrderService orderService;
@Autowired
OrderRepository orderRepository;
	@Test
	void order() throws NotEnoughMoneyException {
		Order order = new Order();
		order.setUsername("정상");
		orderService.order(order);
		Order findOrder = orderRepository
			.findById(order.getId())
			.get();
		assertThat(findOrder.getPayStatus())
			.isEqualTo("완료");
	}

	@Test
	void runtimeException() throws NotEnoughMoneyException {
		Order order = new Order();
		order.setUsername("예외");
		Assertions
			.assertThatThrownBy(() -> orderService.order(order))
			.isInstanceOf(RuntimeException.class);

		Optional<Order> findOrder = orderRepository
			.findById(order.getId());
		assertThat(findOrder.isEmpty()).isTrue();
	}

	@Test
	void bizException() throws NotEnoughMoneyException {
		Order order = new Order();
		order.setUsername("잔고부족");
		try {
			orderService.order(order);
		} catch (NotEnoughMoneyException e) {
			log.info("고객에게 잔고 부족을 알리고 별도의 계좌로 입금하도록 안내");
		}
		Order findOrder = orderRepository
			.findById(order.getId())
			.get();
		assertThat(findOrder.getPayStatus()).isEqualTo("대기");
	}
}