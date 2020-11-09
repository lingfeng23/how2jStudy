package com.malf.service.impl;

import com.malf.mapper.UserRoleMapper;
import com.malf.pojo.User;
import com.malf.pojo.UserRole;
import com.malf.pojo.UserRoleExample;
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
public class UserRoleServiceImpl implements UserRoleService {
	@Autowired
	UserRoleMapper userRoleMapper;

	public void setRoles(User user, long[] roleIds) {
		// 删除当前用户所有角色
		UserRoleExample example = new UserRoleExample();
		example.createCriteria().andUidEqualTo(user.getId());
		List<UserRole> userRoles = userRoleMapper.selectByExample(example);
		for (UserRole userRole : userRoles) {
			userRoleMapper.deleteByPrimaryKey(userRole.getUid());
		}
		// 设置新的角色关系
		if (null != roleIds) {
			for (Long rid : roleIds) {
				UserRole userRole = new UserRole();
				userRole.setRid(rid);
				userRole.setUid(user.getId());
				userRoleMapper.insert(userRole);
			}
		}
	}

	public void deleteByUser(long userId) {
		UserRoleExample example = new UserRoleExample();
		example.createCriteria().andUidEqualTo(userId);
		List<UserRole> userRoles = userRoleMapper.selectByExample(example);
		for (UserRole userRole: userRoles			) {
			userRoleMapper.deleteByPrimaryKey(userRole.getId());
		}
	}

	public void deleteByRole(long roleId) {
		UserRoleExample example = new UserRoleExample();
		example.createCriteria().andRidEqualTo(roleId);
		List<UserRole> userRoles = userRoleMapper.selectByExample(example);
		for (UserRole userRole: userRoles			) {
			userRoleMapper.deleteByPrimaryKey(userRole.getId());
		}
	}
}
