package dev.sandra.Controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.google.gson.Gson;

import dev.sandra.entities.Employee;
import dev.sandra.entities.Reimbursement;
import dev.sandra.services.EmployeeServiceImpl;
import dev.sandra.services.EmployeeServices;

public class ControllerClass {

	EmployeeServices empserv=new EmployeeServiceImpl();
	
	public void EmpLogin(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String uname=request.getParameter("username");
		String pass=request.getParameter("password");
		
		System.out.println("Username in EmpLoginServlet is "+uname  + pass);

		Employee loginemp=empserv.loginEmployee(uname, pass);
		
		/*Gson gson = new Gson();	    
	    String json=gson.toJson(empserv.loginEmployee(uname, pass));
		response.getWriter().append(json);*/
		
		HttpSession sess= request.getSession();
		sess.setAttribute("username", uname);
		
		//request.getRequestDispatcher("EmpHomePage.html").include(request, response);
		      	
		//response.getWriter().append("Served at: ").append(request.getContextPath());
	}
	
	public void EmpHome(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String username=(String) request.getSession().getAttribute("username");
		System.out.println("Username in EmpHomePage Servlet is "+username);
		response.getWriter().append(username);
		//response.getWriter().append(username);
		//response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	public void EmpSubmitReimb(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String amt=request.getParameter("amt");
		int amount=Integer.parseInt(amt);
		String description=request.getParameter("desc");
		
		System.out.println("Amt and desc in EmpSubmitReimb is "+amount  + description);

		Reimbursement reimbursement=new Reimbursement();
		reimbursement.setAmount(amount);
		reimbursement.setDescription(description);
		reimbursement.setStatus("SUBMITTED");
		reimbursement.setRequesterId(2);
		//reimbursement.setRequesterId(requesterId);
		
		Gson gson = new Gson();	    
		//empserv.submitReimbursement(reimbursement);
	    String json=gson.toJson(empserv.submitReimbursement(reimbursement));
		response.getWriter().append(json);
		
		//HttpSession sess= request.getSession();
		//sess.setAttribute("username", uname);
		
	/*	String body=request.getReader().lines().reduce("", (accumulator,actual)->accumulator+actual);
	    Gson gson = new Gson();
	    
	    //turn a json into an object u have to tell it what type of obj to turn it into
	    Task task=gson.fromJson(body, Task.class);
	    tserv.createTask(task);
	    response.getWriter().append("Created Task. Success!");*/
		
		//request.getRequestDispatcher("EmpHomePage.html").include(request, response);
		      	
		//response.getWriter().append("Served at: ").append(request.getContextPath());
	}
	
	public void EmpGetReimb(HttpServletRequest request, HttpServletResponse response) throws IOException {

	    //String body=request.getReader().lines().reduce("", (accumulator,actual)->accumulator+actual);
	    Gson gson = new Gson();
	    
	    String json=gson.toJson(empserv.viewAllReimbursementsById(2));
		response.getWriter().append(json);
		}
}
