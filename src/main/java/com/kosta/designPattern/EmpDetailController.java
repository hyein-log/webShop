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

public class EmpDetailController implements Command {

	@Override
	public String execute(HttpServletRequest request) {
		String method = request.getMethod();
		String page = null;
		if(method.equals("GET")) {
			String empid = request.getParameter("empid");
			int i_empid = 0;
			
			System.out.println("empid=" + empid);
			
			if(empid !=null ) {
				i_empid = Integer.parseInt(empid);
			}
			EMPService eService = new EMPService();
			EMPVO emp = eService.selectById(i_empid);
			System.out.println(emp);
			request.setAttribute("emp", emp);
			
			page = "empDetail.jsp";
		}else {
			EMPVO emp = makeEMP(request);
			EMPService empService = new EMPService();
			int result = empService.empUpdate(emp);
			request.setAttribute("message", result>0?"�������� �Է¼���":"�Է½���");
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
