<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<jsp:include page="elements/index_head.jsp"></jsp:include>
<script type="text/javascript">
	//用户名检查
	function isUsernameNull(){
		var username = document.getElementById("username").value;
		var usernull = document.getElementById("usernull");
		if(username == null || username == ""){
			usernull.innerHTML = "<font color='red'>用户名不能为空！</font>"
			return false;
		}else{
			usernull.innerHTML = "";
		}
		return true;
	} 
	function isUsernameNull(){
		var username = document.getElementById("username").value;
		var usernull = document.getElementById("usernull");
		if(username == null || username == ""){
			usernull.innerHTML = "<font color='red'>用户名不能为空！</font>"
			return false;
		}else{
			usernull.innerHTML = "";
		}
		return true;
	//密码检查
	function isPasswordNull(){
		var password = document.getElementById("password").value;
		var pwdnull = document.getElementById("pwdnull");
		if(password == null || password == ""){
			pwdnull.innerHTML = "<font color='red'>密码不能为空！</font>"
			return false;
		}else{
			pwdnull.innerHTML = "";
		}
		return true;
	}
	
	//提交触发函数
	function check(){
		if(!isUsernameNull()){
			return false;
		}else if(!isPasswordNull()){
			return false;
		}
		return true;		
	}
</script>
<body>
	<div id="header" class="wrap">
			<div id="logo">北大青鸟网上书城</div>
			<div id="navbar"></div>
		</div>
		<div id="login">
			<h2>用户登陆</h2>
			<form id="loginForm" action="${pageContext.request.contextPath }/loginServlet" method="post" onsubmit="return check()">
				<dl>
					<dt>用户名：</dt>
					<dd><input id="username" class="input-text" type="text" name="username" onblur="isUsernameNull()"/><span id="usernull"></span></dd>
					<dt>密　码：</dt>
					<dd><input id="password" class="input-text" type="password" name="password" onblur="isPasswordNull()"/><span id="pwdnull"></span></dd>
					<dt>&nbsp;</dt>
					<dd class="button"><input class="input-btn" type="submit"  value="" /><input class="input-reg" type="button" name="register" value="" onclick="window.location='register.jsp';"/></dd>
				</dl>
			</form>
		</div>
<jsp:include page="elements/index_bottom.html"></jsp:include>