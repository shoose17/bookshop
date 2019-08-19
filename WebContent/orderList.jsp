<%@page import="com.bookshop.entity.UserInfo"%>
<%@ page language="java" import="java.util.*" contentType="text/html; charset=utf-8" isELIgnored="false"%>
<%@ taglib uri="http://java.sun.com/jstl/core_rt" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%
	UserInfo userInfo = (UserInfo)session.getAttribute("user");
	if(userInfo == null){
		response.sendRedirect(request.getContextPath() + "/login.jsp");
	}
%>
<jsp:include page="elements/main_head.html"/>
<body>
<jsp:include page="elements/main_menu.jsp"/>
<script type="text/javascript" >	
	function unite(id, num){
		var tdId = document.getElementById("id_" + id);
		var tdUser = document.getElementById("user_" + id);
		var tdCrdt = document.getElementById("crdt_" + id);
		var tdTotal = document.getElementById("total_" + id);
		tdId.rowSpan = num;
		tdUser.rowSpan = num;
		tdCrdt.rowSpan = num;
		tdTotal.rowSpan = num;
	}
</script>
<div id="content" class="wrap">
	<div class="list orderList">
			<table>
				<tr class="title">
					<th class="orderId">订单编号</th>					
					<th class="userName">收货人</th>					
					<th class="createTime">下单时间</th>
					<th class="status">总价</th>
					<th>订单商品</th>
					<th>商品名称</th>
					<th>商品单价</th>
					<th class="price">商品数量</th>
				</tr>
				<c:set var="oidCount" value="0" />
				<c:set var="tdId" value="0" />	
				<c:forEach var="order" items="${orders}">
				<tr>
					<c:if test="${oidTemp != order.id}">
						<c:set var="tdId" value="${tdId+1}" />
						<td id="id_${tdId}">${order.oid}</td>
						<td id="user_${tdId}">${order.username}</td>						
						<td id="crdt_${tdId}">${order.createDate}</td>
						<td id="total_${tdId}">${order.totalPrice}</td>
						<c:if test="${oidCount > 1}">
							<script type="text/javascript" >	
								unite("${tdId-1}", "${oidCount}");
							</script>
						</c:if>
						<c:set var="oidCount" value="0" />
					</c:if>
					<td class="thumb"><img src="${order.image}" /></td>					
					<td>${order.bookName}</td>
					<td>${order.bookPrice}</td>
					<td>${order.price/order.bookPrice}</td>
					<c:set var="oidCount" value="${oidCount+1}" />
					<c:set var="oidTemp" value="${order.id}"></c:set>
				</tr>
				</c:forEach>
				<c:if test="${tdId > 0}">
					<script type="text/javascript" >	
						unite("${tdId}", "${oidCount}");
					</script>
				</c:if>
			</table>
	</div>
</div>
</body>
<jsp:include page="elements/main_bottom.html"/>
