package com.cathaybk.user.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.cathaybk.user.dao.UserDAO;
import com.cathaybk.user.model.UserVO;

@RequestMapping("/user")
@RestController // = @RequestMapping + @ResponseBody
public class UserController {

	@Autowired
	private UserDAO userDAO;
	
	// 查詢所有USER
	@RequestMapping(value = { "getAllUsers" }, method = { RequestMethod.GET })
	public List<UserVO> getAllUsers() {
//		List<UserVO> userList = 
//				 Stream.of(
//						 new UserVO(1001, "Roger", "0000", "male", 22000D),
//						 new UserVO(1001, "Kelly", "1111", "female", 23000D),
//						 new UserVO(1001, "Elsa", "2222", "female", 24000D)
//				 )
//				.collect(Collectors.toList());
		List<UserVO> userList = userDAO.findAll();
		return userList;
	}
	
}
