package com.malf.mapper;

import com.malf.pojo.Order;
import org.apache.ibatis.annotations.Many;
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
public interface OrderMapper {
	@Select("select * from `order`")
	@Results({
			@Result(property = "id", column = "id"),
			@Result(property = "orderItems", javaType = List.class, column = "id",
					many = @Many(select = "com.malf.mapper.OrderItemMapper.listByOrder"))
	})
	public List<Order> list();
}
