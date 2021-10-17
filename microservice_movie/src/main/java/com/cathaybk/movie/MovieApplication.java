package com.cathaybk.movie;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.openfeign.EnableFeignClients;

/**
 * 電影微服務
 */
@SpringBootApplication
@EnableEurekaClient // 啟動Eureka客戶端
@EnableFeignClients // For 使用 OpenFeign，開啟Feign自動配置
public class MovieApplication {

	public static void main(String[] args) {
		SpringApplication.run(MovieApplication.class, args);
	}

	// 使用 OpenFeign 可註解 RestTemplate (OpenFeign底層有整合RestTemplate了)
//	@Bean
//	@org.springframework.cloud.client.loadbalancer.LoadBalanced // 標註此註解，透過restTemplate呼叫服務時會經過底層的一個 intercepter，透過 Ribbon 的附載均衡
//	public RestTemplate restTemplate() {
//		return new RestTemplate();
//	}
}
