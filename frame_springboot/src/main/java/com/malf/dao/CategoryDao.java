package com.malf.dao;

import com.malf.pojo.Category;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @author malf
 * @description TODO
 * @project frame_springboot
 * @since 2020/11/12
 */
public interface CategoryDao extends JpaRepository<Category,Integer> {
}
