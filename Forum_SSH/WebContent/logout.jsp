<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="com.lmj.model.User" %>
<%@ page import="com.lmj.util.SessionManager" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

<%
	User u = new User();
	u = (User)session.getAttribute("user");
	session.removeAttribute("user");
	response.sendRedirect(request.getContextPath() + "/index.jsp");
	if(SessionManager.SessionMap.containsKey(u.getUsername())){
		SessionManager.SessionMap.remove(u.getUsername());
	}
%>
</body>
</html>