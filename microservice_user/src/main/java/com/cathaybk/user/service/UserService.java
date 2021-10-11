package com.cathaybk.user.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cathaybk.user.dao.UserDAO;
import com.cathaybk.user.model.UserVO;

@Service
public class UserService {

	@Autowired
	private UserDAO userDAO;
	
	public List<UserVO> getAllUser() {
		return userDAO.findAll();
	}
	
}
