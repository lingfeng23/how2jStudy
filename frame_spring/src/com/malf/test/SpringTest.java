package com.malf.test;

import com.malf.pojo.Category;
import com.malf.pojo.Product;
import com.malf.service.ProductService;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @author malf
 * @description TODO
 * @project how2jStudy
 * @since 2020/10/27
 */
public class SpringTest {
	public static void main(String[] args) {
		ApplicationContext context = new ClassPathXmlApplicationContext(
				new String[]{"applicationContext.xml"});
		ProductService service = (ProductService) context.getBean("service");
		service.doSomeService();

//		Product product = (Product) context.getBean("product");
//		System.out.println(product.getName());
//		System.out.println(product.getCategory().getName());
//		Category category = (Category) context.getBean("category");
//		System.out.println(category.getName());
	}
}
