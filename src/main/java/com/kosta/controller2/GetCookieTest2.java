package com.kosta.controller2;

import java.io.IOException;
import java.net.URLDecoder;
import java.net.URLEncoder;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class SetCookieTest
 */
@WebServlet("/GetC")
public class GetCookieTest2 extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public GetCookieTest2() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String output="";
		Cookie[] cs = request.getCookies();
		for( Cookie c : cs) {
			System.out.println("ÄíÅ°ÀÌ¸§ : "+c.getName());
			if(c.getName().equals("cookie_title")) {
				String str = URLDecoder.decode(c.getValue(), "utf-8");
				System.out.println("ÄíÅ° °ª : "+str);
				output +="<h3>"+c.getName()+"--->"+str+"</h3>";
			}else {
				System.out.println("ÄíÅ° °ª : "+c.getValue());
				output +="<h3>"+c.getName()+"--->"+c.getValue()+"</h3>";
			}
			
		}
		response.setContentType("text/html;charset=utf-8");
		response.getWriter().append("<h1>Served at: cookie ÀÐ±â¿¹Á¦</h1>").append(request.getContextPath()).append(output);
	}

}
