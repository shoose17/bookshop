package com.bookshop.service.user;


import java.sql.ResultSet;

import com.bookshop.entity.UserInfo;

public interface IUsersService {
	
	//注册用户的业务方法
	public boolean add(UserInfo userInfo);
	//查询用户是否存在的业务方法
	public boolean userExistsSelect(UserInfo userInfo,ResultSet rs);
	//登陆查询的业务方法
	public boolean userLoginSelect(UserInfo userInfo,ResultSet rs);
}
