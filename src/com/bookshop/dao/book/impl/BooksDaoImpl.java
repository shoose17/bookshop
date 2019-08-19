package com.bookshop.dao.book.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import com.bookshop.dao.BaseDao;
import com.bookshop.dao.book.IBooksDao;
import com.bookshop.entity.Books;


/**
 * @description
 * @author 李洋
 * @address 北大青鸟沈阳三好中心
 * @created 2016年12月22日 下午3:58:12
 * @version 1.0.0
 */
public class BooksDaoImpl implements IBooksDao {

	@Override
	public ResultSet booksByPageAllSelect(Connection conn, ResultSet rs, int start, int end) throws Exception {
		PreparedStatement pstm = null;
		//分页执行的sql
		String sql = "select * from("
				+ "select b.*,rownum r from books b where rownum <= ?"
				+ ")temp where temp.r > ?";
		Object[] params = {end,start};
		rs = BaseDao.execute(sql, conn, pstm, rs, params);
		BaseDao.closeResource(null, pstm, null);
		return rs;
	}

	@Override
	public ResultSet booksLikeNameSelect(Connection conn, ResultSet rs, Books books) throws Exception {
		PreparedStatement pstm = null;
		String sql = "select * from books where bookname like ?";
		Object[] params = {"%"+books.getBookName()+"%"};
		rs = BaseDao.execute(sql, conn, pstm, rs, params);
		BaseDao.closeResource(null, pstm, null);
		return rs;
	}

	@Override
	public ResultSet getTotalCount(Connection conn, ResultSet rs) throws Exception {
		PreparedStatement pstm = null;
		String sql = "select count(0) from books";
		Object[] params = {};
		rs = BaseDao.execute(sql, conn, pstm, rs, params);
		BaseDao.closeResource(null, pstm, null);
		return rs;
	}

	@Override
	public int bookStockUpdate(Connection conn, Books books) throws Exception {
		PreparedStatement pstm = null;
		int updateRow = 0;
		String sql = "update books set stock = ? where id = ?";
		Object[] params = {books.getStock(),books.getId()};
		updateRow = BaseDao.execute(conn, pstm, sql, params);
		BaseDao.closeResource(null, pstm, null);
		return updateRow;
	}

}
