package com.malf.controller;

import com.malf.pojo.Product;
import com.malf.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

/**
 * @author malf
 * @description TODO
 * @project parent
 * @since 2020/11/6
 */
@Controller
@RefreshScope
public class ProductController {
	@Value("${version}")
	String version;

	@Autowired
	ProductService productService;

	@RequestMapping("/products")
	public Object products(Model m) {
		List<Product> ps = productService.listProducts();
		m.addAttribute("ps", ps);
		m.addAttribute("version", version);
		return "products";
	}
}
