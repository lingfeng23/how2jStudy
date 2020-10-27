package com.malf.pojo;

import javax.persistence.*;
import java.util.Set;

/**
 * @author malf
 * @description 实体类-产品
 * @project how2jStudy
 * @since 2020/10/23
 */
@Entity
@Table(name = "product")
public class Product {
	int id;
	String name;
	float price;
	int version;
	Category category;
	Set<User> users;

	@Column(name = "ver")
	public int getVersion() {
		return version;
	}

	public void setVersion(int version) {
		this.version = version;
	}

	@ManyToMany(cascade=CascadeType.ALL,fetch=FetchType.EAGER)
	@JoinTable(
			name="user_product",
			joinColumns=@JoinColumn(name="pid"),
			inverseJoinColumns=@JoinColumn(name="uid")
	)
	public Set<User> getUsers() {
		return users;
	}

	public void setUsers(Set<User> users) {
		this.users = users;
	}

	@ManyToOne
	@JoinColumn(name="cid")
	public Category getCategory() {
		return category;
	}

	public void setCategory(Category category) {
		this.category = category;
	}

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	@Column(name = "name")
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Column(name = "price")
	public float getPrice() {
		return price;
	}

	public void setPrice(float price) {
		this.price = price;
	}
}
