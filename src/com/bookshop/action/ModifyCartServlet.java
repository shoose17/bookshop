package com.bookshop.action;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.bookshop.entity.Books;
import com.bookshop.service.book.IBooksService;
import com.bookshop.service.book.impl.BooksServiceImpl;



@SuppressWarnings("serial")
public class ModifyCartServlet extends HttpServlet{

	private IBooksService booksService;
	
	@Override
	public void init() throws ServletException {
		booksService = new BooksServiceImpl();
	}
	
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String action = request.getParameter("action");
		if(action.equals("remove"))
			remove(request, response);
		else if(action.equals("modify"))
			modify(request, response);	
		response.sendRedirect(request.getContextPath() + "/shoppingCart.jsp");
	}
	
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		this.doGet(request, response);
	}
	
	/*
	 * 移除操作
	 */
	private void remove(HttpServletRequest request, HttpServletResponse response){
		String bidStr = request.getParameter("bid");
		int bid = Integer.valueOf(bidStr);
		//获取购物车
		List booksCart = (List)request.getSession().getAttribute("booksCart");
		//查找购物车中被修改过的图书并移除该图书
		for(int i = 0; i < booksCart.size(); i++ ){
			Books books = (Books)booksCart.get(i);
			if(bid == books.getId()){
				//移除图书
				booksCart.remove(i);
				int newNum = books.getStock() + 1;
				books.setStock(newNum);
				//修改库存
				booksService.bookStockUpdate(books);
				break;
			}
		}
		request.getSession().setAttribute("booksCartCount", booksCart.size() );
	}
	/*
	 * 修改操作
	 */
	private void modify(HttpServletRequest req, HttpServletResponse resp){
		//获取图书id和修改后的数量
		String bidStr = req.getParameter("bid");
		String countStr = req.getParameter("count");
		int bid = Integer.valueOf(bidStr);
		int count = Integer.valueOf(countStr);
		//获取购物车
		List<Books> booksCart = (List<Books>)req.getSession().getAttribute("booksCart");
		//查找购物车中被修改过的图书并修改相应信息
		for(int i = 0; i < booksCart.size(); i++ ){
			Books books = (Books)booksCart.get(i);
			if(bid == books.getId()){
				//获取修改前的图书数量
				int oldCount = books.getCount();
				//设置当前图书的新数量
				books.setCount(count);
				//修改库存
				int newNum = books.getStock() + oldCount - count;
				books.setStock(newNum);
				booksService.bookStockUpdate(books);
				break;
			}
		}
	}
}
