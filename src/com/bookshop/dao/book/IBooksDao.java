package com.bookshop.dao.book;

import java.sql.Connection;
import java.sql.ResultSet;

import com.bookshop.entity.Books;

/**
 * @description
 * @author 李洋
 * @address 北大青鸟沈阳三好中心
 * @created 2016年12月22日 下午3:53:52
 * @version 1.0.0
 */
public interface IBooksDao {

	//分页查询图书
	public ResultSet booksByPageAllSelect(Connection conn,ResultSet rs,int start,int end) throws Exception;
	//按照图书名模糊查询图书
	public ResultSet booksLikeNameSelect(Connection conn,ResultSet rs,Books books) throws Exception;
	//查询图书总记录数
	public ResultSet getTotalCount(Connection conn,ResultSet rs) throws Exception;
	//修改图书库存
	public int bookStockUpdate(Connection conn,Books books) throws Exception;
}
