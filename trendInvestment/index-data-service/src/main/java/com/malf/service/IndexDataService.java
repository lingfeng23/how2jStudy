package com.malf.service;

import cn.hutool.core.collection.CollUtil;
import com.malf.pojo.IndexData;
import org.springframework.cache.annotation.CacheConfig;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author malf
 * @description 从 redis 获取数据服务类
 * @project trendInvestment
 * @since 2020/11/6
 */
@Service
@CacheConfig(cacheNames = "index_datas")
public class IndexDataService {
	@Cacheable(key = "'indexData-code-'+ #p0")
	public List<IndexData> get(String code) {
		return CollUtil.toList();
	}
}
