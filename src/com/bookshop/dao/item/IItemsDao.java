package com.bookshop.dao.item;

import java.sql.Connection;

import com.bookshop.entity.Items;

/**
 * @description
 * @author 李洋
 * @address 北大青鸟沈阳三好中心
 * @created 2016年12月15日 下午8:34:19
 * @version 1.0.0
 */
public interface IItemsDao {

	public int itemInsert(Connection conn,Items items) throws Exception;
	
}
