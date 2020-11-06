package com.malf.controller;

import com.malf.config.IpConfiguration;
import com.malf.pojo.IndexData;
import com.malf.service.IndexDataService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @author malf
 * @description TODO
 * @project trendInvestment
 * @since 2020/11/6
 */
@RestController
public class IndexDataController {
	@Autowired
	IndexDataService indexDataService;
	@Autowired
	IpConfiguration ipConfiguration;

	// http://127.0.0.1:8021/data/000300

	@GetMapping("/data/{code}")
	public List<IndexData> get(@PathVariable("code") String code) throws Exception {
		System.out.println("current instance is :" + ipConfiguration.getPort());
		return indexDataService.get(code);
	}
}
