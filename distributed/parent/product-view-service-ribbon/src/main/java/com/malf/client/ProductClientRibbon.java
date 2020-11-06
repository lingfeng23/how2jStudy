package com.malf.client;

import com.malf.pojo.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import java.util.List;

/**
 * @author malf
 * @description TODO
 * @project parent
 * @since 2020/11/6
 */
@Component
public class ProductClientRibbon {
	@Autowired
	RestTemplate restTemplate;

	public List<Product> listProdcuts() {
		return restTemplate.getForObject("http://PRODUCT-DATA-SERVICE/products", List.class);
	}
}
