package com.malf.test;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.malf.mapper.CategoryMapper;
import com.malf.mapper.OrderMapper;
import com.malf.mapper.ProductMapper;
import com.malf.pojo.Category;
import com.malf.pojo.Order;
import com.malf.pojo.OrderItem;
import com.malf.pojo.Product;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

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
		CategoryMapper categoryMapper = session.getMapper(CategoryMapper.class);
		ProductMapper productMapper = session.getMapper(ProductMapper.class);
		OrderMapper orderMapper = session.getMapper(OrderMapper.class);
		// Category
//		// 增加
//		Category category = new Category();
//		category.setName("笔记本");
//		session.insert("addCategory", category);
//
//		// 获取
//		Category result = session.selectOne("getCategory", 1);
//		if (result == null) {
//			System.out.println(result.getName());
//		}
//
//		// 修改
//		result.setName("修改的名称");
//		session.update("updateCategory", result);
//		System.out.println(result.getName());
//
//		// 删除
//		// session.delete("deleteCategory",result);
//
//		// 列表
//		List<Category> categories = session.selectList("listCategory");
//		for (Category cat : categories) {
//			System.out.println(cat.getName());
//		}
//
//		System.out.println("--------------------------------------");
//		// 模糊查询
//		List<Category> list = session.selectList("listCategoryByName", "电");
//		for (Category cat : list) {
//			System.out.println(cat.getName());
//		}
//
//		List<Category> cs = session.selectList("listCategoryProduct");
//		for (Category c : cs) {
//			System.out.println(c);
//			List<Product> ps = c.getProducts();
//			for (Product p : ps) {
//				System.out.println("\t" + p);
//			}
//		}

		// Product
//		System.out.println("查询所有的");
//		List<Product> ps = session.selectList("listProduct");
//		for (Product p : ps) {
//			System.out.println(p);
//		}
//
//		System.out.println("模糊查询");
//		Map<String, Object> params = new HashMap<>();
//		params.put("name", "iphone");
//
//		List<Product> ps1 = session.selectList("listProductByName", params);
//		for (Product p : ps1) {
//			System.out.println(p);
//		}
//
//		Product product = new Product();
//		product.setId(7);
//		product.setName("iphone12Pro");
//		product.setPrice(12000);
//		session.update("updateProduct", product);
//
//		System.out.println("多条件查询");
//		params.put("price", "3000");
//		List<Product> ps2 = session.selectList("listProduct", params);
//		for (Product p : ps2) {
//			System.out.println(p);
//		}
//
//		System.out.println("通过多个ID查询");
//		List<Integer> ids = new ArrayList<>();
//		ids.add(3);
//		ids.add(5);
//		ids.add(7);
//		List<Product> ps3 = session.selectList("listProductInIds", ids);
//		for (Product p : ps3) {
//			System.out.println(p);
//		}

		// Category(注解方式)
		// 新增
//		Category category = new Category();
//		category.setName("床前明月光");
//		categoryMapper.add(category);
//
//		// 开启事务后在同一事务中的操作同进退
//		Category longCategory = new Category();
//		longCategory.setName("床前明月光，疑是地上霜。举头望明月，低头思故乡。床前明月光，疑是地上霜。举头望明月，低头思故乡。");
//		categoryMapper.add(longCategory);

//
//		// 获取 & 更新
//		category = categoryMapper.get(2);
//		category.setName("办公用品");
//		categoryMapper.update(category);
//
//		// 查询
//		List<Category> categories = categoryMapper.list();
//		for (Category cat : categories) {
//			System.out.println(cat.getName());
//		}

		// 注解(一对多关系)
//		List<Category> categories = categoryMapper.list();
//		for (Category cat : categories) {
//			System.out.println(cat.getName());
//			List<Product> products = cat.getProducts();
//			if (products != null) {
//				for (Product pro : products) {
//					System.out.println("\t" + pro.getName());
//				}
//			}
//
//		}

		// 注解(多对一关系)
//		List<Product> products = productMapper.list();
//		for (Product pro : products) {
//			System.out.println(pro.getName() + "对应的分类：" + pro.getCategory().getName());
//		}

		// 注解(多对多关系)
//		List<Order> orders = orderMapper.list();
//		for (Order o : orders) {
//			System.out.println(o.getCode());
//			List<OrderItem> ois = o.getOrderItems();
//			if (null != ois) {
//				for (OrderItem oi : ois) {
//					System.out.format("\t%s\t%f\t%d%n", oi.getProduct().getName(),
//							oi.getProduct().getPrice(), oi.getNumber());
//				}
//			}
//
//		}

		// 分页
//		List<Category> cs = categoryMapper.listByPage(0, 5);
//		for (Category c : cs) {
//			System.out.println(c);
//		}

		// PageHelper 插件
		PageHelper.offsetPage(0, 5);

		List<Category> cs = session.selectList("listCategoryByPage");
		for (Category c : cs) {
			System.out.println(c.getName());
		}
		PageInfo pageInfo = new PageInfo<>(cs);
		System.out.println("总数：" + pageInfo.getTotal());
		System.out.println(pageInfo);

		session.commit();
		session.close();
	}
}
