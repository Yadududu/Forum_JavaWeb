<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
hi!<br>

<c:forEach items="${list}" var="d"  >
${d.id}<br>
${d.dtime}<br>
${d.user.id}<br>
${d.user.username}<br>
</c:forEach>

</body>
</html>