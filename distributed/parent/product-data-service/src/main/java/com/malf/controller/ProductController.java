package com.malf.controller;

import com.malf.pojo.Product;
import com.malf.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @author malf
 * @description 产品控制类
 * @project parent
 * @since 2020/11/6
 */
@RestController
public class ProductController {
	@Autowired
	ProductService productService;

	@RequestMapping("/products")
	public Object products() {
		List<Product> ps = productService.listProducts();
		return ps;
	}
}
