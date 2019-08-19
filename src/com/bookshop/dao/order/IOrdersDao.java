package com.bookshop.dao.order;

import java.sql.Connection;
import java.sql.ResultSet;

import com.bookshop.entity.Orders;
import com.bookshop.entity.UserInfo;

/**
 * @description
 * @author 李洋
 * @address 北大青鸟沈阳三好中心
 * @created 2016年12月15日 下午4:53:08
 * @version 1.0.0
 */
public interface IOrdersDao {

	//添加订单
	public int orderInsert(Connection conn,Orders orders) throws Exception;
	//根据订单信息查找用户
	public ResultSet findUserByOidSelect(Connection conn,ResultSet rs,UserInfo userInfo) throws Exception;
	//查看订单详细信息
	public ResultSet orderListSelect(Connection conn,ResultSet rs,Orders orders) throws Exception;
	//查询指定用户的订单
	public ResultSet orderByUsername(Connection conn,ResultSet rs,UserInfo userInfo) throws Exception;
}
