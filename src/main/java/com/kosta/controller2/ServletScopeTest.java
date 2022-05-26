package com.kosta.controller2;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/ServletScopeTest")
public class ServletScopeTest extends HttpServlet {
	private static final long serialVersionUID = 1L;
   
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		ServletContext application = getServletContext();
		HttpSession session = request.getSession();
		application.setAttribute("appVar", "������ ����ִ� ����(started) ��� jsp/servlet���� ���� ����");
		session.setAttribute("sessionVar", "�������� ����ִ� ���� ��� jsp/servlet���� ���� ����");
		request.setAttribute("requestVar", "��û�� ����ִ� ����(��û�� �ٲ��� �ʴ� ����) jsp/servlet���� ���� ����");
		application.setAttribute("myphone", "1");
		session.setAttribute("myphone", "2");
		request.setAttribute("myphone", "3");

		RequestDispatcher rd;
		rd = request.getRequestDispatcher("jsp/scopeTest.jsp");
		rd.forward(request, response);
	}


}
