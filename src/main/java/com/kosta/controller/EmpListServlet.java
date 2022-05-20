package com.kosta.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.kosta.model.EMPService;

/**
 * Servlet implementation class EmpListServlet
 */
@WebServlet("/emp/emplist.do")
public class EmpListServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		EMPService empService = new EMPService();
		request.setAttribute("emplist", empService.selectAll());
		
		RequestDispatcher rd; //����(��û�� ���� ���� servlet�ε� ������ JSP�� �ϵ�����)
		rd = request.getRequestDispatcher("empList.jsp");
		rd.forward(request, response);
	}

}