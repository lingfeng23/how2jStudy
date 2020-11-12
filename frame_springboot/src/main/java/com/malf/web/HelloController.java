package com.malf.web;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author malf
 * @description TODO
 * @project how2jStudy
 * @since 2020/11/12
 */
@RestController
public class HelloController {
	@RequestMapping("/hello")
	public String hello() {
		return "Hello Spring Boot!";
	}
}
