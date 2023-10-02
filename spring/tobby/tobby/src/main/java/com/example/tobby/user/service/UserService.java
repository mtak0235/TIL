package com.example.tobby.user.service;

import com.example.tobby.user.domain.User;

import java.sql.SQLException;

public interface UserService {
    void upgradeLevels() throws SQLException;

    void add(User user);
}
