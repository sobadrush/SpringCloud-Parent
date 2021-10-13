package com.cathaybk.movie.controller;

import org.springframework.beans.factory.annotation.Autowired;
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
	
	@RequestMapping(value = { "/orderTicket/{uid}" }, method = RequestMethod.GET)
	public String orderTicket(@PathVariable("uid") Integer uid) {
		UserVO userWantToByTicket = restTemplate.getForObject("http://localhost:9001/user/getUserById/" + uid, UserVO.class);
		System.out.println("USER 正在進行購票... : " + userWantToByTicket);
		return "購票成功";
	}

}
