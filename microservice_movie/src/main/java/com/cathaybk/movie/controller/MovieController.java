package com.cathaybk.movie.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.cathaybk.user.model.UserVO;

@RequestMapping("/movie")
@RestController
public class MovieController {

	@Autowired
	private RestTemplate restTemplate;
	
	@Autowired
	private org.springframework.cloud.client.discovery.DiscoveryClient discoveryClient;
	
	/*
	 * Level 1:
	 * 1.使用「服務發現」Spring 的 DiscoveryClient
	 * 2.將ip & port解耦
	 */
	@RequestMapping(value = { "/orderTicket/{uid}" }, method = RequestMethod.GET)
	public String orderTicket(@PathVariable("uid") Integer uid) {
		List<ServiceInstance> instances = discoveryClient.getInstances("microservice-user"); // 同一個微服務可能會起多個作load-balance
		ServiceInstance svcInstance = instances.get(0); // 目前只有一個 user微服務
		UserVO userWantToByTicket = restTemplate.getForObject("http://" + svcInstance.getHost() + ":" + svcInstance.getPort() + "/user/getUserById/" + uid, UserVO.class);
		System.out.println("USER 正在進行購票... : " + userWantToByTicket);
		return "購票成功";
	}
	
	/*
	 * Level 0:
	 * 1.沒有使用「服務發現」
	 * 2.使用 RestTemplate 獲取其他微服務
	 * 3.若microservice-user的url有異動，每處都必須修改
	 */
//	@RequestMapping(value = { "/orderTicket/{uid}" }, method = RequestMethod.GET)
//	public String orderTicket(@PathVariable("uid") Integer uid) {
//		UserVO userWantToByTicket = restTemplate.getForObject("http://localhost:9001/user/getUserById/" + uid, UserVO.class);
//		System.out.println("USER 正在進行購票... : " + userWantToByTicket);
//		return "購票成功";
//	}

}
