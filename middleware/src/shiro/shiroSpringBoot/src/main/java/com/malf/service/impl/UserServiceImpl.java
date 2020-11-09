package com.malf.service.impl;

import com.malf.mapper.UserMapper;
import com.malf.pojo.User;
import com.malf.pojo.UserExample;
import com.malf.service.UserRoleService;
import com.malf.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author malf
 * @description 用户服务类
 * @project shiroSpringBoot
 * @since 2020/11/9
 */
@Service
public class UserServiceImpl implements UserService {
	@Autowired
	UserMapper userMapper;
	@Autowired
	UserRoleService userRoleService;

	public String getPassword(String name){
		User user = getByName(name);
		if (null == user) {
			return null;
		}
		return user.getPassword();
	}

	public User getByName(String name) {
		UserExample example = new UserExample();
		example.createCriteria().andNameEqualTo(name);
		List<User> users = userMapper.selectByExample(example);
		if(users.isEmpty()) {
			return null;
		}
		return users.get(0);
 	}

	public List<User> list(){
		UserExample example = new UserExample();
		example.setOrderByClause("id desc");
		return userMapper.selectByExample(example);
	}

	public void add(User user){
		userMapper.insert(user);
	}

	public void delete(Long id){
		userMapper.deleteByPrimaryKey(id);
		userRoleService.deleteByUser(id);

	}

	public User get(Long id) {
		return userMapper.selectByPrimaryKey(id);
	}

	public void update(User user) {
		userMapper.updateByPrimaryKeySelective(user);
	}
}
