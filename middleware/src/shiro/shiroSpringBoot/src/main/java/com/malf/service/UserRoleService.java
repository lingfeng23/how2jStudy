package com.malf.service;

import com.malf.pojo.User;

/**
 * @author malf
 * @description 用户角色服务类
 * @project shiroSpringBoot
 * @since 2020/11/9
 */
public interface UserRoleService {
	public void setRoles(User user, long[] roleIds);

	public void deleteByUser(long userId);

	public void deleteByRole(long roleId);
}
