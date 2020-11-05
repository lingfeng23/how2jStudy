package com.malf.controller;

import com.malf.pojo.Index;
import com.malf.service.IndexService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @author malf
 * @description TODO
 * @project trendInvestment
 * @since 2020/11/5
 */
@RestController
public class IndexController {
	@Autowired
	IndexService indexService;

	@GetMapping("/getCodes")
	public List<Index> get() throws Exception {
		return indexService.fetch_indexes_from_third_part();
	}
}
