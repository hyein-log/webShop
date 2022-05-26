package com.kosta.controller2;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class URLPatternTest
 */
//@WebServlet("/first/test1")
//@WebServlet("/first/*")
@WebServlet("*.aa")
public class URLPatternTest extends HttpServlet {
	private static final long serialVersionUID = 1L;
   
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("getContextPath"+request.getContextPath()); //��� : /webShop -> ��⿡ ������ Path���� ��µǹǷ� ��⿡�� �����ϸ� ���� �ٲ� ��µ�
		System.out.println("getRequestURL"+request.getRequestURL());//��� : http://localhost:9090/webShop/first/test1
		System.out.println("getRequestURI"+request.getRequestURI());//��� : /webShop/first/test1
		System.out.println("getServletPath"+request.getServletPath());//��� : /first/test1
		System.out.println("getServerPort"+request.getServerPort());//��� : 9090
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

}
