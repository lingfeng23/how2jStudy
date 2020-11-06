package com.malf.service;

import com.malf.pojo.Product;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * @author malf
 * @description 产品服务类
 * @project product-service
 * @since 2020/11/6
 */
@Service
public class ProductService {
	public List<Product> listProducts() {
		List<Product> products = new ArrayList<>();
		products.add(new Product(1, "product a", 50));
		products.add(new Product(2, "product b", 100));
		products.add(new Product(3, "product c", 150));
		return products;
	}
}
