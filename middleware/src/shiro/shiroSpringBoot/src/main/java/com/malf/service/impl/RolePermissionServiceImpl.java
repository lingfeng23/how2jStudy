package com.malf.service.impl;

import com.malf.mapper.RolePermissionMapper;
import com.malf.mapper.UserRoleMapper;
import com.malf.pojo.*;
import com.malf.service.RolePermissionService;
import com.malf.service.UserRoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author malf
 * @description 用户角色服务类
 * @project shiroSpringBoot
 * @since 2020/11/9
 */
@Service
public class RolePermissionServiceImpl implements RolePermissionService {
	@Autowired
	RolePermissionMapper rolePermissionMapper;

	@Override
	public void setPermissions(Role role, long[] permissionIds) {
		// 删除当前角色所有权限
		RolePermissionExample example = new RolePermissionExample();
		example.createCriteria().andRidEqualTo(role.getId());
		List<RolePermission> rolePermissions = rolePermissionMapper.selectByExample(example);
		for (RolePermission rolePermission : rolePermissions) {
			rolePermissionMapper.deleteByPrimaryKey(rolePermission.getRid());
		}
		// 设置新的权限关系
		if (null != permissionIds) {
			for (Long pid : permissionIds) {
				RolePermission rolePermission = new RolePermission();
				rolePermission.setPid(pid);
				rolePermission.setRid(role.getId());
				rolePermissionMapper.insert(rolePermission);
			}
		}
	}

	@Override
	public void deleteByRole(long roleId) {
		RolePermissionExample example = new RolePermissionExample();
		example.createCriteria().andRidEqualTo(roleId);
		List<RolePermission> rolePermissions = rolePermissionMapper.selectByExample(example);
		for (RolePermission rolePermission : rolePermissions)
			rolePermissionMapper.deleteByPrimaryKey(rolePermission.getId());
	}

	@Override
	public void deleteByPermission(long permissionId) {
		RolePermissionExample example = new RolePermissionExample();
		example.createCriteria().andPidEqualTo(permissionId);
		List<RolePermission> rolePermissions = rolePermissionMapper.selectByExample(example);
		for (RolePermission rolePermission : rolePermissions)
			rolePermissionMapper.deleteByPrimaryKey(rolePermission.getId());
	}
}
