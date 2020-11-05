package com.malf.mapper;

import com.malf.pojo.Category;
import org.apache.ibatis.annotations.*;

import java.util.List;

/**
 * @author malf
 * @description TODO
 * @project how2jStudy
 * @since 2020/11/5
 */
public interface CategoryMapper {
	@Insert("insert into category (name) values (#{name})")
	public int add(Category category);

	@Delete(" delete from category where id= #{id} ")
	public void delete(int id);

	@Select("select * from category where id= #{id} ")
	public Category get(int id);

	@Update("update category set name = #{name} where id = #{id} ")
	public int update(Category category);

	@Select(" select * from category")
	@Results({
			@Result(property = "id", column = "id"),
			@Result(property = "products", javaType = List.class, column = "id",
					many = @Many(select = "com.malf.mapper.ProductMapper.listByCategory"))
	})
	public List<Category> list();
}
