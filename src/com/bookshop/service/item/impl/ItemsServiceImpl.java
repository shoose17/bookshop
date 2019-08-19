package com.bookshop.service.item.impl;

import java.sql.Connection;

import com.bookshop.dao.BaseDao;
import com.bookshop.dao.item.IItemsDao;
import com.bookshop.dao.item.impl.ItemsDaoImpl;
import com.bookshop.entity.Items;
import com.bookshop.service.item.IItemsService;

/**
 * @description
 * @author 李洋
 * @address 北大青鸟沈阳三好中心
 * @created 2016年12月16日 上午11:05:04
 * @version 1.0.0
 */
public class ItemsServiceImpl implements IItemsService {
	private IItemsDao itemsDao;
	
	public ItemsServiceImpl(){
		itemsDao = new ItemsDaoImpl();
	}
	
	@Override
	public boolean itemInsert(Items items) {
		boolean isDone = false;
		Connection conn = null;
		int updateRows = 0;
		try {
			conn = BaseDao.getConnection();
			updateRows = itemsDao.itemInsert(conn, items);
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

}
