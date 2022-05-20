package com.kosta.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class LoginServlet
 */
@WebServlet("/html/Login.do")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
   
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//get��û�� �ּ�â�� �Ķ���Ͱ� �ڵ����� ���ڵ��Ǿ� �Ѿ�´�. �׷��� �ѱ��� ������ �ʴ´�.
		//post��û�� ��û������ body�� �Ķ���Ͱ� ���ڵ��ȵż� �Ѿ�´�. �׷��� �ѱ��� ������.
		request.setCharacterEncoding("utf-8"); //post������ �ʼ��� �ʿ���
		String id = request.getParameter("userid");
		String password = request.getParameter("userpw");
		System.out.println(id+"-->"+password);
		System.out.println(request.getMethod()); //get���� post���� �� �� ����
		System.out.println(request.getContextPath());
		
		//<MVC1��> ���� ����. �ٶ����� �𵨻���� MVC2��
//		//���乮�� ����� ���� ���乮���� Ÿ�԰� ���ڵ� ����� �����ؾ���
//		response.setContentType("text/html;charset=utf-8");
//		//���乮�� �����
//		PrintWriter out = response.getWriter();
//		out.write("<h1>�α��ο� ����</h1>");
//		out.write("<h2>DB���� �� �ٽ� �����ϱ�</h2>");
		
		//<MVC2��>
		//servlet�� �������� JSP�� �����Ѵ�. �ּ�â�� ������� ����
		//A�� �θ��� B�� ���� ���� �����Ѵٶ�� ��
		RequestDispatcher rd = request.getRequestDispatcher("../jsp/loginResult.jsp");
		rd.forward(request, response);
	}

}