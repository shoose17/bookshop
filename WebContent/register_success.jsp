<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title></title>
<link type="text/css" rel="stylesheet" href="${pageContext.request.contextPath }/css/style.css" />
</head>
<body>
	<div id="header" class="wrap">
		<div id="logo">北大青鸟网上书城</div>
		<div id="navbar">
			<form method="get" name="search" action="">
				搜索：<input class="input-text" type="text" name="keywords" /><input class="input-btn" type="submit" name="submit" value="" />
			</form>
		</div>
	</div>
	<div id="register">
		<div class="title">
			<h2>欢迎注册网上书城</h2>
		</div>
		<div class="steps">
			<ul class="clearfix">
				<li class="past">1.填写注册信息</li>
				<li class="last">2.注册成功</li>
			</ul>
		</div>
		<div class="success">
			<div class="information">
				<p>恭喜：注册成功！</p>
				<p><a href="${pageContext.request.contextPath }/login.jsp">点此进入用户中心&gt;&gt;</a></p>
			</div>
		</div>
	</div>
	<div id="footer" class="wrap">
		网上书城 &copy; 版权所有	</div>
</body>
</html>
