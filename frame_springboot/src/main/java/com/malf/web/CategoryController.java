package com.malf.web;

import com.malf.mapper.CategoryMapper;
import com.malf.pojo.Category;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

/**
 * @author malf
 * @description TODO
 * @project frame_springboot
 * @since 2020/11/12
 */
@Controller
public class CategoryController {
	@Autowired
	CategoryMapper categoryMapper;

	@RequestMapping("/listCategory")
	public String listCategory(Model m) throws Exception {
		List<Category> cs = categoryMapper.findAll();
		m.addAttribute("cs", cs);
		return "listCategory";
	}

}
