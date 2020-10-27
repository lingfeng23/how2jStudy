package com.malf.pojo;

import org.springframework.stereotype.Component;

/**
 * @author malf
 * @description TODO
 * @project how2jStudy
 * @since 2020/10/27
 */
@Component("category")
public class Category {
	private int id;
	private String name = "神话";

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
