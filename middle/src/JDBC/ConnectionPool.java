package JDBC;

import java.sql.Connection;
import java.sql.Driver;
import java.sql.DriverManager;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

/**
 * @author malf
 * @description 数据库连接池
 * @project how2jStudy
 * @since 2020/10/22
 */
public class ConnectionPool {
	List<Connection> connections = new ArrayList<>();
	int size;

	public ConnectionPool(int size) {
		this.size = size;
		init();
	}

	public void init() {
		try {
			Class.forName("com.mysql.jdbc.Driver");
			for (int i = 0; i < size; i++) {
				Connection connection = DriverManager.getConnection(
						"jdbc:mysql://127.0.0.1:3306/mybatis?characterEncoding=UTF-8",
						"root", "password");
				connections.add(connection);
			}
		} catch (Exception e) {
		}
	}

	public synchronized Connection getConnection() {
		while (connections.isEmpty()) {
			try {
				this.wait();
			} catch (InterruptedException e) {
			}
		}
		Connection connection = connections.remove(0);
		return connection;
	}

	public synchronized void returnConnection(Connection connection) {
		connections.add(connection);
		this.notifyAll();
	}
}
