<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>Insert title here</title>
<script type="text/javascript">
window.onload = () => {
	let val = '�Ǹ���';
	if('${m.type}'=='1'){
		val = '������';
	}
	document.getElementById('type').innerHTML = val;
}
</script>
</head>
<body>
<h3>�� ���� Ȯ��</h3>
<form action="${pageContext.request.contextPath }/mem/myinfo" method="post">
<table border="1">
<tr><th>ID</th><td><input type="text" name="id" value="${m.id }" readonly></td></tr>
<tr><th>PWD</th><td><input type="text" name="pwd" value="${m.pwd }" ></td></tr>
<tr><th>NAME</th><td><input type="text" value="${m.name }" readonly></td></tr>
<tr><th>EMAIL</th><td><input type="text" value="${m.email }" readonly></td></tr>
<tr><th>TYPE</th><td id="type"></td></tr>
<tr><th>����</th><td><input type="submit" value="����"></td></tr>
</table>
</form>
</body>
</html>