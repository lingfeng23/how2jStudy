package com.malf.pojo;

import java.util.List;
import java.util.Set;

/**
 * @author malf
 * @description TODO
 * @project how2jStudy
 * @since 2020/10/27
 */
public class Category {
	private int id;
	private String name;
	private Set<Product> products;

	public Set<Product> getProducts() {
		return products;
	}

	public void setProducts(Set<Product> products) {
		this.products = products;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
}
