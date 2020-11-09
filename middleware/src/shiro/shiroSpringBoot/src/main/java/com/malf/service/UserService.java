package com.malf.service;

import com.malf.pojo.User;

import java.util.List;

/**
 * @author malf
 * @description 用户服务类
 * @project shiroSpringBoot
 * @since 2020/11/9
 */
public interface UserService {
	public String getPassword(String name);

	public User getByName(String name);

	public List<User> list();

	public void add(User user);

	public void delete(Long id);

	public User get(Long id);

	public void update(User user);
}
