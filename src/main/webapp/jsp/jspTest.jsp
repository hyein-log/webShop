
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"
    session="true"
	buffer="8kb"
	autoFlush="true"
	errorPage="error1.jsp"
	isErrorPage="false"
    %>
<%
String a ="JSP페이지";
int b = 10;
int c=0;
//System.out.println(b/c);

%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
isErrorPage : 나는 error시 보여주는 페이지 인가?
errorPage : 이 페이지가 오류시 이동되는 페이지는 error1.jsp이다의 의미



 --%>    
    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<h1>JSP구성요소</h1>
<%@ include file ="../common/header.jsp" %> <%--합치고 컴파일한다. --%>
<jsp:include page ="../common/header.jsp"></jsp:include> <%--컴파일하고 합친다. --%>

</body>
</html>