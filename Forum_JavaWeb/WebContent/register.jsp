<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>注册</title>
<link rel="stylesheet" type="text/css" href="css/login.css" />
<link rel="stylesheet" href="css/head.css" />
<link rel="stylesheet" type="text/css" href="css/login.css" />
<script type="text/javascript" src="${pageContext.request.contextPath }/js/jquery-1.7.2.min.js"></script>
<script type="text/javascript">
$(function(){
	
	$("input[name='username']").blur(verifyUsername);
	$("input[name='password']").blur(verifyPassword);
	$("input[name='checkPassword']").blur(verifyCheckPassword);
	$("input[name='phonenum']").blur(verifyPhonenum);
	
});
function verifyUsername(){
	$.ajax({
		url:encodeURI("${pageContext.request.contextPath }/VerifyUsername"),
		type:"post",
		data:{
			username:$("input[name='username']").val()
		},
		dataType:"json",
		success:function(msg){
// 			alert(msg.isSuccess);
			if(msg.isSuccess){
				$("#usernameMsg").html("<font color='green'>用户名可以用!</font>");
			}else{
				$("#usernameMsg").html("<font color='red'>用户名不能为空或用户名已经存在!</font>");
			}
		}
	});
}
function verifyPassword(){
	$.ajax({
		url:encodeURI("${pageContext.request.contextPath }/VerifyUsername"),
		type:"post",
		data:{
			password:$("input[name='password']").val()
		},
		dataType:"json",
		success:function(msg){
			if(msg.isSuccess){
				$("#passwordMsg").html("");
			}else{
				$("#passwordMsg").html("<font color='red'>密码不能为空!</font>");
			}
		}
	});
}
function verifyCheckPassword(){
	$.ajax({
		url:encodeURI("${pageContext.request.contextPath }/VerifyUsername"),
		type:"post",
		data:{
			password:$("input[name='password']").val(),
			checkPassword:$("input[name='checkPassword']").val()
		},
		dataType:"json",
		success:function(msg){
			if(msg.isSuccess){
				$("#checkPasswordMsg").html("");
			}else{
				$("#checkPasswordMsg").html("<font color='red'>跟设置密码不一致,清重新输入!</font>");
			}
		}
	});
}
function verifyPhonenum(){
	$.ajax({
		url:encodeURI("${pageContext.request.contextPath }/VerifyUsername"),
		type:"post",
		data:{
			phonenum:$("input[name='phonenum']").val()
		},
		dataType:"json",
		success:function(msg){
// 			alert(msg.isSuccess);
			if(msg.isSuccess){
				$("#phoneMsg").html("");
			}else{
				$("#phoneMsg").html("<font color='red'>手机号码有误，请重填!</font>");
			}
		}
	});
}
</script>
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
		<form action="${pageContext.request.contextPath }/RegisterServlet"
			method="post">
			<div class="register-box">
				<label for="username" class="username_label"> 用 户 名 
					<input maxlength="20" name="username" type="text" placeholder="用 户 名" />
				</label>
				<div class="tips" id="usernameMsg"></div>
			</div>
			<div class="register-box">
				<label for="username" class="other_label"> 设 置 密 码
					<input maxlength="20" type="password" name="password" placeholder="设 置 密 码" />
				</label>
				<div class="tips" id="passwordMsg"></div>
			</div>
			<div class="register-box">
				<label for="username" class="other_label"> 确 认 密 码
					<input maxlength="20" type="password" name="checkPassword" placeholder="确 认 密 码" />
				</label>
				<div class="tips" id="checkPasswordMsg"></div>
			</div>
			<div class="register-box">
				<label for="username" class="username_label"> 手 机 号
					<input maxlength="20" name="phonenum" type="text" placeholder="手 机 号" />
				</label>
				<div class="tips" name="phoneMsg" id="phoneMsg" Style="color: red">${registerError }</div>
				<div class="tips" name="error" Style="color: red"></div>
			</div>
			<div class="arguement">
				<a href="login.jsp">已有账号,立即登录</a>
				<div class="tips"></div>
			</div>
			<div class="submit_btn">
				<button type="submit" id="submit_btn">立 即 注 册</button>
			</div>
		</form>
	</section>
	<script src="js/index.js" type="text/javascript" charset="utf-8"></script>
</body>
</html>
