<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="com.bookshop.entity.UserInfo"%>
<%@ taglib uri="http://java.sun.com/jstl/core_rt" prefix="c" %>
<%
	UserInfo userInfo = (UserInfo)session.getAttribute("user");
	if(userInfo == null){
		response.sendRedirect(request.getContextPath() + "/login.jsp");
	}
%>
<jsp:include page="elements/main_head.html"/>
<script type="text/javascript">
	function modify(bidStr,i){
		var numStr = document.getElementById("nums_" + i);	
		window.location.href="${pageContext.request.contextPath }/modifyCartServlet?action=modify&bid="+bidStr+"&count="+numStr.value;
	}

	//计算购物车内价格信息
	function countNum(sizeStr){
		var size = parseFloat(sizeStr);
		var totalPrice = 0;
		for(var i = 1; i <= size; i++ ){			
			var numStr = document.getElementById("nums_" + i);
			var price = document.getElementById("price_" + i);
			var hiddenPrice = document.getElementById("hidden_book_total_price_" + i);
			var bookPriceStr = document.getElementById("hidden_" + i);
			var num = parseFloat(numStr.value);
			var bookPrice = parseFloat(bookPriceStr.value);
			price.innerHTML = num * bookPrice;
			hiddenPrice.value = num * bookPrice;
			totalPrice += num * bookPrice;
		}
		var hiddenTotalPrice = document.getElementById("hidden_total_price");
		hiddenTotalPrice.value = totalPrice;
		document.getElementById("total_price").innerHTML = totalPrice;
	}
	
	//从购物车中移除书籍
	function remove(bidStr){
		window.location.href="${pageContext.request.contextPath }/modifyCartServlet?action=remove&bid="+bidStr;
	}
</script>
<body onload="countNum(${booksCartCount})">
<jsp:include page="elements/main_menu.jsp"/>
<div id="content" class="wrap">
	<div class="list bookList">
		<form method="post" name="shoping" action="${pageContext.request.contextPath }/addItemServlet">
			<table>
				<tr class="title">
					<th class="view">图片预览</th>
					<th>书名</th>
					<th class="nums">数量</th>
					<th class="price">价格</th>
					<th class="nums">操作</th>
				</tr>
				<c:set value="1" var="count" />
				<c:forEach var="book" items="${booksCart}" >
					<tr>
						<input type="hidden" id="hidden_bid_${count}" name="hidden_bid_${count}" value="${book.id}"/>
						<td class="thumb"><img src="${book.image}" /></td>
						<td class="title">${book.bookName }</td>
						<td><input class="input-text" type="text" id="nums_${count}" name="nums_${count}" value="${book.count}"  onchange="modify(${book.id}, ${count})"/></td>
						<input type="hidden" id="hidden_${count}" name="hidden_${count}" value="${book.bookPrice }"/>
						<td>￥<span id="price_${count}"></span></td>
						<input type="hidden" id="hidden_book_total_price_${count}" name="hidden_book_total_price_${count}"/>
						<td><span id="remove_${count}"><a href="javascript:remove(${book.id})">移除</a></span></td>
					</tr>
					<c:set value="${count+1}" var="count" />
				</c:forEach></table>
				<input type="hidden" id="count" name="count" value="${count}"/>
			<div class="button">
				<h4>总价：￥<span id="total_price"></span>元</h4>
				<input type="hidden" id="hidden_total_price" name="hidden_total_price"/>
				<input class="input-chart" type="submit" name="submit" value="" />
			</div>
		</form>
	</div>
</div>
</body>
<jsp:include page="elements/main_bottom.html"/>