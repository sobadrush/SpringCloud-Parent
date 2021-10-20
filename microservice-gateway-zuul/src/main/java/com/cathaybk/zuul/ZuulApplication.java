package com.cathaybk.zuul;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.zuul.EnableZuulProxy;

/**
 * Zuul Gateway 微服務 
 */
@SpringBootApplication
@EnableZuulProxy // 開啟Zuul代理功能
// @EnableEurekaClient // 啟動Eureka客戶端( 使用 @EnableZuulProxy 可不特別標註 @EnableEurekaClient )
public class ZuulApplication {

	public static void main(String[] args) {
		SpringApplication.run(ZuulApplication.class, args);
	}

}
