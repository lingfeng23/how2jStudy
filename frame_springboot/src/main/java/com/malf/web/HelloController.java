package com.malf.web;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.text.DateFormat;
import java.util.Date;

/**
 * @author malf
 * @description TODO
 * @project frame_springboot
 * @since 2020/11/12
 */
//@RestController
@Controller
public class HelloController {
	@RequestMapping("/hello")
	public String hello(Model model) throws Exception {
		model.addAttribute("now",
				DateFormat.getDateInstance().format(new Date()));
		if (true) {
			throw new Exception("Exception");
		}
		return "hello";
	}

}
