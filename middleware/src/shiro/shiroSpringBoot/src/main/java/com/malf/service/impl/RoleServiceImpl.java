package com.malf.service.impl;

import com.malf.mapper.RoleMapper;
import com.malf.mapper.UserRoleMapper;
import com.malf.pojo.*;
import com.malf.service.RoleService;
import com.malf.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * @author malf
 * @description TODO
 * @project shiroSpringBoot
 * @since 2020/11/9
 */
@Service
public class RoleServiceImpl implements RoleService {
	@Autowired
	RoleMapper roleMapper;
	@Autowired
	UserRoleMapper userRoleMapper;
	@Autowired
	UserService userService;

	@Override
	public Set<String> listRoleNames(String userName) {
		Set<String> result = new HashSet<>();
		List<Role> roles = listRoles(userName);
		for (Role role : roles) {
			result.add(role.getName());
		}
		return result;
	}

	@Override
	public List<Role> listRoles(String userName) {
		List<Role> roles = new ArrayList<>();
		User user = userService.getByName(userName);
		if (null == user) {
			return roles;
		}
		roles = listRoles(user);
		return roles;
	}

	@Override
	public List<Role> listRoles(User user) {
		List<Role> roles = new ArrayList<>();
		UserRoleExample example = new UserRoleExample();
		example.createCriteria().andUidEqualTo(user.getId());
		List<UserRole> userRoles = userRoleMapper.selectByExample(example);
		for (UserRole userRole : userRoles) {
			Role role = roleMapper.selectByPrimaryKey(userRole.getRid());
			roles.add(role);
		}
		return roles;
	}

	@Override
	public List<Role> list() {
		RoleExample example = new RoleExample();
		example.setOrderByClause("id desc");
		return roleMapper.selectByExample(example);
	}

	@Override
	public void add(Role role) {
		roleMapper.insert(role);
	}

	@Override
	public void delete(Long id) {
		roleMapper.deleteByPrimaryKey(id);
	}

	@Override
	public Role get(Long id) {
		return null;
	}

	@Override
	public void update(Role role) {
		roleMapper.updateByPrimaryKeySelective(role);
	}
}
