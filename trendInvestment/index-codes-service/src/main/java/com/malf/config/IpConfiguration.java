package com.malf.config;

import org.springframework.boot.web.context.WebServerInitializedEvent;
import org.springframework.context.ApplicationListener;
import org.springframework.stereotype.Component;

/**
 * @author malf
 * @description 获取当前的端口号
 * @project trendInvestment
 * @since 2020/11/6
 */
@Component
public class IpConfiguration implements ApplicationListener<WebServerInitializedEvent> {
	private int serverPort;

	@Override
	public void onApplicationEvent(WebServerInitializedEvent event) {
		this.serverPort = event.getWebServer().getPort();
	}

	public int getPort() {
		return this.serverPort;
	}
}
