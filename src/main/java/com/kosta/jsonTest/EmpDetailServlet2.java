package com.kosta.jsonTest;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Date;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.json.simple.JSONObject;

import com.kosta.dto.EMPVO;
import com.kosta.dto.UserVO;
import com.kosta.model.EMPService;
import com.kosta.util.DateUtil;

/**
 * Servlet implementation class EmpDetailServlet
 */
@WebServlet("/emp/empDetail2.do")
public class EmpDetailServlet2 extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String emp_id = request.getParameter("empid");
		int i_empid=0;
		if(emp_id !=null) {
			i_empid = Integer.parseInt(emp_id);
		}
		
		EMPService empService = new EMPService();
		EMPVO emp = empService.selectById(i_empid);
		
		JSONObject obj = new JSONObject();
		obj.put("emp_fname", emp.getFirst_name());
		obj.put("emp_lname", emp.getLast_name());
		String jsonstr = obj.toJSONString();
		response.setContentType("text/html; charset=utf-8");
		PrintWriter writer = response.getWriter();
		writer.print(jsonstr);
		
	}

}
