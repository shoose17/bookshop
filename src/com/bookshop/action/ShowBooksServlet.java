package com.bookshop.action;

import java.io.IOException;
import java.sql.ResultSet;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.bookshop.entity.Books;
import com.bookshop.common.Page;
import com.bookshop.service.book.IBooksService;
import com.bookshop.service.book.impl.BooksServiceImpl;


/**
 * 图书分页查询控制类
 *
 */
@SuppressWarnings("serial")
public class ShowBooksServlet extends HttpServlet {

	private IBooksService booksService;
	
	@Override
	public void init() throws ServletException {
		booksService = new BooksServiceImpl();
	}
	
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		ResultSet rs = null;
		//获取客户端传入的参数
		String strPage = request.getParameter("pageNo");
		if(strPage == null || strPage.trim().length()==0){
			strPage = "1";
		}
		Integer currPageNO = Integer.parseInt(strPage);
		//调用业务层
		Page<Books> page = booksService.booksByPageAllSelect(rs, currPageNO);
		request.setAttribute("bookList", page.getList());
		request.setAttribute("maxPageNo", page.getAllPageNO());
		request.setAttribute("pageNo", currPageNO);
		request.getRequestDispatcher("/bookList.jsp").forward(request, response);
	}
	
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		this.doGet(request, response);
	}
}
