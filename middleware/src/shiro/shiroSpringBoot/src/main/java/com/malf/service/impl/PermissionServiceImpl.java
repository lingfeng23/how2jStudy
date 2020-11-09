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

	@Override
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

	@Override
	public List<Permission> list() {
		PermissionExample example = new PermissionExample();
		example.setOrderByClause("id desc");
		return permissionMapper.selectByExample(example);

	}

	@Override
	public void add(Permission u) {
		permissionMapper.insert(u);
	}

	@Override
	public void delete(Long id) {
		permissionMapper.deleteByPrimaryKey(id);
	}

	@Override
	public Permission get(Long id) {
		return permissionMapper.selectByPrimaryKey(id);
	}

	@Override
	public void update(Permission u) {
		permissionMapper.updateByPrimaryKeySelective(u);
	}


	@Override
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

	@Override
	public boolean needInterceptor(String requestURI) {
		List<Permission> permissions = list();
		for (Permission permission : permissions) {
			if (permission.getUrl().equals(requestURI))
				return true;
		}
		return false;
	}

	@Override
	public Set<String> listPermissionURLs(String userName) {
		Set<String> result = new HashSet<>();
		List<Role> roles = roleService.listRoles(userName);
		List<RolePermission> rolePermissions = new ArrayList<>();
		for (Role role : roles) {
			RolePermissionExample example = new RolePermissionExample();
			example.createCriteria().andRidEqualTo(role.getId());
			List<RolePermission> rps = rolePermissionMapper.selectByExample(example);
			rolePermissions.addAll(rps);
		}
		for (RolePermission rolePermission : rolePermissions) {
			Permission p = permissionMapper.selectByPrimaryKey(rolePermission.getPid());
			result.add(p.getUrl());
		}
		return result;
	}
}