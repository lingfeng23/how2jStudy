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
import java.util.Iterator;
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

		// 查询总数
		Query query = session.createQuery("select count(*) from Product p where p.name like ?");
		query.setString(0, "%" + name + "%");
		long total = (Long) query.uniqueResult();
		System.out.println(total);

		// Hibernate使用Iterator实现N 1顶折
//		Query query = session.createQuery("from Product p where p.name like ?");
//		query.setString(0, "%" + name + "%");
//		Iterator<Product> it = query.iterate();
//		while (it.hasNext()) {
//			Product pro = it.next();
//			System.out.println(pro.getName());
//		}

		// Hibernate 分页
//		Criteria criteria = session.createCriteria(Product.class);
//		criteria.add(Restrictions.like("name", "%" + name + "%"));
//		criteria.setFirstResult(2);
//		criteria.setMaxResults(5);
//		List<Product> products = criteria.list();
//		for (Product pro : products) {
//			System.out.println(pro.getName());
//		}

		// 二级缓存
//		Category category1 = (Category) session.get(Category.class, 2);
//		Category category2 = (Category) session.get(Category.class, 2);

		// 一级缓存
//		System.out.println("AAA");
//		Category category1 = (Category)session.get(Category.class, 2);
//		System.out.println("BBB");
//		Category category2= (Category)session.get(Category.class, 2);
//		System.out.println("CCC");

		// save-update 级联
//		Category category = (Category) session.get(Category.class, 2);
//		Product product1 = new Product();
//		product1.setName("product1");
//		Product product2 = new Product();
//		product2.setName("product2");
//		Product product3 = new Product();
//		product3.setName("product3");
//		category.getProducts().add(product1);
//		category.getProducts().add(product2);
//		category.getProducts().add(product3);

		// delete 级联
//		Category category = (Category) session.get(Category.class, 1);
//		session.delete(category);

		// 关系的延迟加载
//		Category category = (Category) session.get(Category.class, 1);
//		System.out.println("AAA");
//		System.out.println(category.getProducts());
//		System.out.println("BBB");

		// 属性的延迟加载
//		Product product = (Product) session.load(Product.class, 1);
//		System.out.println("AAA");
//		System.out.println(product.getName()); // 访问属性“getName()"的时候，才会访问数据库
//		System.out.println("BBB");

		// Hibernate 事务 -> product1操作可以成功，product2操作失败，则都失败
//		Product product1 = (Product) session.get(Product.class, 1);
//		session.delete(product1);
//		Product product2 = (Product) session.get(Product.class, 2);
//		product2.setName("长度超过30的字符串作为产品名称长度超过30的字符串作为产品名称长度超过30的字符串作为产品名称长度超过30的字符串作为产品名称");
//		session.update(product2);

		// Hibernate 多对多
		// 增加3个用户
//		Set<User> users = new HashSet();
//		for (int i = 0; i < 3; i++) {
//			User user = new User();
//			user.setName("user" + i);
//			users.add(user);
//			session.save(user);
//		}
		// 产品1被用户1,2,3购买
//		Product product = (Product) session.get(Product.class, 1);
//		product.setUsers(users);
//		session.save(product);

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

//		Session session2 = factory.openSession();
//		session2.beginTransaction();
//		Category category3 = (Category) session2.get(Category.class, 2);
//		session2.getTransaction().commit();
//		session2.close();

		factory.close();
	}
}
