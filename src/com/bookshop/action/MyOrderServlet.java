package com.bookshop.action;

import java.io.IOException;
import java.sql.ResultSet;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.bookshop.entity.Items;
import com.bookshop.entity.Orders;
import com.bookshop.entity.UserInfo;
import com.bookshop.service.order.IOrdersService;
import com.bookshop.service.order.impl.OrdersServiceImpl;


@SuppressWarnings("serial")
public class MyOrderServlet extends HttpServlet {

	private IOrdersService orderService;
	
	@Override
	public void init() throws ServletException {
		orderService = new OrdersServiceImpl();
	}
	
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		ResultSet rs = null;
		UserInfo userInfo = (UserInfo)request.getSession().getAttribute("user");
    	Orders orders = new Orders();
    	orders.setUsername(userInfo.getUsername());
		List<Items> itemsList = orderService.orderListSelect(rs, orders);
		request.setAttribute("orders", itemsList);
		request.getRequestDispatcher("/orderList.jsp").forward(request, response);
	}
	
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		this.doGet(request, response);
	}
}
