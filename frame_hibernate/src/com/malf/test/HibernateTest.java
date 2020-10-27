package com.malf.test;

import com.malf.pojo.Product;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;


/**
 * @author malf
 * @description TODO
 * @project how2jStudy
 * @since 2020/10/23
 */
public class HibernateTest {
	public static void main(String[] args) {
		SessionFactory factory = new Configuration().configure()
				.buildSessionFactory();
		Session session = factory.openSession();
		session.beginTransaction();

		Product product = new Product();
		product.setName("华为Mate40");
		product.setPrice(6000);
		session.save(product);
		for (int i = 0; i < 10; i++) {
			Product pro = new Product();
			pro.setName("iPhone" + i);
			pro.setPrice(i * 1000);
			session.save(pro);
		}
		session.getTransaction().commit();
		session.close();
		factory.close();
	}
}
