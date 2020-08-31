<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<!DOCTYPE html>
<html>

<head>
<meta charset="UTF-8">
<title>登陆</title>
<link rel="stylesheet" href="css/head.css" />
<link rel="stylesheet" href="css/login.css" />
</head>

<body>
	<div class="dvhead">
		<div class="dvlogo">
			<a href="index.jsp">小小论坛</a>
		</div>
		<div class="dvreg"></div>
	</div>
	<section class="sec">
		<form action="${pageContext.request.contextPath }/LoginAction_login"
			method="post">
			<div class="register-box">
				<label for="username" class="username_label"> 用 户 名 
					<input maxlength="20" name="username" type="text" placeholder="用 户 名" />
				</label>
				<div class="tips"></div>
			</div>
			<div class="register-box">
				<label for="username" class="other_label"> 密 码
					<input maxlength="20" name="password" type="password" />
				</label>
				<div class="tips" name="error" Style="color: red">${loginError }</div>
			</div>

			<div class="arguement">
				<a href="register.jsp">没有账号,立即注册</a> <a href="findPassword.jsp">忘记密码</a>
				<div class="tips"></div>
			</div>
			<div class="submit_btn">
				<button type="submit" id="submit_btn">立 即 登录</button>
			</div>
		</form>

	</section>
</body>