package com.malf.dao;

import com.malf.pojo.Category;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @author malf
 * @description TODO
 * @project how2jStudy
 * @since 2020/10/28
 */
public interface CategoryDao extends JpaRepository<Category, Integer> {

}
