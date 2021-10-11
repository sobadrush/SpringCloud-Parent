package com.cathaybk.user.dao;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class UserDaoTest {
	

	@Autowired
	private UserDAO userDAO;
	
	@Test
	public void test001() {
		userDAO.findAll().stream().forEach(System.out::println);
	}
	
}
