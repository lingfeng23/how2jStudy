package com.malf.client;

import com.malf.pojo.Product;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

/**
 * @author malf
 * @description TODO
 * @project parent
 * @since 2020/11/6
 */
@FeignClient(value = "PRODUCT-DATA-SERVICE", fallback = ProductClientFeignHystrix.class)
public interface ProductClientFeign {
	@GetMapping("/products")
	public List<Product> listProdcuts();
}
