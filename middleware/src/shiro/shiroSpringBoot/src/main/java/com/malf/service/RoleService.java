package com.malf.service;

import com.malf.pojo.Role;
import com.malf.pojo.User;

import java.util.List;
import java.util.Set;

/**
 * @author malf
 * @description 角色服务类
 * @project shiroSpringBoot
 * @since 2020/11/9
 */
public interface RoleService {
	public Set<String> listRoleNames(String userName);

	public List<Role> listRoles(String userName);

	public List<Role> listRoles(User user);

	public List<Role> list();

	public void add(Role role);

	public void delete(Long id);

	public Role get(Long id);

	public void update(Role role);
}
