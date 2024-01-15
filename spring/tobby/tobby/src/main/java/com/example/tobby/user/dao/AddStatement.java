package com.example.tobby.user.dao;

import com.example.tobby.user.domain.User;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class AddStatement implements StatementStrategy {

  User user;

  public AddStatement(User user) {
    this.user = user;
  }

  @Override
  public PreparedStatement makePreparedStatement(Connection connection) throws SQLException {
    PreparedStatement ps = connection.prepareStatement(
        "insert into users (id, name, password) values (?,?,?)");
    ps.setString(1, user.getId());
    ps.setString(2, user.getName());
    ps.setString(3, user.getPassword());
    return ps;
  }
}
