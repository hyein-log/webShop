<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<h1>특정 보드상세조회</h1>
<%@ include file="../common/header.jsp" %>
<form action="boardDetail.do" method="post">
보드번호: <input type="number" name="boardid" value="1">
<input type="submit" value="보드조회">
</form>
</body>
</html>