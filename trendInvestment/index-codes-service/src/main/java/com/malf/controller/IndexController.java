package com.malf.controller;

import com.malf.config.IpConfiguration;
import com.malf.pojo.Index;
import com.malf.service.IndexService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @author malf
 * @description TODO
 * @project trendInvestment
 * @since 2020/11/6
 */
@RestController
public class IndexController {
	@Autowired
	IndexService indexService;
	@Autowired
	IpConfiguration ipConfiguration;

	// http://127.0.0.1:8011/codes

	@GetMapping("/codes")
	@CrossOrigin
	public List<Index> codes() throws Exception {
		System.out.println("current instance's port is " + ipConfiguration.getPort());
		return indexService.get();
	}
}
