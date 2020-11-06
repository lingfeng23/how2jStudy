package com.malf.service;

import cn.hutool.core.collection.CollUtil;
import com.malf.pojo.Index;
import org.springframework.cache.annotation.CacheConfig;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author malf
 * @description TODO
 * @project trendInvestment
 * @since 2020/11/6
 */
@Service
@CacheConfig(cacheNames = "indexes")
public class IndexService {
	private List<Index> indexes;

	@Cacheable(key = "'all_codes'")
	public List<Index> get() {
		Index index = new Index();
		index.setName("无效指数代码");
		index.setCode("000000");
		return CollUtil.toList(index);
	}
}
