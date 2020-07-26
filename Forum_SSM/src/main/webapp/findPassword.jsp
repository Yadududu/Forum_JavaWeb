<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>找回密码</title>
<link rel="stylesheet" type="text/css" href="css/login.css" />
<link rel="stylesheet" href="css/head.css" />
<link rel="stylesheet" type="text/css" href="css/login.css" />
</head>

<body>
	<div class="dvhead">
		<div class="dvlogo">
			<a href="index.jsp">小小论坛</a>
		</div>
		<div class="dvreg">
			
		</div>
	</div>
	<section class="sec">
		<form action="${pageContext.request.contextPath }/findPassword"
			method="post">
			<div class="register-box">
				<label for="username" class="username_label"> 用 户 名 <input
					maxlength="20" type="text" name="username" />
				</label>
				<div class="tips"></div>
			</div>
			<div class="register-box">
				<label for="username" class="username_label"> 手机号 <input
					maxlength="20" type="text" name="phonenum" />
				</label>
				<div class="tips"></div>
			</div>
			<div class="register-box">
				<label for="username" class="other_label"> 新密 码 <input
					maxlength="20" type="password" name="password" />
				</label>
				<div class="tips"></div>
			</div>
			<div class="register-box">
				<label for="username" class="other_label"> 确认密码<input
					maxlength="20" type="password" name="checkPassword" />
				</label>
				<div class="tips" name="error" Style="color: red">
					${error }
				</div>
			</div>
			<div class="arguement">
				<div class="tips"></div>
			</div>
			<div class="submit_btn">
				<button type="submit" id="submit_btn">修改密码</button>
			</div>
		</form>
	</section>
	<script src="js/index.js" type="text/javascript" charset="utf-8"></script>
</body>
</html>
