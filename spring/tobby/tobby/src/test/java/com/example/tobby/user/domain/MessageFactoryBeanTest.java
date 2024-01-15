package com.example.tobby.user.domain;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(SpringExtension.class)
@ContextConfiguration(locations = "/FactoryBeanTest-context.xml")
class MessageFactoryBeanTest {

  @Autowired
  ApplicationContext context;

  @Test
  public void getMessageFromFactoryBean() {
    Object message = context.getBean("message");
    assertThat(message).isInstanceOf(Message.class);
    assertThat(((Message) message).getText()).isEqualTo("Factory bean");
  }

  @Test
  public void getFactoryBean() {
    Object factory = context.getBean("&message");
    assertThat(factory).isInstanceOf(MessageFactoryBean.class);
  }
}