<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<h3>이미지 목록</h3>
<c:forEach var="i" items="${files }">
	<img src="/imgs/${i }" style="width:150px;height:150px"><br/>
</c:forEach>
</body>
</html>