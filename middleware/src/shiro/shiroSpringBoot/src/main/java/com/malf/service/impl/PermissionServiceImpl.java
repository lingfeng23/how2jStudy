package com.malf.service.impl;

import com.malf.mapper.PermissionMapper;
import com.malf.mapper.RolePermissionMapper;
import com.malf.pojo.*;
import com.malf.service.PermissionService;
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
 * @description 权限服务类
 * @project shiroSpringBoot
 * @since 2020/11/9
 */
@Service
public class PermissionServiceImpl implements PermissionService {
	@Autowired
	PermissionMapper permissionMapper;
	@Autowired
	UserService userService;
	@Autowired
	RoleService roleService;
	@Autowired
	RolePermissionMapper rolePermissionMapper;

	public Set<String> listPermissions(String userName) {
		Set<String> result = new HashSet<>();
		List<Role> roles = roleService.listRoles(userName);
		List<RolePermission> rolePermissions = new ArrayList<>();
		for (Role role : roles) {
			RolePermissionExample example = new RolePermissionExample();
			example.createCriteria().andRidEqualTo(role.getId());
			List<RolePermission> rolePermissionList = rolePermissionMapper.selectByExample(example);
			rolePermissions.addAll(rolePermissionList);
		}
		for (RolePermission rolePermission : rolePermissions) {
			Permission permission = permissionMapper.selectByPrimaryKey(rolePermission.getPid());
			result.add(permission.getName());
		}
		return result;
	}

	public List<Permission> list() {
		PermissionExample example = new PermissionExample();
		example.setOrderByClause("id desc");
		return permissionMapper.selectByExample(example);
	}

	public void add(Permission permission) {
		permissionMapper.insert(permission);
	}

	public void delete(Long id) {
		permissionMapper.deleteByPrimaryKey(id);
	}

	public Permission get(Long id) {
		return permissionMapper.selectByPrimaryKey(id);
	}

	public void update(Permission permission) {
		permissionMapper.updateByPrimaryKeySelective(permission);
	}

	public List<Permission> list(Role role) {
		List<Permission> result = new ArrayList<>();
		RolePermissionExample example = new RolePermissionExample();
		example.createCriteria().andRidEqualTo(role.getId());
		List<RolePermission> rolePermissions = rolePermissionMapper.selectByExample(example);
		for (RolePermission rolePermission : rolePermissions) {
			result.add(permissionMapper.selectByPrimaryKey(rolePermission.getPid()));
		}
		return result;
	}
}
