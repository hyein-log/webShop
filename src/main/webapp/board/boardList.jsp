<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style type="text/css">
table, td {
border:1px solid green;
border-collapse: collapse;
padding: 10px;
}
</style>
</head>
<body>
	<h1>게시판목록</h1>
	<a href="boardInsert.do">게시글 작성하기</a>
	<hr>
	<table>
	<tr>
			<td>번호</td>
			<td>제목</td>
			<td>내용</td>
			<td>등록일</td>
			<td>업데이트일</td>
			<td>작성자</td>
		</tr>
		<c:forEach items="${boardLists }" var = "board">
		<tr>
			<td><a href = "boardDetail.do?boardid=${board.bno }">${board.bno }</a></td> <%--<a>태그는 get타입밖에 못받음 post안됨 --%>
			<td>${board.title }</td>
			<td>${board.content }</td>
			<td>${board.regdate }</td>
			<td>${board.update_date }</td>
			<td>${board.writer }</td>
		</tr>
		</c:forEach>
	</table>
</body>
</html>