package com.bookshop.service.user.impl;

import java.sql.Connection;
import java.sql.ResultSet;

import com.bookshop.dao.BaseDao;
import com.bookshop.dao.user.IUsersDao;
import com.bookshop.dao.user.impl.UsersDaoImpl;
import com.bookshop.entity.UserInfo;
import com.bookshop.service.user.IUsersService;

public class UsersServiceImpl implements IUsersService{
	
	private IUsersDao usersDao;
	
	//利用构造器赋值
	public UsersServiceImpl(){
		usersDao = new UsersDaoImpl();
	}
	
	@Override
	public boolean add(UserInfo userInfo) {
		//添加成功标识
		boolean isDone = false;
		Connection conn = null;
		int updateRows = 0;
		try {
			//获得数据库连接
			conn = BaseDao.getConnection();
			updateRows = usersDao.add(conn, userInfo);
			if(updateRows>0){
				isDone = true;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}finally{
			//关闭资源
			BaseDao.closeResource(conn, null, null);
		}
		return isDone;
	}

	@Override
	public boolean userExistsSelect(UserInfo userInfo, ResultSet rs) {
		//是否存在标识
		boolean isExist = false;
		Connection conn = null;
		//获得数据库连接
		try {
			conn = BaseDao.getConnection();
			rs = usersDao.userExistsSelect(conn, rs, userInfo);
			if(rs.next()){
				isExist = true;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}finally{
			//关闭资源
			BaseDao.closeResource(conn, null, rs);
		}
		return isExist;
	}

	@Override
	public boolean userLoginSelect(UserInfo userInfo, ResultSet rs) {
		//是否存在标识
		boolean isLogin = false;
		Connection conn = null;
		//获得数据库连接
		try {
			conn = BaseDao.getConnection();
			rs = usersDao.userLoginSelect(conn, rs, userInfo);
			if(rs.next()){
				isLogin = true;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}finally{
			//关闭资源
			BaseDao.closeResource(conn, null, rs);
		}
		return isLogin;
	}
}
