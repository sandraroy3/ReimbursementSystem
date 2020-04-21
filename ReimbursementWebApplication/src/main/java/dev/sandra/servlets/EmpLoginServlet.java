package dev.sandra.servlets;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.google.gson.Gson;

import dev.sandra.services.EmployeeServiceImpl;
import dev.sandra.services.EmployeeServices;


public class EmpLoginServlet extends HttpServlet {
	EmployeeServices empserv=new EmployeeServiceImpl();
	private static final long serialVersionUID = 1L;
       
    
    public EmpLoginServlet() {
        super();
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String uname=request.getParameter("username");
		String pass=request.getParameter("password");
		
		System.out.println("Username in EmpLoginServlet is "+uname  + pass);

		Gson gson = new Gson();	    
	    String json=gson.toJson(empserv.loginEmployee(uname, pass));
		response.getWriter().append(json);
		
		HttpSession sess= request.getSession();
		sess.setAttribute("username", uname);
		      	
		//response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
