package com.malf;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

/**
 * @author malf
 * @description TODO
 * @project how2jStudy
 * @since 2020/10/28
 */
public class TmallTest {
	public static void main(String[] args) {
		try {
			Class.forName("com.mysql.jdbc.Driver");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		try (Connection coon = DriverManager.getConnection("jdbc:mysql://localhost:3306/how2java?useUnicode=true&characterEncoding=utf8",
				"root", "password");
			 Statement stat = coon.createStatement();
		) {
			for (int i = 0; i < 10; i++) {
				String sqlFormat = "insert into category values (null, '测试分类%d')";
				String sql = String.format(sqlFormat, i);
				stat.execute(sql);
			}
			System.out.println("创建了10条分类数据");
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}
