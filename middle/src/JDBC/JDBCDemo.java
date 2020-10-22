package JDBC;

import java.sql.*;

/**
 * @author malf
 * @description JDBC示例
 * @project how2jStudy
 * @since 2020/10/22
 */
public class JDBCDemo {
	public static void main(String[] args) {
		try {
			// 初始化驱动
			Class.forName("com.mysql.jdbc.Driver");
			System.out.println("数据库驱动加载成功");

			Connection connection = DriverManager.getConnection(
					"jdbc:mysql://127.0.0.1:3306/mybatis?characterEncoding=UTF-8",
					"root", "password");
			System.out.println("连接成功，获取连接对象：" + connection);
			// 获取数据库表的元数据
			DatabaseMetaData metaData = connection.getMetaData();
			System.out.println("数据库产品名称：" + metaData.getDatabaseProductName());
			System.out.println("数据库产品版本号：" + metaData.getDatabaseProductVersion());
			System.out.println("数据库和表分隔符：" + metaData.getCatalogSeparator());
			System.out.println("驱动版本号：" + metaData.getDriverVersion());
			System.out.println("可用的数据列表：");
			ResultSet result = metaData.getCatalogs();
			while (result.next()) {
				System.out.println("数据库名称：" + result.getString(1));
			}



			Statement statement = connection.createStatement();
			String sql = "select * from user";
			ResultSet set = statement.executeQuery(sql);
			while (set.next()) {
				int id = set.getInt("id");
				String username = set.getString(2);
				System.out.println(id + "--" + username);
			}
		} catch (ClassNotFoundException e) {
		} catch (SQLException e) {
		}
	}
}
