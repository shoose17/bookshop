package com.bookshop.dao.item.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;

import com.bookshop.dao.BaseDao;
import com.bookshop.dao.item.IItemsDao;
import com.bookshop.entity.Items;

/**
 * @description
 * @author 李洋
 * @address 北大青鸟沈阳三好中心
 * @created 2016年12月15日 下午10:03:07
 * @version 1.0.0
 */
public class ItemsDaoImpl implements IItemsDao {

	@Override
	public int itemInsert(Connection conn, Items items) throws Exception {
		PreparedStatement pstm = null;
		int updateRow = 0;
		//执行的sql
		String sql = "insert into items (id,oid,bid,createdate,count,price,state,totalPrice)"
				+ "values(seq_items.nextval,?,?,?,?,?,?,?)";
		Object[] params = {items.getOid(),items.getBid(),items.getCreateDate(),
				          items.getCount(),items.getPrice(),items.getState(),items.getTotalPrice()};
		updateRow = BaseDao.execute(conn, pstm, sql, params);
		//注意在dao中需要关闭pstm，切记不要关闭conn
		BaseDao.closeResource(null, pstm, null);
		return updateRow;
	}

	

}
