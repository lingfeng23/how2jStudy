package annotation;

import java.sql.Connection;
import java.sql.DriverManager;

/**
 * @author malf
 * @description 注解方式的数据库工具类
 * @project how2jStudy
 * @since 2020/9/15
 */
@DBConfig(ip = "127.0.0.1",
		database = "mybatis",
		encoding = "UTF-8",
		user = "root",
		password = "malinfei921020")
public class DBUtilAnnotation {
	static {
		try {
			Class.forName("com.mysql.jdbc.Driver");
		} catch (ClassNotFoundException e) {
		}
	}

	public static Connection getConnection() throws Exception {
		DBConfig config = DBUtilAnnotation.class.getAnnotation(DBConfig.class);
		String ip = config.ip();
		int port = config.port();
		String database = config.database();
		String encoding = config.encoding();
		String user = config.user();
		String password = config.password();
		String url = String.format("jdbc:mysql://%s:%d/%s?characterEncoding=%s",
				ip, port, database, encoding);
		return DriverManager.getConnection(url, user, password);
	}

	public static void main(String[] args) throws Exception {
		// 输出内容则连接正常
		System.out.println(getConnection());
	}

}
