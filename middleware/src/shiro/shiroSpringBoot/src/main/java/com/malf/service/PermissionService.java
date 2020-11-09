package com.malf.service;

import com.malf.pojo.Permission;
import com.malf.pojo.Role;

import java.util.List;
import java.util.Set;

/**
 * @author malf
 * @description 权限服务类
 * @project shiroSpringBoot
 * @since 2020/11/9
 */
public interface PermissionService {
	public Set<String> listPermissions(String userName);

	public List<Permission> list();

	public void add(Permission permission);

	public void delete(Long id);

	public Permission get(Long id);

	public void update(Permission permission);

	public List<Permission> list(Role role);
}
