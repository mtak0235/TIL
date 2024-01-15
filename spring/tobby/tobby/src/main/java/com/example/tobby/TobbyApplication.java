package com.example.tobby;

import com.example.tobby.user.dao.DaoFactory;
import com.example.tobby.user.dao.UserDao;
import com.example.tobby.user.domain.User;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.sql.SQLException;

@SpringBootApplication
public class TobbyApplication {

  public static void main(String[] args) throws SQLException, ClassNotFoundException {
    SpringApplication.run(TobbyApplication.class, args);
  }

}
