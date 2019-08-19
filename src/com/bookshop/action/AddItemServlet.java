package com.bookshop.action;

import java.io.IOException;
import java.sql.ResultSet;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.bookshop.entity.Items;
import com.bookshop.entity.Orders;
import com.bookshop.entity.UserInfo;
import com.bookshop.service.item.IItemsService;
import com.bookshop.service.item.impl.ItemsServiceImpl;
import com.bookshop.service.order.IOrdersService;
import com.bookshop.service.order.impl.OrdersServiceImpl;



@SuppressWarnings("serial")
public class AddItemServlet extends HttpServlet {

	private IItemsService itemsService;
	private IOrdersService orderService;
	
	@Override
	public void init() throws ServletException {
		itemsService = new ItemsServiceImpl();
		orderService = new OrdersServiceImpl();
	}
	
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		ResultSet rs = null;
		//获取订单信息
		UserInfo userInfo = (UserInfo)request.getSession().getAttribute("user");
		Orders orders = new Orders();
		orders.setUsername(userInfo.getUsername());
		//生成订单
		if(!orderService.orderInsert(orders)){
			return;
		}
		//生成订单项
		String countStr = request.getParameter("count");
		Integer count = Integer.valueOf(countStr);	
		List<Orders> ordersList = orderService.findUserByOidSelect(rs, userInfo);
		Integer oid = ordersList.get(0).getId();
		for(int i = 1; i < count; i++){
			String bidStr = request.getParameter("hidden_bid_" + i);
			String bookCount = request.getParameter("nums_" + i);
			String bookTotalPrice = request.getParameter("hidden_book_total_price_" + i);
			String hiddenTotalPrice = request.getParameter("hidden_total_price");
			Items items = new Items();
			items.setOid(oid);
			items.setBid(Integer.valueOf(bidStr));
			SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
			items.setCreateDate(sdf.format(new Date()));
			items.setCount(Integer.valueOf(bookCount));
			items.setPrice(bookTotalPrice);
			items.setState(0);
			items.setTotalPrice(hiddenTotalPrice);
			itemsService.itemInsert(items);
		}
		request.getSession().removeAttribute("booksCart");
		request.getSession().removeAttribute("booksCartCount");
		response.sendRedirect(request.getContextPath() + "/myOrderServlet");
	}
	
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		this.doGet(request, response);
	}
}
