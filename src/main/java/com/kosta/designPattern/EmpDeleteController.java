package com.kosta.designPattern;

import java.sql.Date;
import java.util.List;
import java.util.Map;

import javax.servlet.RequestDispatcher;
import javax.servlet.http.HttpServletRequest;

import com.kosta.dto.DeptDTO;
import com.kosta.dto.EMPVO;
import com.kosta.dto.JobVO;
import com.kosta.model.DeptService;
import com.kosta.model.EMPService;
import com.kosta.util.DateUtil;

public class EmpDeleteController implements Command {

	@Override
	public String execute(HttpServletRequest request) {

		int emp_id = Integer.parseInt(request.getParameter("emp_id"));
		EMPService empService = new EMPService();
		int result = empService.empDelete(emp_id);
		request.setAttribute("message", result>0?"삭제성공":"실패");
		
		return "empList.jsp";
	}
	
}
