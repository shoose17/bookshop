<%@ page language="java" import="java.util.*" pageEncoding="utf-8" isELIgnored="false"%>
<body></body>
<div id="header" class="wrap">
	<div id="logo">网上书城</div>
	<div id="navbar">
		<div class="userMenu">
			<ul>
				<li class="current"><font color="BLACK">欢迎您，<strong>${sessionScope.user.username }</strong></font>&nbsp;&nbsp;&nbsp;</li>
				<li><a href="${pageContext.request.contextPath }/showBooksServlet">首页</a></li>
				<li><a href="${pageContext.request.contextPath }/myOrderServlet">我的订单</a></li>
				<li><a href="${pageContext.request.contextPath }/shoppingCart.jsp">购物车</a></li>
				<li><a href="${pageContext.request.contextPath }/logout.jsp">注销</a></li>
			</ul>
		</div>
		<form method="post" name="search" action="${pageContext.request.contextPath }/searchBooksServlet">
			搜索：<input class="input-text" type="text" name="keywords" /><input class="input-btn" type="submit" name="submit" value="" />
		</form>
	</div>
</div>