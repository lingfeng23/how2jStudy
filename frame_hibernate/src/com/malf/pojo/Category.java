package com.malf.pojo;

import javax.persistence.*;
import java.util.List;
import java.util.Set;

/**
 * @author malf
 * @description TODO
 * @project how2jStudy
 * @since 2020/10/27
 */
@Entity
@Table(name="category")
public class Category {
	private int id;
	private String name;
	private Set<Product> products;

	@OneToMany(fetch=FetchType.EAGER)
	@JoinColumn(name="cid")
	public Set<Product> getProducts() {
		return products;
	}

	public void setProducts(Set<Product> products) {
		this.products = products;
	}

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
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
