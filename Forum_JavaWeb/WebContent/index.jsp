<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8" />
<link rel="stylesheet" type="text/css" href="css/index.css">
</head>
<div class="dvhead">
	<div class="dvlogo">
		<a href="index.jsp">小小论坛</a>
	</div>
	<div class="dvreg">

		<c:choose>
			<c:when test="${user==null }">
				已有账号，立即&nbsp;<a href="login.jsp">登录</a>
			</c:when>
			<c:otherwise>
				${user.username } 
				<a href="logout.jsp"> 注销   </a>
			</c:otherwise>
		</c:choose>
	</div>
</div>
<div class="dvContent">
	<div class="dvquesleft">

		<div class="dvqstitle">
			<image class="imgbean" src="images/bean.jpg"> <span
				class="qsTitle">讨论区</span>
		</div>
		<div class="dvtabhead">
			<div class="tabheads tabcurrent">全部帖子</div>
			<div class="tabheads">我的帖子</div>
			<div class="tabheads">我的关注</div>
		</div>
		<div class="tabContent">
			<div class="tab">
				<c:forEach items="${initDatas }" var="data">
					<div class="dvques">
						<div class="quesCount">
							<div class="count">${data.ansnum }</div>
							<div class="ques">回答数</div>
						</div>
						<div class="quesContent">
							<div class="quesTitle">
								500
								<image src="images/bean.jpg" class="bean"> <span
									class="spanques">
									<a href="${pageContext.request.contextPath }/DetailServlet?id=${data.id }"> 
									${data.title }</a></span>
							</div>
							<div class="qContent">${data.content }</div>
							<div class="tags">
								<!-- <span class="tag">excel</span><span class="tag">程序</span> -->
							</div>
							<div class="quesUser">
								<image src="images/0.gif" class="imguser" />
								<div class="userName">
									${data.username }
									<!-- <div class="liulan">浏览(9) 30分钟前</div> -->
								</div>

							</div>
						</div>
					</div>
				</c:forEach>
			</div>
			<div class="tab hidden">2</div>
			<div class="tab hidden">3</div>
			<div class="tab hidden">4</div>
		</div>
	</div>
	<div class="dvquesright">
		<div>
			<buton class="btnques" onclick="location.href='add.jsp'">提个问题</buton>
		</div>
		<div class="dvorder">
			<div class="orderTitle">专家排行榜</div>
			<div class="users">
				<image class="userface" src="images/0.gif" />
				<div class="dvuser">
					<div class="userTitle">陈有龙</div>
					<div class="userdeital">大牛6级 豆:14006</div>
				</div>
			</div>
			<div class="users">
				<image class="userface" src="images/1.gif" />
				<div class="dvuser">
					<div class="userTitle">陈有龙</div>
					<div class="userdeital">大牛6级 豆:14006</div>
				</div>
			</div>
			<div class="users">
				<image class="userface" src="images/2.gif" />
				<div class="dvuser">
					<div class="userTitle">陈有龙</div>
					<div class="userdeital">大牛6级 豆:14006</div>
				</div>
			</div>
			<div class="users">
				<image class="userface" src="images/3.gif" />
				<div class="dvuser">
					<div class="userTitle">陈有龙</div>
					<div class="userdeital">大牛6级 豆:14006</div>
				</div>
			</div>
			<div class="users">
				<image class="userface" src="images/4.gif" />
				<div class="dvuser">
					<div class="userTitle">陈有龙</div>
					<div class="userdeital">大牛6级 豆:14006</div>
				</div>
			</div>
			<div class="users">
				<image class="userface" src="images/5.gif" />
				<div class="dvuser">
					<div class="userTitle">陈有龙</div>
					<div class="userdeital">大牛6级 豆:14006</div>
				</div>
			</div>
			<div class="users">
				<image class="userface" src="images/6.gif" />
				<div class="dvuser">
					<div class="userTitle">陈有龙</div>
					<div class="userdeital">大牛6级 豆:14006</div>
				</div>
			</div>


		</div>

	</div>

</div>
<script type="text/javascript" src="js/jquery-1.7.2.min.js"></script>
<script type="text/javascript">
	$(function() {

		$(".tabheads").click(
				function() {
					$(".tabheads").removeClass("tabcurrent")
							.eq($(this).index()).addClass("tabcurrent");
					$(".tab").hide().eq($(this).index()).show();
				});
	});
</script>
<body>
</body>
</html>


