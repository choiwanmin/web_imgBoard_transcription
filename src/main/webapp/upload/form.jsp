<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<h3>자료 올리기</h3>
<form action="${pageContext.request.contextPath }/upload/upload" method="post" enctype="multipart/form-data">
제목:<input type="text" name="title"><br/>
파일:<input type="file" name="f"><br/>
<input type="submit" value="전송">
</form>
</body>
</html>