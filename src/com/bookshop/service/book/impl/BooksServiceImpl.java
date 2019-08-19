package com.bookshop.service.book.impl;

import java.sql.Connection;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.bookshop.dao.BaseDao;
import com.bookshop.dao.book.IBooksDao;
import com.bookshop.dao.book.impl.BooksDaoImpl;
import com.bookshop.entity.Books;
import com.bookshop.common.Page;
import com.bookshop.service.book.IBooksService;



/**
 * @description
 * @author 李洋
 * @address 北大青鸟沈阳三好中心
 * @created 2016年12月22日 下午4:02:58
 * @version 1.0.0
 */
public class BooksServiceImpl implements IBooksService {

	private IBooksDao booksDao;
	
	public BooksServiceImpl() {
		booksDao = new BooksDaoImpl();
	}
	
	@Override
	public Page<Books> booksByPageAllSelect(ResultSet rs, int currPageNO) {
		Connection conn = null;
		Integer allRecordNO = 0;
		List<Books> bookList = new ArrayList<>();
		Page<Books> page = new Page<>();
		try {
			conn = BaseDao.getConnection();
			//封装当前页号
			page.setCurrPageNO(currPageNO);
			//封装总记录数
			rs = booksDao.getTotalCount(conn, rs);
			while(rs.next()){
				allRecordNO = rs.getInt(1);
			}
			page.setAllRecordNO(allRecordNO);
			//封装总页数
			Integer allPageNO = null;
			if(page.getAllRecordNO() % page.getPerPageSize() == 0){
				allPageNO = page.getAllRecordNO() / page.getPerPageSize();
			}else{
				allPageNO = page.getAllRecordNO() / page.getPerPageSize() + 1;
			}
			page.setAllPageNO(allPageNO);
			//封装该页显示的内容
			Integer start = (page.getCurrPageNO()-1) * page.getPerPageSize();
			Integer end = page.getCurrPageNO() * page.getPerPageSize();
			rs = booksDao.booksByPageAllSelect(conn, rs, start, end);
			while(rs.next()){
				Books books = new Books();
				books.setId(rs.getInt("id"));
				books.setBookName(rs.getString("bookName"));
				books.setBookPrice(rs.getString("bookPrice"));
				books.setImage(rs.getString("image"));
				books.setStock(rs.getInt("stock"));
				bookList.add(books);
			}
			page.setList(bookList);;
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			BaseDao.closeResource(conn, null, rs);
		}
		return page;
	}
	
	@Override
	public List<Books> booksLikeNameSelect(ResultSet rs, Books books) {
		List<Books> bookList = new ArrayList<>();
		Connection conn = null;
		try {
			conn = BaseDao.getConnection();
			rs = booksDao.booksLikeNameSelect(conn, rs, books);
			while(rs.next()){
				Books booksSelect = new Books();
				booksSelect.setId(rs.getInt("id"));
				booksSelect.setBookName(rs.getString("bookName"));
				booksSelect.setBookPrice(rs.getString("bookPrice"));
				booksSelect.setImage(rs.getString("image"));
				booksSelect.setStock(rs.getInt("stock"));
				bookList.add(booksSelect);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}finally{
			BaseDao.closeResource(conn, null, rs);
		}
		return bookList;
	}

	@Override
	public int getTotalCount(ResultSet rs) {
		Connection conn = null;
		int totalCount = 0;
		try {
			conn = BaseDao.getConnection();
			rs = booksDao.getTotalCount(conn, rs);
			if(rs.next()){
				totalCount = rs.getInt(1);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}finally{
			BaseDao.closeResource(conn, null, rs);
		}
		return totalCount;
	}

	@Override
	public boolean bookStockUpdate(Books books) {
		boolean isDone = false;
		Connection conn = null;
		int updateRows = 0;
		try {
			conn = BaseDao.getConnection();
			updateRows = booksDao.bookStockUpdate(conn, books);
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
