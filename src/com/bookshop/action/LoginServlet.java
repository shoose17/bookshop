package com.bookshop.action;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.ResultSet;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.bookshop.entity.UserInfo;
import com.bookshop.service.user.IUsersService;
import com.bookshop.service.user.impl.UsersServiceImpl;

/**
 * 用户登陆控制类
 *
 */
@SuppressWarnings("serial")
public class LoginServlet extends HttpServlet {
	
	private IUsersService usersService;
	
	@Override
	public void init() throws ServletException {
		usersService = new UsersServiceImpl();
	}
	
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//ResultSet对象
		ResultSet rs = null;
		//获取用户名
		String username = request.getParameter("username");
		//获取密码
		String password = request.getParameter("password");
		//实例化UserInfo对象
		UserInfo userInfo = new UserInfo();
		userInfo.setUsername(username);
		userInfo.setPassword(password);
		boolean isLogin = usersService.userLoginSelect(userInfo, rs);
		//获取session
		HttpSession session = request.getSession();
		if(isLogin){
			//把用户信息放到session中
			session.setAttribute("user", userInfo);
			//跳转到购物页面
			response.sendRedirect(request.getContextPath() + "/showBooksServlet");
		}else{
			response.setContentType("text/html; charset=utf-8");
			PrintWriter pw = response.getWriter(); 
			pw.write("<script type='text/javascript'>");
			pw.write("alert('登录失败！请重新登录！！');");
			pw.write("open('login.jsp','_self');");
			pw.write("</script>");
			pw.flush();
			pw.close();
		}
		
	}
	
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		this.doGet(request, response);
	}
}
