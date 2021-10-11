package com.cathaybk.user.controller;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.cathaybk.user.model.UserVO;

@RequestMapping("/user")
@RestController // = @RequestMapping + @ResponseBody
public class UserController {

	// 查詢所有USER
	@RequestMapping(value = { "getAllUsers" }, method = { RequestMethod.GET })
	public List<UserVO> getAllUsers() {
		List<UserVO> userList = 
				 Stream.of(
						 new UserVO(1001, "Roger", "0000", "male", 22000D),
						 new UserVO(1001, "Kelly", "1111", "female", 23000D),
						 new UserVO(1001, "Elsa", "2222", "female", 24000D)
				 )
				.collect(Collectors.toList());
		return userList;
	}
	
}
