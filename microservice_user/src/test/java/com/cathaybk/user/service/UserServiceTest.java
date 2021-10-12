package com.cathaybk.user.service;

import org.apache.commons.lang3.StringUtils;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.MethodOrderer.OrderAnnotation;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInfo;
import org.junit.jupiter.api.TestMethodOrder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.cathaybk.user.dao.UserDAO;
import com.cathaybk.user.model.UserVO;

@SpringBootTest
@TestMethodOrder(OrderAnnotation.class)
public class UserServiceTest {
	
	@Autowired
	private UserService userSvc;

	@Autowired
	private UserDAO userDAO;
	
	@BeforeEach
	public void beforeEach(TestInfo testInfo) {
		System.out.println("\n\n");
		System.out.println(StringUtils.repeat("=", 50));
		System.out.println("=== " + testInfo.getTestMethod().get().getName() + " ===");
		System.out.println(StringUtils.repeat("=", 50));
	}
	
	@Test
	@Order(1)
	@Tag("測試新增user")
	public void testAddUser(TestInfo testInfo) {
		System.out.println("測試內容: " + testInfo.getTags());
		userSvc.addUser(new UserVO("周潤發", "1111", "男", 9999d));
	}
	
	@Test
	@Order(2)
	@Tag("測試修改user")
	public void testUpdateUser(TestInfo testInfo) {
		System.out.println("測試內容: " + testInfo.getTags());
		Integer userWantToModId = userDAO.findByUsername("周潤發").orElseGet(() -> new UserVO()).getUserId();
		userSvc.updateUserById(new UserVO(userWantToModId,"周潤發XXX", "1111", "男", 9999d));
	}
	
	@Test
	@Order(3)
	@Tag("測試刪除user")
	public void testDeleteUser(TestInfo testInfo) {
		System.out.println("測試內容: " + testInfo.getTags());
		Integer userWantToDeleteId = userDAO.findByUsername("周潤發XXX").orElseGet(() -> new UserVO()).getUserId();
		userSvc.deleteById(userWantToDeleteId);
	}
	
	@Test
	@Order(4)
	@Tag("測試查詢所有User")
	public void testGetAllUsers(TestInfo testInfo) {
		System.out.println("測試內容: " + testInfo.getTags());
		userSvc.getAllUser().stream().forEach(System.out::println);
	}
	
	@Test
	@Order(5)
	@Tag("測試查詢User by Id")
	public void testGetUserById(TestInfo testInfo) {
		System.out.println("測試內容: " + testInfo.getTags());
		Integer userWantToQueryId = userDAO.findByUsername("馬斯克").orElseGet(() -> new UserVO()).getUserId();
		System.out.println("Query By id: " + userSvc.getUserById(userWantToQueryId));
	}
	
}
