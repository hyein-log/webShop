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
<h1>scopeTest.jsp 페이지..servlet scope를 test함</h1>
<h2>scriptLet문법</h2>
<p>application영역에 접근 : <%=application.getAttribute("appVar") %></p>
<p>session영역에 접근 : <%=session.getAttribute("sessionVar") %></p>
<p>request영역에 접근 : <%=request.getAttribute("requestVar") %></p>
<hr>
<h2>EL(Expression Language)문법</h2>
<p>application영역에 접근 : ${appVar}</p>
<p>session영역에 접근 : ${sessionVar}</p>
<p>request영역에 접근 : ${requestVar}</p>

<h2> scope순서 :  request>session>application   </h2>
<h2>scope영역이 좁은순서로 찾는다: ${myphone }</h2>
<h2>applicationScope : ${applicationScope.myphone }</h2>
<h2>sessionScope : ${sessionScope.myphone }</h2>
<h2>requestScope : ${requestScope.myphone }</h2>

</body>
</html>