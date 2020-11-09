package com.malf.service;

import com.malf.pojo.Role;
import com.malf.pojo.User;

/**
 * @author malf
 * @description 角色权限服务类
 * @project shiroSpringBoot
 * @since 2020/11/9
 */
public interface RolePermissionService {
	public void setPermissions(Role role, long[] permissionIds);

	public void deleteByRole(long roleId);

	public void deleteByPermission(long permissionId);
}
