<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<title>小小论坛</title>
<meta charset="utf-8" />
<link rel="stylesheet" href="css/index.css">
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
				<a href="logout"> 注销   </a>
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
<!-- 			<div class="tabheads">我的帖子</div> -->
<!-- 			<div class="tabheads">我的关注</div> -->
		</div>
		<div class="tabContent">
			<div class="tab">
				<c:forEach items="${initDatas }" var="data">
					<div class="dvques">
						<div class="quesCount">
							<div class="count">${data.ansnum }</div>
							<div class="ques">回复数</div>
						</div>
						<div class="quesContent">
							<div class="quesTitle">
									<a href="${pageContext.request.contextPath }/data/detail?dId=${data.id }"> 
									${data.title }</a>
							</div>
							<div class="qContent">${data.dcontent }</div>
							<div class="tags">
<%-- 								<span class="tag">excel</span><span class="tag">程序</span> --%>
							</div>
							<div class="quesUser">
								<image src="images/0.gif" class="imguser" />
								<div class="userName">
									 ${data.user.username }
									 <div class="liulan">${data.dtime }</div> 
									 
									 <c:if test="${user.admin==true }"> 
									 	<a href="${pageContext.request.contextPath }/data/deleData?delId=${data.id }" class="layui-btn layui-btn-danger layui-btn-small">删除</a>
									 </c:if>
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
			<buton class="btnques" onclick="location.href='add.jsp'">发个帖子</buton>
		</div>
	</div>

</div>
<body>
</body>
</html>


