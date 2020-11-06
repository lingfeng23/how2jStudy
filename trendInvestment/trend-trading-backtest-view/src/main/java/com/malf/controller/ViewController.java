package com.malf.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

/**
 * @author malf
 * @description TODO
 * @project trendInvestment
 * @since 2020/11/6
 */
@Controller
public class ViewController {
	@GetMapping("/")
	public String view() throws Exception {
		return "view";
	}
}
