package com.bookshop.service.order.impl;

import java.sql.Connection;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.bookshop.dao.BaseDao;
import com.bookshop.dao.order.IOrdersDao;
import com.bookshop.dao.order.impl.OrdersDaoImpl;
import com.bookshop.entity.Items;
import com.bookshop.entity.Orders;
import com.bookshop.entity.UserInfo;
import com.bookshop.service.order.IOrdersService;


/**
 * @description
 * @author 李洋
 * @address 北大青鸟沈阳三好中心
 * @created 2016年12月16日 上午10:00:35
 * @version 1.0.0
 */
public class OrdersServiceImpl implements IOrdersService {

	private IOrdersDao ordersDao;
	
	public OrdersServiceImpl(){
		ordersDao = new OrdersDaoImpl();
	}

	@Override
	public boolean orderInsert(Orders orders) {
		boolean isDone = false;
		Connection conn = null;
		int updateRows = 0;
		try {
			conn = BaseDao.getConnection();
			updateRows = ordersDao.orderInsert(conn, orders);
			if(updateRows>0){
				isDone = true;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}finally{
			BaseDao.closeResource(conn, null, null);
		}
		return isDone;
	}

	@Override
	public List<Orders> findUserByOidSelect(ResultSet rs, UserInfo userInfo) {
		Connection conn = null;
		List<Orders> ordersList = new ArrayList<>();
		try {
			conn = BaseDao.getConnection();
			rs = ordersDao.findUserByOidSelect(conn, rs, userInfo);
			while(rs.next()){
				Orders orders = new Orders();
				orders.setId(rs.getInt("id"));
				orders.setUsername(rs.getString("username"));
				ordersList.add(orders);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			BaseDao.closeResource(conn, null, rs);
		}
		return ordersList;
	}

	@Override
	public List<Items> orderListSelect(ResultSet rs, Orders orders) {
		Connection conn = null;
		List<Items> itemsList = new ArrayList<>();
		try {
			conn = BaseDao.getConnection();
			rs = ordersDao.orderListSelect(conn, rs, orders);
			while(rs.next()){
				Items items = new Items();
				items.setId(rs.getInt("id"));
				items.setOid(rs.getInt("oid"));
				items.setBid(rs.getInt("bid"));
				items.setCreateDate(rs.getString("createdate"));
				items.setCount(rs.getInt("count"));
				items.setPrice(rs.getString("price"));
				items.setState(rs.getInt("state"));
				items.setTotalPrice(rs.getString("totalPrice"));
				items.setUsername(rs.getString("username"));
				items.setImage(rs.getString("image"));
				items.setBookName(rs.getString("bookname"));
				items.setBookPrice(rs.getString("bookprice"));
				itemsList.add(items);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			BaseDao.closeResource(conn, null, rs);
		}
		return itemsList;
	}

	@Override
	public List<Orders> orderByUsername(ResultSet rs, UserInfo userInfo) {
		Connection conn = null;
		List<Orders> ordersList = new ArrayList<>();
		try {
			conn = BaseDao.getConnection();
			rs = ordersDao.orderByUsername(conn, rs, userInfo);
			while(rs.next()){
				Orders orders = new Orders();
				orders.setId(rs.getInt("id"));
				orders.setUsername(rs.getString("username"));
				ordersList.add(orders);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			BaseDao.closeResource(conn, null, rs);
		}
		return ordersList;
		
	}

	
	
}
