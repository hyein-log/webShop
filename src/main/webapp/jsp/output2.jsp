<%@page import="java.util.Map"%>
<%@page import="java.util.HashMap"%>
<%@page import="java.util.List"%>
<%@page import="java.util.ArrayList"%>
<%@page import="com.kosta.dto.Product"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>장바구니 현황2</h1>
	<%
	request.setCharacterEncoding("utf-8");
	String prodname = request.getParameter("prod");

	String count = request.getParameter("count");
	int i_count = 0;
	if (count != null) {
		i_count = Integer.parseInt(count);
	}
	Product pro = new Product(prodname, i_count);

	//장바구니가 세션에 있으면 얻고 없으면 만들어야함
	Map<String, Product> plist = (HashMap) session.getAttribute("cart");
	if (plist == null)
		plist = new HashMap<>();

	//같은 상품이 있으면 갯수를 수정한다.
	if (plist.containsKey(prodname)) {
		Product p2 = plist.get(prodname);
		p2.setCount(p2.getCount() + i_count);
	} else {
		if (prodname != null) {
			plist.put(prodname, pro);
		}
	}

	session.setAttribute("cart", plist);

	//출력
	for (String key : plist.keySet()) {
		Product p = plist.get(key);
		out.write("<p>" + p.getName() + " : " + p.getCount() + "</p>");
	}
	%>
	<a href="input.jsp">계속 구매하기</a>
	<button id="btnClear" onclick="location.href='cartRemove'">장바구니비우기</button>
</body>
</html>