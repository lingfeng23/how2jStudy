package com.malf.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

/**
 * @author malf
 * @description 配置类，用于允许所有的请求都跨域。
 * @project how2jStudy
 * @since 2020/10/28
 */
@Configuration
public class CORSConfig extends WebMvcConfigurerAdapter {
	@Override
	public void addCorsMappings(CorsRegistry registry) {
		// 所有请求都允许跨域
		registry.addMapping("/**")
				.allowedOrigins("*")
				.allowedMethods("")
				.allowedHeaders("*");

	}
}
