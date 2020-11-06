package com.malf.client;

import cn.hutool.core.collection.CollectionUtil;
import com.malf.pojo.IndexData;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * @author malf
 * @description TODO
 * @project trendInvestment
 * @since 2020/11/6
 */
@Component
public class IndexDataClientFeignHystrix implements IndexDataClient {
	@Override
	public List<IndexData> getIndexData(String code) {
		IndexData indexData = new IndexData();
		indexData.setClosePoint(0);
		indexData.setDate("0000-00-00");
		return CollectionUtil.toList(indexData);
	}
}
