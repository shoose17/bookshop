package com.bookshop.dao.user;

import java.sql.Connection;
import java.sql.ResultSet;

import com.bookshop.entity.UserInfo;

/**
 * 用户数据库操作接口类
 * @author liyang
 *
 */
public interface IUsersDao {

	//注册用户
	public int add(Connection conn,UserInfo userInfo) throws Exception;
	//查询用户是否存在
	public ResultSet userExistsSelect(Connection conn,ResultSet rs,UserInfo userInfo) throws Exception;
	//登陆查询
	public ResultSet userLoginSelect(Connection conn,ResultSet rs,UserInfo userInfo) throws Exception;
}
