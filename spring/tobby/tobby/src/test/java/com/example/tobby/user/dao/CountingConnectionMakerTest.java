package com.example.tobby.user.dao;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class CountingConnectionMakerTest {

  @Test
  void makeConnection() {
    AnnotationConfigApplicationContext context =
        new AnnotationConfigApplicationContext(CountingDaoFactory.class);
    UserDao dao = context.getBean("userDao", UserDao.class);
    CountingConnectionMaker ccm = context.getBean("connectionMaker", CountingConnectionMaker.class);
    System.out.println("ccm.getCounter() = " + ccm.getCounter());
  }
}