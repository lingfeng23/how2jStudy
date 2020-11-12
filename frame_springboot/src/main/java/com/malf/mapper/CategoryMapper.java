package com.malf.mapper;

import com.malf.pojo.Category;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
 * @author malf
 * @description TODO
 * @project frame_springboot
 * @since 2020/11/12
 */
@Mapper
public interface CategoryMapper {
	@Select("select * from category")
	List<Category> findAll();
}
