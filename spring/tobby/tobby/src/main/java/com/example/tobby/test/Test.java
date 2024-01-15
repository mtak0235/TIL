package com.example.tobby.test;

import org.springframework.jdbc.datasource.SimpleDriverDataSource;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class Test {

  public void test1() throws SQLException {
    Connection c = new SimpleDriverDataSource().getConnection();
    c.setAutoCommit(false); //transaction 시작!
    try {
      PreparedStatement st1 = c.prepareStatement("update users set ..");
      st1.executeUpdate();
      PreparedStatement st2 = c.prepareStatement("delete users ...");
      st2.executeUpdate();
      c.commit(); //transaction commit!
    } catch (Exception e) {
      c.rollback();
    }
    c.close();
  }

}
