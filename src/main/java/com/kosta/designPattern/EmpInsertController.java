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

public class EmpInsertController implements Command {

	@Override
	public String execute(HttpServletRequest request) {
		String method = request.getMethod();
		String page = null;
		if(method.equals("GET")) {
			DeptService deptService = new DeptService();
			List<DeptDTO> dlist = deptService.selectAll();
			request.setAttribute("dlist", dlist);
			
			EMPService empService = new EMPService();
			List<JobVO> jlist = empService.selectJobAll();
			request.setAttribute("jlist", jlist);
			Map<Integer, String> mlist  = empService.selectManagerAll();
			request.setAttribute("mlist", mlist);
			
			page = "empInsert.jsp";
		}else {
			EMPVO emp = makeEMP(request);
			EMPService empService = new EMPService();
			int result = empService.empInsert(emp);
			request.setAttribute("message", result>0?"직원정보 입력성공":"입력실패");
			page ="result.jsp";
		}
		return page;
	}
	private EMPVO makeEMP(HttpServletRequest request) {
		EMPVO empvo = new EMPVO();
		int empid = readInt(request, "employee_id");
		int manager_id = readInt(request, "manager_id");
		int department_id = readInt(request, "department_id");
		double salary = readDouble(request, "salary");
		double commission_pct = readDouble(request, "commission_pct");
		Date hire_date = readDate(request, "hire_date");
		
		String first_name = request.getParameter("first_name");
		String last_name = request.getParameter("last_name");
		String email = request.getParameter("email");
		String phone_number = request.getParameter("phone_number");
		String job_id = request.getParameter("job_id");
		
		empvo.setCommission_pct(commission_pct);
		empvo.setDepartment_id(department_id);
		empvo.setEmail(email);
		empvo.setEmployee_id(empid);
		empvo.setFirst_name(first_name);
		empvo.setHire_date(hire_date);
		empvo.setJob_id(job_id);
		empvo.setLast_name(last_name);
		empvo.setManager_id(manager_id);
		empvo.setPhone_number(phone_number);
		empvo.setSalary(salary);
		return empvo;
	}
	private int readInt(HttpServletRequest request, String str) {
		String data = request.getParameter(str);
		return Integer.parseInt(data);
	}
	private double readDouble(HttpServletRequest request, String str) {
		String data = request.getParameter(str);
		return Double.parseDouble(data);
	}
	private Date readDate(HttpServletRequest request, String str) {
		String data = request.getParameter(str);
		return DateUtil.convertToDate(data);
	}

}
