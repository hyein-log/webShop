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
//자바땅
//내장객체가 제공됨 : application , session, request
//내장객체, 즉 정해진 이름이기에 내 맘대로 바꿀 수 없음

%>
<h1>scopeTest2.jsp 페이지..servlet scope를 test함(서블릿과 연결안함)</h1>
<h2>scriptLet문법</h2>
<p>application영역에 접근 : <%=application.getAttribute("appVar") %></p>
<p>session영역에 접근 : <%=session.getAttribute("sessionVar") %></p>
<p>request영역에 접근 : <%=request.getAttribute("requestVar") %></p>
<hr>
<h2>EL(Expression Language)문법</h2>
<p>application영역에 접근 : ${appVar}</p>
<p>session영역에 접근 : ${sessionVar}</p>
<p>request영역에 접근 : ${requestVar}</p>
</body>
</html>