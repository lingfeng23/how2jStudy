package hsqldb;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

/**
 * @author malf
 * @description hsqldb JDBC示例
 * @project how2jStudy
 * @since 2020/10/23
 */
public class JDBCDemo {
	public static void main(String[] args) throws Exception {
		Class.forName("org.hsqldb.jdbcDriver");
		String url = "jdbc:hsqldb:file:E:/malf/how2jStudy/database/test";
		Connection connection = DriverManager.getConnection(url, "root", "password");
		Statement statement = connection.createStatement();
		ResultSet set = statement.executeQuery("select * from category");
		while (set.next()) {
			int id = set.getInt("id");
			String name = set.getString("name");
			System.out.println(id + "==" + name);
		}
		statement.close();
		connection.close();
	}
}
