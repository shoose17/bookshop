package com.bookshop.action;

import java.io.IOException;
import java.sql.ResultSet;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.bookshop.entity.Books;
import com.bookshop.service.book.IBooksService;
import com.bookshop.service.book.impl.BooksServiceImpl;


public class SearchBooksServlet extends HttpServlet {

	private IBooksService booksService;
	
	@Override
	public void init() throws ServletException {
		booksService = new BooksServiceImpl();
	}
	
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		ResultSet rs = null;
		String keywords = request.getParameter("keywords");
		Books books = new Books();
		books.setBookName(keywords);
		List<Books> bookList = booksService.booksLikeNameSelect(rs, books);
		request.setAttribute("bookList", bookList);
		request.getRequestDispatcher("/bookList.jsp").forward(request, response);
	}
	
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		this.doGet(request, response);
	}
}
