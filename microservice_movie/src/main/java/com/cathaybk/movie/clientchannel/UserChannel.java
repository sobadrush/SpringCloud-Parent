package com.cathaybk.movie.clientchannel;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.cathaybk.user.model.UserVO;

/**
 * 用戶微服務遠程接口
 * 3個注意事項:
 *   1. 使用 @FeignClient(value = "要調用的微服務ID") 
 *   2. @RequestMapping 的路徑需完整
 *   3. @PathVariable(xxx) 不可省略
 */
@FeignClient(value = "microservice-user")
public interface UserChannel {

	@RequestMapping(value = "/user/getUserById/{uid}", method = RequestMethod.GET)
	public UserVO getUserById(@PathVariable("uid") int userId);
	
}
