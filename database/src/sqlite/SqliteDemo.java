package sqlite;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

/**
 * @author malf
 * @description sqlite 示例
 * @project how2jStudy
 * @since 2020/10/23
 */
public class SqliteDemo {
	public static void main(String[] args) {
		try {
			Class.forName("org.sqlite.JDBC");
			// 连接数据库malf.db,不用手动创建
			Connection connection = DriverManager.getConnection("jdbc:sqlite:malf.db");
			// 创建连接对象，是Java的一个操作数据库的重要接口
			Statement statement = connection.createStatement();
			// 判断是否有表tables的存在，有则删除
			statement.executeUpdate("drop table if exists hero");
			// 创建表
			statement.executeUpdate("create table hero(id int,name varchar(20),blood int)");
			//插入数据
			statement.executeUpdate("insert into hero values(1,'Gareen','600')");
			// 搜索数据库，将搜索的放入数据集ResultSet中
			ResultSet set = statement.executeQuery("select * from hero");
			while (set.next()) { // 遍历这个数据集
				System.out.println("id：" + set.getInt(1));
				System.out.println("姓名：" + set.getString(2));
				System.out.println("血量：" + set.getString(3));
			}
			set.close();// 关闭数据集
			connection.close();// 关闭数据库连接
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
