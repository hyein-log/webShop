package com.kosta.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.kosta.dto.DeptDTO;
import com.kosta.model.DeptService;

/**
 * Servlet implementation class DeptUpdateServlet
 */
@WebServlet("/dept/deptUpdate.do")
public class DeptUpdateServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//필터로 처리함request.setCharacterEncoding("utf-8");
		String department_name = request.getParameter("department_name");
		int manager_id = Integer.parseInt(request.getParameter("manager_id"));
		int location_id = Integer.parseInt(request.getParameter("location_id"));
		int department_id = Integer.parseInt(request.getParameter("department_id"));
		
		
		DeptDTO deptDTO = new DeptDTO(department_id, department_name, manager_id, location_id);
		DeptService deptService = new DeptService();
		int result = deptService.deptUpdate(deptDTO);
		String message = "수정실패";
		if(result >0) message="수정성공";
		request.setAttribute("message", message);
		RequestDispatcher rd;
		rd = request.getRequestDispatcher("result.jsp");
		rd.forward(request, response);
	}

}
