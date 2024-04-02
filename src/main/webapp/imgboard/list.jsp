<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script type="text/javascript">
const a = (num) => {
	let params = 'writer=${sessionScope.loginId}';
	params += '&content='+document.getElementById('cont_'+num).value;
	params += '&imgnum='+num;
	alert(params);
	
	const req = new XMLHttpRequest();
	req.onload = () => {
		let arr = JSON.parse(req.responseText);
		let txt = '';
		for(let obj of arr){
			txt += obj.content+'(writer:'+obj.writer+')<br/>';
		}
		document.getElementById('reps_'+num).innerHTML = txt;
	}
	req.open('post', '${pageContext.request.contextPath }/reps/add');
	req.setRequestHeader("Content-type", "application/x-www-form-urlencoded");
	req.send(params);
	document.getElementById('cont_'+num).value = '';
}
</script>
</head>
<body>
<h3>이미지 게시판</h3>
<a href="${pageContext.request.contextPath }/imgboard/add">글작성</a><br/>
<c:forEach var="b" items="${list }">
<table border="1">
<tr><th>num</th><td>${b.num }</td></tr>
<tr><th>writer</th><td>${b.writer }</td></tr>
<tr><th>wdate</th><td>${b.wdate }</td></tr>
<tr><th>title</th><td>${b.title }</td></tr>
<tr><th>img</th><td><img src="${b.img }" style="width:200px;height:200px"></td></tr>
<tr><th>content</th><td>${b.content }</td></tr>
<tr><th>댓글작성</th>
	<td>
		<input type="text" id="cont_${b.num }">
		<input type="button" value="작성" onclick="a(${b.num })">
	</td>
</tr>
<tr><th>댓글목록</th><td id="reps_${b.num }"></td></tr>
</table>
</c:forEach>
</body>
</html>