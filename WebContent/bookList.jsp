<%@page import="com.bookshop.entity.UserInfo"%>
<%@page import="com.bookshop.entity.Books"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<jsp:include page="elements/main_head.html"/>
<%
	UserInfo userInfo = (UserInfo)session.getAttribute("user");
	if(userInfo == null){
		response.sendRedirect(request.getContextPath() + "/login.jsp");
	}
%>
<body>
<jsp:include page="elements/main_menu.jsp"/>
	<div id="content" class="wrap">
		<div class="list bookList">
			<form method="post" name="shoping" action="${pageContext.request.contextPath }/shoppingCartServlet">
				<table>
					<tr class="title">
						<th class="checker"></th>
						<th>书名</th>
						<th class="price">价格</th>
						<th class="store">库存</th>
						<th class="view">图片预览</th>
					</tr>
					<c:forEach var="book" items="${bookList}">
					<tr>
						<td><input type="checkbox" name="bookId" value="${book.id}" /></td>
						<td class="title">${book.bookName}</td>
						<input type="hidden" name="title" value = "${book.id}:${book.bookName}"/>
						<td>￥${book.bookPrice}</td>
						<input type="hidden" name="price" value = "${book.id}:${book.bookPrice}"/>
						<td>${book.stock}</td>
						<input type="hidden" name="stock" value = "${book.id}:${book.stock}"/>
						<td class="thumb"><img src="${book.image}" /></td>
						<input type="hidden" name="image" value = "${book.id}:${book.image}"/>
					</tr>
					</c:forEach>
				</table>
				<c:if test="${!empty pageNo }">
				<div class="page-spliter">
					<c:if test="${pageNo-1>0 }">
						<a href="showBooksServlet?pageNo=${pageNo-1 }">&lt;</a>
					</c:if>
					<a href="showBooksServlet?pageNo=1">首页</a>
					<c:forEach var="i" begin="1" end="${maxPageNo }">
						<c:choose>
							<c:when test="${i eq pageNo }">
								<span class="current">${i }</span>
							</c:when>
							<c:otherwise>
								<a href="showBooksServlet?pageNo=${i }">${i }</a>
							</c:otherwise>
						</c:choose>
					</c:forEach>
					<a href="showBooksServlet?pageNo=${maxPageNo }">尾页</a>
					<c:if test="${pageNo+1<=maxPageNo }">
						<a href="showBooksServlet?pageNo=${pageNo+1 }">&gt;</a>
					</c:if>
				</div>
				</c:if>
				<div class="button"><input class="input-btn" type="submit" name="submit" value="" /></div>
			</form>
		</div>
	</div>
</body>
<jsp:include page="elements/main_bottom.html"/>