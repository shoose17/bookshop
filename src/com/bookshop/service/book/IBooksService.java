package com.bookshop.service.book;

import java.sql.ResultSet;
import java.util.List;

import com.bookshop.entity.Books;
import com.bookshop.common.Page;

/**
 * 图书业务层接口类
 * @author liyang
 *
 */
public interface IBooksService {

	//查询所有图书
	public Page<Books> booksByPageAllSelect(ResultSet rs,int currPageNO);
	//按照图书名模糊查询图书
	public List<Books> booksLikeNameSelect(ResultSet rs,Books books);
	//查询图书总记录数
	public int getTotalCount(ResultSet rs) ;
	//修改图书库存
	public boolean bookStockUpdate(Books books);
}
