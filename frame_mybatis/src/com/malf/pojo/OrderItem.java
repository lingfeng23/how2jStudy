package com.malf.pojo;

/**
 * @author malf
 * @description TODO
 * @project how2jStudy
 * @since 2020/11/5
 */
public class OrderItem {
	private int id;
	private int number;
	private Order order;
	private Product product;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getNumber() {
		return number;
	}

	public void setNumber(int number) {
		this.number = number;
	}

	public Order getOrder() {
		return order;
	}

	public void setOrder(Order order) {
		this.order = order;
	}

	public Product getProduct() {
		return product;
	}

	public void setProduct(Product product) {
		this.product = product;
	}
}
