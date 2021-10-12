package com.cathaybk.user.dao;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.cathaybk.user.model.UserVO;

@Repository
public interface UserDAO extends JpaRepository<UserVO, Integer>{

	public Optional<UserVO> findByUsername(String username);
	
}
