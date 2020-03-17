<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%
	String contextPath = request.getContextPath(); //  path = "/travel"
	String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+contextPath+"/"; // basePath="http://localhost:8080/travel/"
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<meta name="viewport"
	content="width=device-width, initial-scale=1, maximum-scale=1">
<base href="<%=basePath%>">
<title>icloud-登录</title>
<link rel="stylesheet" href="layui/css/layui.css" />
<style type="text/css">
* {
	margin: 0;
	padding: 0;
}

html, body {
	background: url('img/bg2.jpg') repeat fixed top;
	opacity: 100%;
	width: 100%;
	height: 100%;
	overflow: hidden;
}

img {
	width: 100%;
	height: 100%;
	max-width: auto;
	max-height: auto;
}

#imgbox {
	width: 130px;
	height: 150px;
	position: relative;
	top: 30%;
	left: 35%;
}

#loginbox {
	width: 250px;
	height: 150px;
	position: relative;
	top: 7%;
	left: 45%;
	/* border:1px solid red; */
}

#footer {
	width: 100%;
	height: 40px;
	position: absolute;
	bottom: 20px;
}

#footer_imgbox {
	width: 60px;
	height: 100%;
	float: left;
	margin-left: 20px;
}
</style>
</head>
<body>

	<%--标题--%>
	<h1 style="color: #FFFFFF; position: absolute; top: 10%; left: 40%;">
		<strong>icloud统一验证平台</strong>
	</h1>
	<%--图片头像--%>
	<div id="imgbox">
		<img id="user" src="img/login_admin.png">
	</div>
	<%--表单--%>
	<div id="loginbox">
		<div class="layui-form">
			<div class="layui-form-item">
				<input type="text" name="username" placeholder="用户名"
					autocomplete="off" class="layui-input" lay-verify="required">
			</div>
			<div class="layui-form-item">
				<input type="password" name="password" placeholder="密码"
					autocomplete="off" class="layui-input" lay-verify="required">
			</div>

			<div class="layui-form-item">
				<div style="width: 100px; float: left;">
					<select name="role" lay-filter="aihao" placeholder="--角色--">
						<option value="">--角色--</option>
						<option value="1">管理员</option>
						<option value="2">教师</option>
						<option value="3">学生</option>
					</select>
				</div>
				<div style="float: right; width: 120px;">
					<button class="layui-btn layui-btn-warm layui-btn-fluid" lay-submit
						lay-filter="go">登录</button>
				</div>
			</div>
		</div>
	</div>
	<%--底部--%>
	<div id="footer">
		<div id="footer_imgbox">
			<img src="img/login_cloud.png">
		</div>
		<span
			style="position: relative; left: 0.5%; top: 56%; font-family: 'arial black'; font-size: 40; color: #FFFFFF;">icloud</span>
		<span style="position: relative; left: 35%; top: 20%; color: #FFFFFF;">Copyright
			&copy;2020 Flemming. 版权所有。</span>
	</div>
	<script type="text/javascript" src="layui/layui.js"></script>
	<script type="text/javascript" src="js/login.js"></script>
</body>
</html>