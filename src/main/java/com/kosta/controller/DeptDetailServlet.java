package com.kosta.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.kosta.dto.DeptDTO;
import com.kosta.model.DeptService;

/**
 * Servlet implementation class DeptDetailServlet
 */
@WebServlet("/html/dept.do")
public class DeptDetailServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String deptid = request.getParameter("dept_id"); //html���� name�� dept_id�� ���� value�� �� //�ּ�â�� ��
		System.out.println(deptid);
		
		int idept = Integer.parseInt(deptid);
		DeptService dService = new DeptService();
		DeptDTO dept = dService.selectById(idept);
		
//		response.setContentType("text/html;charset=utf-8");
//		PrintWriter  out = response.getWriter();
//		out.print("<h1> �Ķ���ͷ� ���� �μ���ȣ : "+deptid+"</h1>");
	
		if(dept != null) {
		request.setAttribute("deptName", dept.getDepartment_name()); //request�� �����ض�
		request.setAttribute("mid", dept.getManager_id()); //request�� �����ض�
		request.setAttribute("loc", dept.getLocation_id()); //request�� �����ض�
		}
		request.setAttribute("dept", dept);
		
		RequestDispatcher rd;
		rd = request.getRequestDispatcher("/dept/deptDetail.jsp");
		rd.forward(request, response); //Servlet�� �˰� �ִ� ������ jsp�� �Ѱ���
	}

}
