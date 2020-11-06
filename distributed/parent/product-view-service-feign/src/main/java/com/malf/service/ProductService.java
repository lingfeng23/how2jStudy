package com.malf.service;

import com.malf.client.ProductClientFeign;
import com.malf.pojo.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author malf
 * @description TODO
 * @project parent
 * @since 2020/11/6
 */
@Service
public class ProductService {
	@Autowired
	ProductClientFeign productClientFeign;

	public List<Product> listProducts() {
		return productClientFeign.listProdcuts();

	}
}
