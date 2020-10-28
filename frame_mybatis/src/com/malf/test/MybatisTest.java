package com.malf.test;

import com.malf.pojo.Category;
import com.malf.pojo.Product;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

/**
 * @author malf
 * @description TODO
 * @project how2jStudy
 * @since 2020/10/28
 */
public class MybatisTest {
	public static void main(String[] args) throws IOException {
		String resource = "mybatis-config.xml";
		InputStream inputStream = Resources.getResourceAsStream(resource);
		SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
		SqlSession session = sqlSessionFactory.openSession();

		// 增加
		Category category = new Category();
		category.setName("笔记本");
		session.insert("addCategory", category);

		// 获取
		Category result = session.selectOne("getCategory", 1);
		if (result == null) {
			System.out.println(result.getName());
		}

		// 修改
		result.setName("修改的名称");
		session.update("updateCategory", result);
		System.out.println(result.getName());

		// 删除
		// session.delete("deleteCategory",result);

		// 列表
		List<Category> categories = session.selectList("listCategory");
		for (Category cat : categories) {
			System.out.println(cat.getName());
		}

		System.out.println("--------------------------------------");
		// 模糊查询
		List<Category> list = session.selectList("listCategoryByName", "电");
		for (Category cat : list) {
			System.out.println(cat.getName());
		}

		List<Category> cs = session.selectList("listCategoryProduct");
		for (Category c : cs) {
			System.out.println(c);
			List<Product> ps = c.getProducts();
			for (Product p : ps) {
				System.out.println("\t" + p);
			}
		}

		session.commit();
		session.close();
	}
}
