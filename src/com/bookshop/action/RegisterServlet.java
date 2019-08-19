package com.bookshop.action;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.ResultSet;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.bookshop.entity.UserInfo;
import com.bookshop.service.user.IUsersService;
import com.bookshop.service.user.impl.UsersServiceImpl;

/**
 * 注册注册控制类
 *
 */
@SuppressWarnings("serial")
public class RegisterServlet extends HttpServlet{

	private IUsersService usersService;
	
	//利用初始化方法赋值
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
		UserInfo userInfo = new UserInfo();
		userInfo.setUsername(username);
		//判断用户名是否已存在
		boolean isUserExist = usersService.userExistsSelect(userInfo, rs);
		if(isUserExist){
			request.setAttribute("info", "用户已存在");
			//失败仍转发到注册页面
			request.getRequestDispatcher("/register.jsp").forward(request, response);;
		}else{
			String password = request.getParameter("password");
			String email = request.getParameter("email");
			userInfo.setPassword(password);
			userInfo.setEmail(email);
			if(!usersService.add(userInfo)){
				response.setContentType("text/html;charset=utf-8");
				PrintWriter pw = response.getWriter();			
				pw.println("<script type='text/javascript'>");
				pw.println("alert('注册失败');");
				pw.println("open('login.jsp','_self');");
				pw.println("</script>");
				return;
			}
			response.sendRedirect(request.getContextPath() + "/register_success.jsp");
		}
	}
	
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		this.doGet(request, response);
	}
}
