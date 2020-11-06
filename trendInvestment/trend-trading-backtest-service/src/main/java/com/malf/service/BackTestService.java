package com.malf.service;

import com.malf.client.IndexDataClient;
import com.malf.pojo.IndexData;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.List;

/**
 * @author malf
 * @description 提供所有模拟回测数据的微服务
 * @project trendInvestment
 * @since 2020/11/6
 */
@Service
public class BackTestService {
	@Autowired
	IndexDataClient indexDataClient;

	public List<IndexData> listIndexData(String code) {
		List<IndexData> result = indexDataClient.getIndexData(code);
		Collections.reverse(result);
		for (IndexData indexData : result) {
			System.out.println(indexData.getDate());
		}
		return result;
	}
}
