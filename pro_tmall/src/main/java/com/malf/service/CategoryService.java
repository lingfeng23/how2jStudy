package com.malf.service;

import com.malf.dao.CategoryDao;
import com.malf.pojo.Category;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author malf
 * @description TODO
 * @project how2jStudy
 * @since 2020/10/28
 */
@Service
public class CategoryService {
	@Autowired
	CategoryDao categoryDao;

	public List<Category> categories() {
		Sort sort = new Sort(Sort.Direction.DESC, "id");
		return categoryDao.findAll(sort);
	}
}
