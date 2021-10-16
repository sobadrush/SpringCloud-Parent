package com.cathaybk.user.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.cathaybk.user.model.UserVO;
import com.cathaybk.user.service.UserService;

@RequestMapping("/user")
@RestController // = @RequestMapping + @ResponseBody
public class UserController {

	@Value("${self-defArg}") // 取得SpringBoot啟動的參數(Boot Dashbard -> Open Config -> Arguments -> Project Arguments)
    private String microServiceNameFromProjectArg; // 由啟動參數代入的「服務名稱」
	
	@Autowired
	private UserService userSvc;
	
	// 查詢所有USER
	@RequestMapping(value = { "/getAllUsers" }, method = { RequestMethod.GET })
	public List<UserVO> getAllUsers() {
//		List<UserVO> userList = 
//				 Stream.of(
//						 new UserVO(1001, "Roger", "0000", "male", 22000D),
//						 new UserVO(1001, "Kelly", "1111", "female", 23000D),
//						 new UserVO(1001, "Elsa", "2222", "female", 24000D)
//				 )
//				.collect(Collectors.toList());
		List<UserVO> userList = userSvc.getAllUser();
		return userList;
	}
	
	@RequestMapping(value = "/getUserById/{uid}", method = RequestMethod.GET)
	public UserVO getUserById(@PathVariable("uid") int userId) {
		System.out.println(" >>> 呼叫的是：" + this.microServiceNameFromProjectArg);
		return userSvc.getUserById(userId);
	}
	
	@RequestMapping(value = "/addUser", method = RequestMethod.POST)
	public String addUser(@RequestBody(required = true) UserVO userVO) {
		String rtnMsg = "";
		try {
			userSvc.addUser(userVO);
			rtnMsg = "新增成功";
		} catch (Exception e) {
			e.printStackTrace();
			rtnMsg = "新增失敗";
		}
		return rtnMsg;
	}
	
	@RequestMapping(value = "/deleteUser/{uid}", method = RequestMethod.DELETE)
	public String addUser(@PathVariable("uid") int userId) {
		String rtnMsg = "";
		try {
			userSvc.deleteById(userId);
			rtnMsg = "刪除成功";
		} catch (Exception e) {
			e.printStackTrace();
			rtnMsg = "刪除失敗";
		}
		return rtnMsg;
	}
}
