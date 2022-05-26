package com.kosta.filterAndListener;

import java.io.IOException;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;

/**
 * Servlet Filter implementation class EncodeFilter
 */
//@WebFilter("*.do")
public class EncodeFilter implements Filter {

    /**
     * Default constructor. 
     */
    public EncodeFilter() {
       System.out.println("���ͻ���");
    }

	/**
	 * @see Filter#destroy()
	 */
	public void destroy() {
		System.out.println("���ͼҸ�");
	}

	/**
	 * @see Filter#doFilter(ServletRequest, ServletResponse, FilterChain)
	 */
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
		// TODO Auto-generated method stub
		// place your code here
		request.setCharacterEncoding("utf-8");
		
		HttpServletRequest req =(HttpServletRequest)request;
		System.out.println("===========EncodeFilter===========");
		System.out.println("getContextPath"+req.getContextPath()); //��� : /webShop -> ��⿡ ������ Path���� ��µǹǷ� ��⿡�� �����ϸ� ���� �ٲ� ��µ�
		System.out.println("getRequestURL"+req.getRequestURL());//��� : http://localhost:9090/webShop/first/test1
		System.out.println("getRequestURI"+req.getRequestURI());//��� : /webShop/first/test1
		System.out.println("getServletPath"+req.getServletPath());//��� : /first/test1
		System.out.println("getServerPort"+req.getServerPort());//��� : 9090
		System.out.println("==================================");
		// pass the request along the filter chain
		chain.doFilter(request, response);
	}

	/**
	 * @see Filter#init(FilterConfig)
	 */
	public void init(FilterConfig fConfig) throws ServletException {
		System.out.println("�ʱ�ȭ");
	}

}
