package com.bookshop.service.order;

import java.sql.Connection;
import java.sql.ResultSet;
import java.util.List;

import com.bookshop.entity.Items;
import com.bookshop.entity.Orders;
import com.bookshop.entity.UserInfo;

/**
 * @description
 * @author 李洋
 * @address 北大青鸟沈阳三好中心
 * @created 2016年12月16日 上午9:49:39
 * @version 1.0.0
 */
public interface IOrdersService {

	public boolean orderInsert(Orders orders);
	
	public List<Orders> findUserByOidSelect(ResultSet rs,UserInfo userInfo);
	
	public List<Items> orderListSelect(ResultSet rs,Orders orders);

	public List<Orders> orderByUsername(ResultSet rs,UserInfo userInfo);
}
