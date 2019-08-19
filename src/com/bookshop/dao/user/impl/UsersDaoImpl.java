package com.bookshop.dao.user.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import com.bookshop.dao.BaseDao;
import com.bookshop.dao.user.IUsersDao;
import com.bookshop.entity.UserInfo;

/**
 * 用户数据库操作实现类
 * @author liyang
 *
 */
public class UsersDaoImpl implements IUsersDao{

	@Override
	public int add(Connection conn, UserInfo userInfo) throws Exception {
		PreparedStatement pstm = null;
		int updateRow = 0;
		//执行的sql
		String sql = "insert into userinfo (username,password,email)"
				+ "values(?,?,?)";
		Object[] params = {userInfo.getUsername(),userInfo.getPassword(),userInfo.getEmail()};
		updateRow = BaseDao.execute(conn, pstm, sql, params);
		//注意在dao中需要关闭pstm，切记不要关闭conn
		BaseDao.closeResource(null, pstm, null);
		return updateRow;
	}

	@Override
	public ResultSet userExistsSelect(Connection conn, ResultSet rs, UserInfo userInfo) throws Exception {
		PreparedStatement pstm = null;
		//执行的sql
		String sql = "select * from userinfo where username = ?";
		Object[] params = {userInfo.getUsername()};
		rs = BaseDao.execute(sql, conn, pstm, rs, params);
		BaseDao.closeResource(null, pstm, null);
		return rs;
	}

	@Override
	public ResultSet userLoginSelect(Connection conn, ResultSet rs, UserInfo userInfo) throws Exception {
		PreparedStatement pstm = null;
		//执行的sql
		String sql = "select * from userinfo where username = ? and password = ?";
		Object[] params = {userInfo.getUsername(),userInfo.getPassword()};
		rs = BaseDao.execute(sql, conn, pstm, rs, params);
		BaseDao.closeResource(null, pstm, null);
		return rs;
	}
}
