package com.malf.client;

import com.malf.pojo.IndexData;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

/**
 * @author malf
 * @description TODO
 * @project trendInvestment
 * @since 2020/11/6
 */
@FeignClient(value = "INDEX-DATA-SERVICE", fallback = IndexDataClientFeignHystrix.class)
public interface IndexDataClient {
	@GetMapping("/data/{code}")
	public List<IndexData> getIndexData(@PathVariable("code") String code);
}
