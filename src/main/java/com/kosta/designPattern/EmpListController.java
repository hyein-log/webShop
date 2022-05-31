package com.kosta.designPattern;

import javax.servlet.http.HttpServletRequest;

import com.kosta.model.EMPService;

public class EmpListController implements Command {

	@Override
	public String execute(HttpServletRequest request) {
		EMPService empService = new EMPService();
		request.setAttribute("emplist", empService.selectAll());
		return "empList.jsp";
	}

}
