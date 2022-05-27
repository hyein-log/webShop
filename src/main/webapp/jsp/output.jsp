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
	<h1>장바구니 현황</h1>
	<%
	String prodname = request.getParameter("prod");
	String count = request.getParameter("count");
	int i_count = 0;
	if (count != null) {
		i_count = Integer.parseInt(count);
	}
	Product pro = new Product(prodname, i_count);

	//장바구니가 세션에 있으면 얻고 없으면 만들어야함
	List<Product> plist = (ArrayList) session.getAttribute("cart");
	if (plist == null)
		plist = new ArrayList<>();

	//같은 상품이 있으면 갯수를 수정한다.
	boolean flag = false;
	for(Product p : plist){
		if(p.getName().equals(prodname)){
			p.setCount(p.getCount() +i_count);
			flag = true;
		}
	}if(!flag) plist.add(pro);
	
	
	session.setAttribute("cart", plist);

	//출력
	for (Product p : plist) {

		out.write("<p>" + p.getName() + " : " + p.getCount() + "</p>");
	}
	%>
	<a href="input.jsp">계속 구매하기</a>
	<button id = "btnClear" onclick ="location.href='cartRemove'">장바구니비우기</button>
</body>
</html>