/**
 * 
 */
package com.cathaybk.user.model;

import java.io.Serializable;

public class UserVO implements Serializable {

	private static final long serialVersionUID = 1L;

	private Integer id;
	private String username;
	private String password;
	private String sex;
	private Double money;
	
	public UserVO() {
		super();
	}

	public UserVO(Integer id, String username, String password, String sex, Double money) {
		super();
		this.id = id;
		this.username = username;
		this.password = password;
		this.sex = sex;
		this.money = money;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getSex() {
		return sex;
	}

	public void setSex(String sex) {
		this.sex = sex;
	}

	public Double getMoney() {
		return money;
	}

	public void setMoney(Double money) {
		this.money = money;
	}

	@Override
	public String toString() {
		return "UserVO [id=" + id + ", username=" + username + ", password=" + password + ", sex=" + sex + ", money="
				+ money + "]";
	}
	
}
