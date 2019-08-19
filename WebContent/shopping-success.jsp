<%@ page language="java" import="java.util.*" contentType="text/html; charset=utf-8" isELIgnored="false"%>
<%@ page import="com.bookshop.entity.UserInfo"%>
<%
	UserInfo userInfo = (UserInfo)session.getAttribute("user");
	if(userInfo == null){
		response.sendRedirect(request.getContextPath() + "/login.jsp");
	}
%>
<jsp:include page="elements/main_head.html"/>
<body>
<jsp:include page="elements/main_menu.jsp"/>
<div id="content" class="wrap">
	<div class="success">
		<div class="information">
			<p>恭喜：添加成功！</p>
			<p><a href="${pageContext.request.contextPath }/shoppingCart.jsp">点此查看购物车详情&gt;&gt;</a></p>
		</div>
	</div>
</div>
</body>
<jsp:include page="elements/main_bottom.html"/>
