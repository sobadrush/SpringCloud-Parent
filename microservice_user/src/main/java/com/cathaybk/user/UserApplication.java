package com.cathaybk.user;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

/**
 * 用戶微服務
 */
@SpringBootApplication
@EnableEurekaClient // 啟動Eureka客戶端
public class UserApplication {

	public static void main(String[] args) {
//		Arrays.asList(args).forEach(System.out::println);
		SpringApplication.run(UserApplication.class, args);
	}

}
