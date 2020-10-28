package com.malf.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

/**
 * @author malf
 * @description 后台管理页面跳转专用控制器。
 * @project how2jStudy
 * @since 2020/10/28
 */
@Controller
public class AdminPageController {

	@GetMapping(value = "/admin")
	public String admin() {
		return "redirect:admin_category_list";
	}

	@GetMapping(value = "/admin_category_list")
	public String listCategory() {
		return "admin/listCategory";
	}
}
