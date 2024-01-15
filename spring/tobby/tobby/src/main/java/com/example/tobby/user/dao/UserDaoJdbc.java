package com.example.tobby.user.dao;

import com.example.tobby.user.domain.Level;
import com.example.tobby.user.domain.User;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

import javax.sql.DataSource;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

public class UserDaoJdbc implements UserDao {

  private final RowMapper<User> userMapper = new RowMapper<>() {
    @Override
    public User mapRow(ResultSet rs, int rowNum) throws SQLException {
      User user = new User();
      user.setId(rs.getString("id"));
      user.setName(rs.getString("name"));
      user.setPassword(rs.getString("password"));
      user.setEmail(rs.getString("email"));
      user.setLevel(Level.valueOf(rs.getInt("level")));
      user.setLogin(rs.getInt("login"));
      user.setRecommend(rs.getInt("recommend"));
      return user;
    }
  };
  private JdbcTemplate jdbcTemplate;

  public void setDataSource(DataSource dataSource) {
    this.jdbcTemplate = new JdbcTemplate(dataSource);
  }

  public void add(User user) {
//        jdbcContext.workWithStatementStrategy(new StatementStrategy() {
//
//            @Override
//            public PreparedStatement makePreparedStatement(Connection connection) throws SQLException {
//                PreparedStatement ps = connection.prepareStatement(
//                        "insert into users (id, name, password) values (?,?,?)");
//                ps.setString(1, user.getId());
//                ps.setString(2, user.getName());
//                ps.setString(3, user.getPassword());
//                return ps;
//            }
//        });
    this.jdbcTemplate.update(
        "insert into users (id, name, password,email,level, login, recommend) values(?,?,?,?, ?, ?, ?)",
        user.getId(), user.getName(), user.getPassword(), user.getEmail(), user.getLevel()
                                                                               .intValue(),
        user.getLogin(), user.getRecommend());

  }

  public User get(String id) {
//        Connection c = dataSource.getConnection();
//
//        PreparedStatement ps = c.prepareStatement(
//                "select * from users where id = ?"
//        );
//        ps.setString(1, id);
//
//        User user = null;
//        ResultSet rs = ps.executeQuery();
//        if (rs.next()) {
//            user = new User();
//            user.setId(rs.getString("id"));
//            user.setName(rs.getString("name"));
//            user.setPassword(rs.getString("password"));
//        }
//        rs.close();
//        ps.close();
//        c.close();
//        if (user == null) throw new EmptyResultDataAccessException(1);
//        return user;
    return this.jdbcTemplate.queryForObject("select * from users where id=?", new Object[]{id},
        userMapper);
  }

  public void deleteAll() {
    this.jdbcTemplate.update("delete from users");
  }

//    abstract protected PreparedStatement makeStatement(Connection c) throws SQLException;

  public int getCount() {
    return this.jdbcTemplate.queryForObject("select count(*) from users", Integer.class);
  }

  @Override
  public void update(User user) {
    this.jdbcTemplate.update(
        "update users set name=?, password=?, email=?, level=?, login=?, recommend=? where id=?",
        user.getName(), user.getPassword(), user.getEmail(), user.getLevel()
                                                                 .intValue(), user.getLogin(),
        user.getRecommend(), user.getId());
  }

  public List<User> getAll() {

    return this.jdbcTemplate.query("select * from users order by id", userMapper);
  }
}
