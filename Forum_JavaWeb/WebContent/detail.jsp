<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<title>小小论坛</title>
<meta name="viewport"
	content="width=device-width, initial-scale=1, maximum-scale=1">
<meta name="keywords" content="fly,layui,前端社区">
<meta name="description"
	content="">
<link rel="stylesheet" href="res/layui/css/layui.css">
<link rel="stylesheet" href="res/css/global.css">
<!-- <script src="res/layui/layui.js"></script> -->
<!-- <script src="js/jquery.js"></script> -->
<style type="text/css" rel="stylesheet">
form {
	margin: 0;
}

.editor {
	margin-top: 5px;
	margin-bottom: 5px;
}
</style>

</head>
<body>
	<iframe  src="head.jsp" scrolling="no" width="100%" height="65px" ></iframe>
	<div class="main layui-clear">
		<div class="wrap">
			<div class="content detail">
				<div class="fly-panel detail-box">
					<h1>${data.title }</h1>
<!-- 					<div class="fly-tip fly-detail-hint" data-id=""> -->
<!-- 						<span class="fly-tip-stick">置顶帖</span> -->
<!-- 						<span class="jie-admin">  -->
<!-- 							<a href="">点击置顶</a> </span>  -->
<!-- 						<span class="layui-btn layui-btn-mini jie-admin">  -->
<!-- 							<a href="">取消置顶</a></span>  -->
<!-- 						<span class="jie-admin" type="del" style="margin-left: 20px;"> -->
<!-- 							<a>删除该帖</a> </span>  -->
<!-- 						</span> -->
<!-- 						<div class="fly-list-hint"> -->
<!-- 							<i class="iconfont" title="回答">&#xe60c;</i> 2  -->
<!-- 						</div> -->
<!-- 					</div> -->
					<div class="detail-about">
						<div class="jie-user" href=""> 
							<img src="res/images/uer.jpg" alt="头像"> 
								<cite> ${data.user.username } <em>${data.dtime } 发布</em> </cite> </div>
								<c:if test="${user.admin }"> 
									<div class="detail-hits" data-id="{{rows.id}}">
			<!-- 							 <span class="layui-btn layui-btn-mini jie-admin"> -->
			<!-- 							 	<a href="#">已完帖，无法编辑</a> </span>  -->
			<!-- 							 <span class="layui-btn layui-btn-mini jie-admin" type="collect" data-type="add">  -->
			<!-- 							 	<a id="collectPost">收藏</a> </span>  -->
										 <span class="layui-btn layui-btn-mini jie-admin  layui-btn-danger" type="collect" data-type="add"> 
										 	<a href="${pageContext.request.contextPath }/DeleDataServlet?delId=${data.id }" >删除</a>
										 </span>
									</div>
								</c:if>
					</div>
					<div class="detail-body photos" style="margin-bottom: 20px;">
						<p>${data.dcontent }</p>
					</div>
				</div>
				<div class="fly-panel detail-box" style="padding-top: 0;">
					<a name="comment"></a>
					<ul class="jieda photos" id="jieda">
					
					<c:forEach items="${answers }" var="answer">
						<li data-id="12" class="jieda-daan">
							<a name="item-121212121212"></a>
							<div class="detail-about detail-about-reply">
								<a class="jie-user" href=""> 
								<img src="res/images/uer.jpg" alt=""> 
								<cite> 
									<i>${answer.user.username }</i>
									<!-- <em>(楼主)</em>
                  						 <em style="color:#5FB878">(管理员)</em> --> 
                				</cite> </a>
								<div class="detail-hits">
<!-- 									<span>3分钟前</span> -->
								</div>
<!-- 							<i class="iconfont icon-caina" title="最佳答案"></i> -->
							</div>
							<div class="detail-body jieda-body">
								<p>${answer.acontent }</p>
							</div>
							<div class="liulan">${answer.atime }</div> 
							<div class="jieda-reply">
<!-- 								<span class="jieda-zan zanok" type="zan"> -->
<!-- 									<i class="iconfont icon-zan"></i> -->
<!-- 									<em>12</em> -->
<!-- 								</span>  -->
							<c:if test="${user.admin }"> 
 								<div class="jieda-admin">
					                <span type="del">
					                <a href="${pageContext.request.contextPath }/DeleAnswerServlet?delId=${answer.id }&did=${data.id }" class="layui-btn layui-btn-danger layui-btn-small">删除</a></span>
					                </span>
<!-- 									<span class="jieda-accept" type="accept"> -->
<!-- 									<a href="#" class="layui-btn  layui-btn-small">采纳</a></span> -->
               					</div>
               				</c:if>
							</div>
						</li>
						</c:forEach>

						<!-- <li class="fly-none">没有任何回答</li>  -->
					</ul>
					<span id="toName">${user.username }</span>		
					<div class="layui-form layui-form-pane">
						<form action="${pageContext.request.contextPath }/DetailSubmitServlet?id=${param.id }" method="post">
							<div class="layui-form-item layui-form-text">
								<div class="layui-input-block">
									<textarea id="L_content" name="content" required lay-verify="required" 
									placeholder="我要回复" class="layui-textarea fly-editor" style="height: 150px;">
									</textarea>
								</div>
							</div>
							<div class="layui-form-item">
								<button class="layui-btn" type="submit" id="submit_btn">提交回答</button>
							</div>
						</form>
					</div>
				</div>
			</div>
		</div>

	</div>
 <script type="text/javascript" charset="utf-8" src="res/js/kindeditor.js"></script>
  <script type="text/javascript">
    KE.show({
        id : 'L_content',
		resizeMode : 1,
        items : [
        'fontname', 'fontsize', 'textcolor', 'bgcolor', 'bold', 'italic', 'underline',
        'removeformat', 'justifyleft', 'justifycenter', 'justifyright', 'insertorderedlist',
        'insertunorderedlist', 'emoticons', 'image', 'link']
    });
  </script>
</body>
</html>