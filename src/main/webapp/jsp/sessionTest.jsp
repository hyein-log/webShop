<%@page import="com.kosta.dto.BoardVO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<%
String menu = "아메리카노";
BoardVO board = new BoardVO(100,"목요일","5시입니다", 101, null, null);
request.setAttribute("menuReq", menu);
request.setAttribute("boardReq", board);
session.setAttribute("menuSe", menu);
session.setAttribute("boardSe", board);
application.setAttribute("menuApp", menu);
application.setAttribute("boardApp", board);
%>
<p>menuApp : ${menuApp }</p>
<p>menuSe : ${menuSe }</p>
<p>menuReq : ${menuReq }</p>
<p>boardApp : ${boardApp }</p>
<p>boardSe : ${boardSe }</p>
<p>boardReq : ${boardReq }</p>
<a href="sessionTest2.jsp" >다른 페이지로 이동</a>
</body>
</html>