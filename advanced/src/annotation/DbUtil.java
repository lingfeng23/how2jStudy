package annotation;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 * @author malf
 * @description 非注解方式的数据库工具类
 * @project how2jStudy
 * @since 2020/9/15
 */
public class DbUtil {
	static String ip = "127.0.0.1";
	static int port = 3306;
	static String database = "mybatis";
	static String encoding = "UTF-8";
	static String user = "root";
	static String password = "malinfei921020";
	static {
		try {
			Class.forName("com.mysql.jdbc.Driver");
		} catch (ClassNotFoundException e) {
		}
	}
	public static Connection getConnection() throws SQLException {
		String url = String.format("jdbc:mysql://%s:%d/%s?characterEncoding=%s",
				ip, port, database, encoding);
		return DriverManager.getConnection(url, user, password);
	}

	public static void main(String[] args) throws Exception {
		// 输出内容则连接正常
		System.out.println(getConnection());
	}
}
