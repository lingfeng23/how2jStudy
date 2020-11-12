package com.malf.mapper;

import com.malf.pojo.Category;
import org.apache.ibatis.annotations.*;

import java.util.List;

/**
 * @author malf
 * @description TODO
 * @project frame_springboot
 * @since 2020/11/12
 */
@Mapper
public interface CategoryMapper {
	List<Category> findAll();

	@Insert(" insert into category ( name ) values (#{name}) ")
	public int save(Category category);

	@Delete(" delete from category where id= #{id} ")
	public void delete(int id);

	@Select("select * from category where id= #{id} ")
	public Category get(int id);

	@Update("update category set name=#{name} where id=#{id} ")
	public int update(Category category);
}
