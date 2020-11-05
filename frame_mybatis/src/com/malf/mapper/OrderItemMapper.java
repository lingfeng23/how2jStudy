package com.malf.mapper;

import com.malf.pojo.OrderItem;
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
public interface OrderItemMapper {
	@Select(" select * from order_item where oid = #{oid}")
	@Results({
			@Result(property = "product", column = "pid",
					one = @One(select = "com.malf.mapper.ProductMapper.get"))
	})
	public List<OrderItem> listByOrder(int oid);
}
