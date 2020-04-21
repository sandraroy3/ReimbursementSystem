package dev.sandra.servlets;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


public class EmpHomePage extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
   
    public EmpHomePage() {
        super();
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String username=(String) request.getSession().getAttribute("username");
		System.out.println("Username in EmpHomePage Servlet is "+username);
		response.getWriter().append(username);
		//response.getWriter().append(username);
		//response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
