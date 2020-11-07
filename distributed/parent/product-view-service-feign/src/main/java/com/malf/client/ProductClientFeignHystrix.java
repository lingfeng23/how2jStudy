package com.malf.client;

import com.malf.pojo.Product;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

/**
 * @author malf
 * @description TODO
 * @project parent
 * @since 2020/11/7
 */
@Component
public class ProductClientFeignHystrix implements ProductClientFeign {
	public List<Product> listProdcuts() {
		List<Product> result = new ArrayList<>();
		result.add(new Product(0, "产品数据微服务不可用", 0));
		return result;
	}
}
