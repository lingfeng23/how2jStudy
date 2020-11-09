package com.malf.controller;

import com.malf.pojo.Role;
import com.malf.pojo.User;
import com.malf.service.RoleService;
import com.malf.service.UserRoleService;
import com.malf.service.UserService;
import org.apache.shiro.crypto.SecureRandomNumberGenerator;
import org.apache.shiro.crypto.hash.SimpleHash;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author malf
 * @description TODO
 * @project shiroSpringBoot
 * @since 2020/11/9
 */
@Controller
@RequestMapping("config")
public class UserController {
	@Autowired
	UserService userService;
	@Autowired
	RoleService roleService;
	@Autowired
	UserRoleService userRoleService;

	@RequestMapping("listUser")
	public String list(Model model) {
		List<User> users = userService.list();
		model.addAttribute("users", users);
		Map<User, List<Role>> user_roles = new HashMap<>();
		for (User user : users) {
			List<Role> roles = roleService.listRoles(user);
			user_roles.put(user, roles);
		}
		model.addAttribute("user_roles", user_roles);
		return "listUser";
	}

	@RequestMapping("editUser")
	public String edit(Model model, long id) {
		List<Role> roles = roleService.list();
		model.addAttribute("roles", roles);
		User user = userService.get(id);
		model.addAttribute("user", user);
		List<Role> roles1 = roleService.listRoles(user);
		model.addAttribute("currentRoles", roles);
		return "editUser";
	}

	@RequestMapping("deleteUser")
	public String delete(Model model, long id) {
		userService.delete(id);
		return "redirect:listUser";
	}

	@RequestMapping("updateUser")
	public String update(User user, long[] roleIds) {
		userRoleService.setRoles(user, roleIds);
		String password = user.getPassword();
		// 修改时没有设置密码，则不改动密码
		if (user.getPassword().length() != 0) {
			String salt = new SecureRandomNumberGenerator().nextBytes().toString();
			int times = 2;
			String algorithmName = "md5";
			String encodedPassword = new SimpleHash(algorithmName, password, salt, times).toString();
			user.setSalt(salt);
			user.setPassword(encodedPassword);
		} else {
			user.setPassword(null);
		}
		userService.update(user);
		return "redirect:listUser";
	}

	@RequestMapping("addUser")
	public String add(Model model, String name, String password) {
		String salt = new SecureRandomNumberGenerator().nextBytes().toString();
		int times = 2;
		String algorithmName = "md5";
		String encodedPassword = new SimpleHash(algorithmName, password, salt, times).toString();
		User user = new User();
		user.setName(name);
		user.setPassword(encodedPassword);
		user.setSalt(salt);
		userService.add(user);
		return "redirect:listUser";
	}
}
