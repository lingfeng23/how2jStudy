package com.malf.mapper;

import com.malf.pojo.Product;
import org.apache.ibatis.annotations.One;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
 * @author malf
 * @description TODO
 * @project how2jStudy
 * @since 2020/11/5
 */
public interface ProductMapper {
	@Select("select * from product where cid = #{cid}")
	public List<Product> listByCategory(int cid);

	@Select(" select * from product")
	@Results({
			@Result(property = "category", column = "cid",
					one = @One(select = "com.malf.mapper.CategoryMapper.get"))
	})
	public List<Product> list();

	@Select("select * from product where id = #{id}")
	public Product get(int id);
}
