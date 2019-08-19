package com.bookshop.dao.order.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import com.bookshop.dao.BaseDao;
import com.bookshop.dao.order.IOrdersDao;
import com.bookshop.entity.Orders;
import com.bookshop.entity.UserInfo;

/**
 * @description
 * @author 李洋
 * @address 北大青鸟沈阳三好中心
 * @created 2016年12月15日 下午10:04:27
 * @version 1.0.0
 */
public class OrdersDaoImpl implements IOrdersDao {

	//插入订单
	@Override
	public int orderInsert(Connection conn, Orders orders) throws Exception {
		PreparedStatement pstm = null;
		int updateRow = 0;
		//执行的sql
		String sql = "insert into orders (id,username)"
				+ "values(seq_oid.nextval,?)";
		Object[] params = {orders.getUsername()};
		updateRow = BaseDao.execute(conn, pstm, sql, params);
		//注意在dao中需要关闭pstm，切记不要关闭conn
		BaseDao.closeResource(null, pstm, null);
		return updateRow;
	}

	//查找指定用户的所有订单
	@Override
	public ResultSet findUserByOidSelect(Connection conn, ResultSet rs, UserInfo userInfo) throws Exception {
		PreparedStatement pstm = null;
		//执行的sql
		String sql = "select * from orders where username = ? order by id desc";
		Object[] params = {userInfo.getUsername()};
		rs = BaseDao.execute(sql, conn, pstm, rs, params);
		BaseDao.closeResource(null, pstm, null);
		return rs;
	}

	//查看订单详细信息
	@Override
	public ResultSet orderListSelect(Connection conn, ResultSet rs, Orders orders) throws Exception {
		PreparedStatement pstm = null;
		//执行的sql
		String sql = "select * from orders o inner join items i on o.id = i.oid inner join books b on b.id = i.bid where o.username = ? order by i.createdate desc";
		Object[] params = {orders.getUsername()};
		rs = BaseDao.execute(sql, conn, pstm, rs, params);
		BaseDao.closeResource(null, pstm, null);
		return rs;
	}

	//查询指定用户的订单
	@Override
	public ResultSet orderByUsername(Connection conn, ResultSet rs, UserInfo userInfo) throws Exception {
		PreparedStatement pstm = null;
		String sql="select * from orders where username=?";
		Object[] params = {userInfo.getUsername()};
		rs = BaseDao.execute(sql, conn, pstm, rs, params);
		BaseDao.closeResource(null, pstm, null);
		return rs;
	}
}
