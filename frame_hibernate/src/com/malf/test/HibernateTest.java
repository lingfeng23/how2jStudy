package com.malf.test;

import com.malf.pojo.Category;
import com.malf.pojo.Product;
import com.malf.pojo.User;
import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.criterion.Restrictions;

import java.util.HashSet;
import java.util.List;
import java.util.Set;


/**
 * @author malf
 * @description TODO
 * @project how2jStudy
 * @since 2020/10/23
 */
public class HibernateTest {
	public static void main(String[] args) {
		SessionFactory factory = new Configuration().configure().buildSessionFactory();
		Session session = factory.openSession();
		session.beginTransaction();
		String name = "phone";

		// Hibernate 多对多
		// 增加3个用户
		Set<User> users = new HashSet();
		for (int i = 0; i < 3; i++) {
			User user = new User();
			user.setName("user" + i);
			users.add(user);
			session.save(user);
		}

		// 产品1被用户1,2,3购买
		Product product = (Product) session.get(Product.class, 1);
		product.setUsers(users);
		session.save(product);

		// Hibernate 一对多
//		Category category = (Category) session.get(Category.class, 1);
//		Set<Product> products = category.getProducts();
//		for (Product pro : products) {
//			System.out.println(pro.getName());
//		}

		// Hibernate 多对一
//		Category category = new Category();
//		category.setName("书籍");
//		session.save(category);
//		Product product = (Product) session.get(Product.class, 8);
//		product.setCategory(category);
//		session.update(product);

		// 使用标准sql查询
//		String sql = "select * from product where name like '%" + name + "%'";
//		Query query = session.createSQLQuery(sql);
//		List<Object[]> list = query.list();
//		for (Object[] os : list) {
//			for (Object filed : os) {
//				System.out.print(filed + "\t");
//			}
//			System.out.println();
//		}

		// 使用Criteria 查询数据
//		Criteria criteria = session.createCriteria(Product.class);
//		criteria.add(Restrictions.like("name", "%" + name + "%"));
//		List<Product> products = criteria.list();

		// Hql查询数据
//		Query query = session.createQuery("from Product p where p.name like ?");
//		query.setString(0, "%" + name + "%");
//		List<Product> products = query.list();
//		for (Product pro : products) {
//			System.out.println(pro.getName());
//		}
		// 通过id获取对象
//		Product product = (Product) session.get(Product.class, 5);
//		System.out.println("id=5的产品名称是: " + product.getName());
		// 修改一条记录
//		product.setName("iPhone12");
//		session.update(product);
//		System.out.println("id=5的产品名称是: " + product.getName());
		// 删除一条记录
//		session.delete(product);
//		product = (Product) session.get(Product.class, 6);
//		System.out.println(product == null);

		// Hibernate 对象状态
//		Product product = new Product();
//		product.setName("product");
//		System.out.println("此时product是瞬时状态");
//		session.save(product);
//		System.out.println("此时product是持久状态");
//		session.getTransaction().commit();
//		session.close();
//		System.out.println("此时product是脱管状态");
//		factory.close();

		// Hibernate 插入数据
//		Product product = new Product();
//		product.setName("华为Mate40");
//		product.setPrice(6000);
//		session.save(product);
//		for (int i = 0; i < 10; i++) {
//			Product pro = new Product();
//			pro.setName("iPhone" + i);
//			pro.setPrice(i * 1000);
//			session.save(pro);
//		}

		session.getTransaction().commit();
		session.close();
		factory.close();
	}
}
