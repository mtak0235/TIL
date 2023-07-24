package com.example.tobby.user.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class DeleteAllStatement implements StatementStrategy {
    @Override
    public PreparedStatement makePreparedStatement(Connection connection) throws SQLException {
        PreparedStatement ps = connection.prepareStatement("delete from users");
        return ps;
    }
}
