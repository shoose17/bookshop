package com.bookshop.entity;


public class Orders {

	//订单号
	private Integer id;
	//用户名
	private String username;
	
	public Orders(){}

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
}
