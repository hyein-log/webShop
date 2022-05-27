<%@page import="java.util.HashMap"%>
<%@page import="java.util.Map"%>
<%@page import="java.util.ArrayList"%>
<%@page import="java.util.List"%>
<%@page import="com.kosta.dto.Product"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%
application.setAttribute("myname", "kimhyein");
session.setAttribute("myname", "hyein");
request.setAttribute("myname", "hi");
pageContext.setAttribute("myname", "혜인");
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<h1>el문법 익히기</h1>
<pre>
page > request > session > application
1. 저장영역에 읽기 : ${myname }
1. 저장영역에 읽기 : ${applicationScope.myname }
1. 저장영역에 읽기 : ${sessionScope.myname }
1. 저장영역에 읽기 : ${requestScope.myname }
1. 저장영역에 읽기 : ${pageScope.myname }

<%--http://localhost:9090/webShop/jsp/elTest2.jsp?myname=hi&subject=aa&subject=b --%>
2. param : ${param.myname}
2. param : ${paramValues.subject[0]}
2. param : ${paramValues.subject[1]}

3.pageContext : 내장객체이용시 이용 : ${pageContext.request.contextPath }

4-1.로그인한 사용자 정보: ${user }
4-2.사용자 이름: ${user.user_name }
<%
pageContext.setAttribute("productVO", new Product("코코볼", 1000));
List<Product> plist = new ArrayList<>();
plist.add(new Product("첵스초코",1200));
plist.add(new Product("콘푸로스트",1300));
plist.add(new Product("오레오오즈",1400));
request.setAttribute("plist", plist);
%>
5-1.객체얻기 : ${productVO.name } <%--getName()호출됨 --%>
5-2.객체얻기 : ${productVO.count } <%--getCount()호출됨 --%>

6-1 collection 얻기 : ${plist[0].name}
6-1 collection 얻기 : ${plist[0].count}
6-2 collection 얻기 : ${plist[1].name}
6-2 collection 얻기 : ${plist[1].count}

7.JSTL 문법
<c:forEach items="${plist }" var="pro">
${pro.name } ===== ${pro.count }
</c:forEach>

8.map이용
<%
Map<String, Product> cart = new HashMap<>();
cart.put("야채",new Product("양배추",10));
cart.put("야채",new Product("토마토",5));
cart.put("과일",new Product("멜론",2));
cart.put("c",new Product("삼겹살",7));
request.setAttribute("cartdata", cart);
%>
${cartdata["과일"].name}
${cartdata.c.name}

<c:forEach items="${cartdata }" var="map">
${map.key }------${map.value.name }-------${map.value.count }
</c:forEach>

</pre>


</body>
</html>