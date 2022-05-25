package com.kosta.controller2;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebInitParam;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class ServletConfigTest
 */
//@WebServlet(
//		urlPatterns = { 
//				"/ServletConfigTest", 
//				"/config1", 
//				"/config2"
//		}, 
//		initParams = { 
//				@WebInitParam(name = "myaddress", value = "����� ���α�"), 
//				@WebInitParam(name = "myphone", value = "010-1234-1234")
//		})
public class ServletConfigTest extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	public ServletConfigTest() {
		System.out.println("ServletConfigTest ������");
	}
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
		String myphone = getInitParameter("myphone");
		String myaddress = getInitParameter("myaddress");
		System.out.println(myaddress);
		System.out.println(myphone);
	}

}
