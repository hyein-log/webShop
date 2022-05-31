package com.kosta.controller2;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.kosta.dto.EMPVO;
import com.kosta.model.EMPService;


@WebServlet("/emp/emailduplicateCheck.do")
public class EmpEmailDuplicateCheckServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        
        String empemail = request.getParameter("email");
        EMPService service = new EMPService();
        if(empemail==null)  return ;
        String i_empemail = empemail;
        System.out.println("empemail:" + empemail);
        //DB에 직원id가 존재하는지 체크한다. ???empService->empDAO-->DB
        EMPVO emp2 = service.selectByEmail(i_empemail);
        PrintWriter out2 = response.getWriter();
        out2.print(emp2==null?0:1);//0이면 등록가능 , 1이면 등록불가
	}
}
