package com.malf.controller;

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

	// http://127.0.0.1:8001/removeIndexData/000300
	// http://127.0.0.1:8001/getIndexData/000300
	// http://127.0.0.1:8001/freshIndexData/000300

	@GetMapping("/freshIndexData/{code}")
	public String fresh(@PathVariable("code") String code) throws Exception {
		indexDataService.fresh(code);
		return "fresh index data successfully";
	}

	@GetMapping("/getIndexData/{code}")
	public List<IndexData> get(@PathVariable("code") String code) throws Exception {
		return indexDataService.get(code);
	}

	@GetMapping("/removeIndexData/{code}")
	public String remove(@PathVariable("code") String code) throws Exception {
		indexDataService.remove(code);
		return "remove index data successfully";
	}
}
