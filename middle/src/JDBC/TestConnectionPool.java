package JDBC;

import sun.nio.ch.ThreadPool;

import javax.tools.StandardJavaFileManager;
import java.sql.Connection;
import java.sql.Statement;

/**
 * @author malf
 * @description 测试数据库连接池
 * @project how2jStudy
 * @since 2020/10/22
 */
public class TestConnectionPool {
	public static void main(String[] args) {
		ConnectionPool pool = new ConnectionPool(3);
		for (int i = 0; i < 100; i++) {
			new WorkThread("工作线程" + i, pool).start();
		}
	}
}

class WorkThread extends Thread {
	private ConnectionPool pool;

	public WorkThread(String name, ConnectionPool pool) {
		super(name);
		this.pool = pool;
	}

	public void run() {
		Connection connection = pool.getConnection();
		System.out.println(this.getName() + ":\t 获取了连接并开始工作");
		try (Statement statement = connection.createStatement()) {
			Thread.sleep(1000);
			statement.execute("select * from user");
		} catch (Exception e) {
		}
		pool.returnConnection(connection);
	}
}
