package com.malf.pojo;

/**
 * @author malf
 * @description 产品实体类
 * @project product-service
 * @since 2020/11/6
 */
public class Product {
	// 主键ID
	private int id;
	// 产品名称
	private String name;
	// 产品价格
	private int price;

	public Product(int id, String name, int price) {
		super();
		this.id = id;
		this.name = name;
		this.price = price;
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

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}
}
