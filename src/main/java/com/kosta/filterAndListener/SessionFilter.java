package com.kosta.filterAndListener;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.kosta.dto.UserVO;

/**
 * Servlet Filter implementation class SessionFilter
 */
@WebFilter("/*")
public class SessionFilter implements Filter {

	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {

		HttpServletRequest req = (HttpServletRequest) request;
		HttpServletResponse resp = (HttpServletResponse) response;
		HttpSession session = req.getSession();
		String path = req.getServletPath();
		
		if (!path.equals("/html/Login.do")) {
			session.setAttribute("requestPath", req.getContextPath()+path);
			UserVO user = (UserVO) session.getAttribute("user");
			if (user == null) {
				req.setAttribute("path", path);
				System.out.println("로그인 실패...직원정보 볼 수 없음");
				resp.sendRedirect(req.getContextPath() + "/html/Login.do");
				return;
			}
		}else {
			session.setAttribute("reqPath", req.getContextPath()+"/1.jsp");
			
		}
		chain.doFilter(request, response);
	}

}
