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
		System.out.println("getContextPath"+request.getContextPath()); //결과 : /webShop -> 모듈에 설정된 Path값이 출력되므로 모듈에서 수정하면 값이 바뀌어서 출력됨
		System.out.println("getRequestURL"+request.getRequestURL());//결과 : http://localhost:9090/webShop/first/test1
		System.out.println("getRequestURI"+request.getRequestURI());//결과 : /webShop/first/test1
		System.out.println("getServletPath"+request.getServletPath());//결과 : /first/test1
		System.out.println("getServerPort"+request.getServerPort());//결과 : 9090
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

}
