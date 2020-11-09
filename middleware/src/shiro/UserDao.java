package shiro;

import java.sql.*;
import java.util.HashSet;
import java.util.Set;

/**
 * @author malf
 * @description TODO
 * @project how2jStudy
 * @since 2020/11/9
 */
public class UserDao {
	public UserDao() {
		try {
			Class.forName("com.mysql.jdbc.Driver");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}

	public Connection getConnection() throws SQLException {
		return DriverManager.getConnection(
				"jdbc:mysql://127.0.0.1:3306/how2java?characterEncoding=UTF-8",
				"root", "password");
	}

	public String getPassword(String userName) {
		String sql = "select password from user where name = ?";
		try (Connection connection = getConnection();
			 PreparedStatement preparedStatement = connection.prepareStatement(sql);) {
			preparedStatement.setString(1, userName);
			ResultSet resultSet = preparedStatement.executeQuery();
			if (resultSet.next()) {
				return resultSet.getString("password");
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}

	public Set<String> roles(String userName) {
		Set<String> roles = new HashSet<>();
		String sql = "select r.name from user u "
				+ "left join user_role ur on u.id = ur.uid "
				+ "left join role r on r.id = ur.rid "
				+ "where u.name = ?";
		try (Connection connection = getConnection();
			 PreparedStatement preparedStatement = connection.prepareStatement(sql);) {
			preparedStatement.setString(1, userName);
			ResultSet resultSet = preparedStatement.executeQuery();
			while (resultSet.next()) {
				roles.add(resultSet.getString(1));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return roles;
	}

	public Set<String> permissions(String userName) {
		Set<String> permissions = new HashSet<>();
		String sql = "select p.name from user u "
				+ "left join user_role ur on u.id = ur.uid "
				+ "left join role r on r.id = ur.rid "
				+ "left join role_permission rp on r.id = rp.rid "
				+ "left join permission p on p.id = rp.pid "
				+ "where u.name = ?";
		try (Connection connection = getConnection();
			 PreparedStatement preparedStatement = connection.prepareStatement(sql);) {
			preparedStatement.setString(1, userName);
			ResultSet resultSet = preparedStatement.executeQuery();
			while (resultSet.next()) {
				permissions.add(resultSet.getString(1));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return permissions;
	}

	public static void main(String[] args) {
		UserDao userDao = new UserDao();
		System.out.println(userDao.roles("malf"));
		System.out.println(userDao.roles("lingfeng23"));
		System.out.println(userDao.permissions("malf"));
		System.out.println(userDao.permissions("lingfeng23"));
	}

}
