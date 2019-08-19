package com.bookshop.action;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.bookshop.entity.Books;
import com.bookshop.service.book.IBooksService;
import com.bookshop.service.book.impl.BooksServiceImpl;


/**
 * 购物车控制类
 *
 */
@SuppressWarnings("serial")
public class ShoppingCartServlet extends HttpServlet {

	private IBooksService booksService;
	
	@Override
	public void init() throws ServletException {
		booksService = new BooksServiceImpl();
	}
	
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//获取用户选中的图书
		String[] bids = request.getParameterValues("bookId");
		String[] title = request.getParameterValues("title");
		String[] price = request.getParameterValues("price");
		String[] stock = request.getParameterValues("stock");
		String[] image = request.getParameterValues("image");
		//获取购物车内容，没有则初始化一个购物车
		List<Books> booksCart = (List<Books>)request.getSession().getAttribute("booksCart");
		if(booksCart==null){
			booksCart = new ArrayList<>();
		}
		//获取复选框中选中的值
		for(int i=0;i<bids.length;i++){
			boolean isNotExists = true;
			Books books = new Books();
			int bid = Integer.valueOf(bids[i]);
			//查看当前图书是否已经存在于购物车中
			for(int j = 0; j < booksCart.size(); j++){
				Books existBook = (Books)booksCart.get(j);
				//如果当前图书已经存在于购物车，则将图书数量+1并计算当前总价
				if(existBook.getId() == bid){
					existBook.setCount(existBook.getCount() + 1);
					isNotExists = false;
					break;
				}
			}
			if(!isNotExists)
				continue;			
			books.setId(bid);
			//判断当前信息是否为指定bid下的信息
			for(int k = 0; k < title.length; k++){
				String titleTemp =title[k];
				if(titleTemp.indexOf(bids[i] + ":") < 0)
					continue;
				if(image[k].indexOf(bids[i] + ":") < 0)
					continue;
				if(stock[k].indexOf(bids[i] + ":") < 0)
					continue;
				if(price[k].indexOf(bids[i] + ":") < 0)
					continue;
				//添加指定bid下的书籍信息
				int filterStock = Integer.valueOf(filter(stock[k], bids[i]) );
				String filterTitle =  filter(titleTemp, bids[i]);
				String filterImage = filter(image[k], bids[i] );
				String filterPrice = filter(price[k], bids[i]);			
				//设置图书信息
				books.setBookName(filterTitle);
				books.setImage(filterImage);				
				books.setStock(filterStock-1);
				books.setBookPrice(filterPrice);
				books.setCount(1);
				//修改库存
				booksService.bookStockUpdate(books);
				booksCart.add(books);
			}
		}
		request.getSession().setAttribute("booksCart", booksCart);
		request.getSession().setAttribute("booksCartCount", booksCart.size() );
		response.sendRedirect(request.getContextPath() + "/shopping-success.jsp");
	}
	
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		this.doGet(request, response);
	}
	
	//过滤客户端传回的信息
	public String filter(String s, String garbage){
		return s.substring(garbage.length()+1, s.length());
	}
}
