<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%--이것은 jsp 주석. jsp에서만 보임. .java, .html에는 없다. 

Derective
%@ page
%@ include
%@ taglib

--%>
<%
/*
자바주석임
*/
//자바코드가 .java의 service메서드에 들어간다.
String coffee = "아메리카노";
out.println("<h2>"+coffee+"</h2>");
%>
<%!
//멤버변수와 멤버메서드를 만듦
int price = 2000;
public int getPrice(){
	return price;
}
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<!-- html주석이다. html문서에서 볼수있다. -->
<h1><%=coffee %></h1> <%--expression, 문자아니므로 ; 사용하면 안됨 --%>

<%
for(int i=1; i<=5; i++){ %>
	<h3><%=i %></h3>
<%}

%>
</body>
</html>