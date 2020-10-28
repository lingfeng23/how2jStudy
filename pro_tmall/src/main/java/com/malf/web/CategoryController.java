package com.malf.web;

import com.malf.pojo.Category;
import com.malf.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @author malf
 * @description TODO
 * @project how2jStudy
 * @since 2020/10/28
 */
@RestController
public class CategoryController {
	@Autowired
	CategoryService categoryService;

	@GetMapping("/categories")
	public List<Category> categories() throws Exception {
		System.out.println(categoryService.categories().size());
		return categoryService.categories();
	}
}
