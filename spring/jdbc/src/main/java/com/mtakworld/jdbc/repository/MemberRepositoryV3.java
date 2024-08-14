package com.mtakworld.jdbc.repository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.NoSuchElementException;

import javax.sql.DataSource;

import org.springframework.jdbc.datasource.DataSourceUtils;
import org.springframework.jdbc.support.JdbcUtils;

import com.mtakworld.jdbc.domain.Member;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;

/*
JDBC -TransactionManager
DataSourceUtils.getConnection()
DataSourceUtils.releaseConnection()
 */
@Slf4j
@AllArgsConstructor

public class MemberRepositoryV3 {
	private final DataSource dataSource;

	public Member save(Member member) throws SQLException {
		String sql = "insert into member (member_id, money) values (?,?)";
		PreparedStatement preparedStatement = null;
		Connection connection = null;
		try {
			connection = getConnection();
			preparedStatement = connection.prepareStatement(sql);
			preparedStatement.setString(1, member.getMemberId());
			preparedStatement.setInt(2, member.getMoney());
			preparedStatement.executeUpdate();
			return member;
		} catch (SQLException e) {
			log.info("db error={}", e);
			throw e;
		} finally {
			close(connection, preparedStatement, null);
		}
	}

	private void close(Connection connection, PreparedStatement preparedStatement, ResultSet resultSet) {
		JdbcUtils.closeResultSet(resultSet);
		JdbcUtils.closeStatement(preparedStatement);
		DataSourceUtils.releaseConnection(connection, dataSource);
	}

	private Connection getConnection() throws SQLException {
		Connection connection = DataSourceUtils.getConnection(dataSource);
		log.info("connection={} , class={}", connection, connection.getClass());
		return connection;
	}

	public Member findById(String memberId) throws SQLException {
		String sql = "select * from member where member_id=?";
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		ResultSet resultSet = null;
		try {
			connection = getConnection();
			preparedStatement = connection.prepareStatement(sql);
			preparedStatement.setString(1, memberId);
			resultSet = preparedStatement.executeQuery();
			if (resultSet.next()) {
				Member member = new Member();
				member.setMemberId(resultSet.getString("member_id"));
				member.setMoney(resultSet.getInt("money"));
				return member;
			} else
				throw new NoSuchElementException("member not found memberId=" + memberId);
		} catch (SQLException e) {
			log.error("db error", e);
			throw e;
		} finally {
			close(connection, preparedStatement, resultSet);
		}
	}

	public void update(String memberId, int money) throws SQLException {
		String sql = "update member set money=? where member_id=?";
		Connection connection = null;
		int resultSize;
		PreparedStatement preparedStatement = null;
		try {
			connection = getConnection();
			preparedStatement = connection.prepareStatement(sql);
			preparedStatement.setString(2, memberId);
			preparedStatement.setInt(1, money);
			resultSize = preparedStatement.executeUpdate();
			log.info("resultSize={}", resultSize);

		} catch (SQLException e) {
			log.error("db error", e);
			throw e;
		} finally {
			close(connection, preparedStatement, null);
		}

	}

	public void delete(String memberId) throws SQLException {
		String sql = "delete from member where member_id=?";
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		try {
			connection = getConnection();
			preparedStatement = connection.prepareStatement(sql);
			preparedStatement.setString(1, memberId);
			preparedStatement.executeUpdate();
		} catch (SQLException e) {
			log.error("db error", e);
			throw e;
		} finally {
			close(connection, preparedStatement, null);
		}
	}

	public void deleteAll() throws SQLException {
		String sql = "delete from member";
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		try {
			connection = getConnection();
			preparedStatement = connection.prepareStatement(sql);
			preparedStatement.execute();
		} catch (SQLException e) {
			log.error("db error", e);
			throw e;
		} finally {
			close(connection, preparedStatement, null);
		}

	}

	private void close(Connection connection, Statement statement, ResultSet resultSet) {
		JdbcUtils.closeResultSet(resultSet);
		JdbcUtils.closeStatement(statement);
		DataSourceUtils.releaseConnection(connection, dataSource);

	}
}
