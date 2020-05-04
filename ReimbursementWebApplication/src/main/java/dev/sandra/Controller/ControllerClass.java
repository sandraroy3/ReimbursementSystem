package dev.sandra.Controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.google.gson.Gson;

import dev.sandra.entities.Employee;
import dev.sandra.entities.Manager;
import dev.sandra.entities.Reimbursement;
import dev.sandra.services.EmployeeServiceImpl;
import dev.sandra.services.EmployeeServices;
import dev.sandra.services.ManagerServiceImpl;
import dev.sandra.services.ManagerServices;

public class ControllerClass {

	EmployeeServices empserv=new EmployeeServiceImpl();
	ManagerServices manserv=new ManagerServiceImpl();
	
	public void EmpLogin(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String uname=request.getParameter("username");
		String pass=request.getParameter("password");
		
		System.out.println("Username in EmpLoginServlet is "+uname  + pass);

		Employee loginemp=empserv.loginEmployee(uname, pass);
		
		System.out.println(loginemp);
		
		if(loginemp==null) {
			//response.sendRedirect("EmployeeLoginPage.html");
			response.getWriter().append("Sorry! Login Failed. Try Again"); 
			System.out.println("Login failed in servlet");
			//request.getRequestDispatcher("EmployeeLoginPage.html").include(request, response);
		}
		
		else {
			System.out.println("Login success in servlet");
			HttpSession sess= request.getSession();
			sess.setAttribute("empusername", uname);
			sess.setAttribute("empid", loginemp.geteId());
			//request.getRequestDispatcher("EmpHomePage.html").forward(request, response);
			//response.sendRedirect("EmpHomePage.html");
			//request.getRequestDispatcher("EmpHomePage.html").include(request, response);

			//response.sendRedirect("/ReimbursementWebApplication/api/EmpHomePageServ");
			//request.getRequestDispatcher("EmpHomePage.html").forward(request, response);
			}
		
		/*Gson gson = new Gson();	    
	    String json=gson.toJson(empserv.loginEmployee(uname, pass));
		response.getWriter().append(json);*/
		
//		HttpSession sess= request.getSession();
//		sess.setAttribute("username", uname);
		
		//request.getRequestDispatcher("EmpHomePage.html").include(request, response);
		      	
		//response.getWriter().append("Served at: ").append(request.getContextPath());
	}
	
	public void EmpHome(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String username=(String) request.getSession().getAttribute("empusername");
        int eid= (int) request.getSession().getAttribute("empid");
		System.out.println("Username in EmpHomePage Servlet is "+username);
	 	System.out.println("Emp id in EmpHomePage Servlet is "+eid);
		response.getWriter().append(username);
		//request.getRequestDispatcher("EmpHomePage.html").forward(request, response);
		//request.getRequestDispatcher("EmpHomePage.html").forward(request, response);
		//response.sendRedirect("EmpHomePage.html");
		
		//response.getWriter().append(username);
		//response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	public void EmpSubmitReimb(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String amt=request.getParameter("amt");
		int amount=Integer.parseInt(amt);
		String description=request.getParameter("desc");
		String mid=request.getParameter("mid");
		int man_id=Integer.parseInt(mid);
		
		System.out.println("Amt and desc in EmpSubmitReimb is "+amount  + description);

		int eid= (int) request.getSession().getAttribute("empid");
		
		Reimbursement reimbursement=new Reimbursement();
		reimbursement.setAmount(amount);
		reimbursement.setDescription(description);
		reimbursement.setStatus("SUBMITTED");
		reimbursement.setRequesterId(eid);
		reimbursement.setmId(man_id);
		//reimbursement.setRequesterId(requesterId);
		
		Gson gson = new Gson();	    
		//empserv.submitReimbursement(reimbursement);
	    String json=gson.toJson(empserv.submitReimbursement(reimbursement));
		response.getWriter().append(json);
		
	}
	
	public void EmpGetReimb(HttpServletRequest request, HttpServletResponse response) throws IOException {

	    //String body=request.getReader().lines().reduce("", (accumulator,actual)->accumulator+actual);
	    Gson gson = new Gson();
	    
		int eid= (int) request.getSession().getAttribute("empid");

	    String json=gson.toJson(empserv.viewAllReimbursementsById(eid));
		response.getWriter().append(json);
		}
	
	
	public void ManLogin(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String uname=request.getParameter("username");
		String pass=request.getParameter("password");
		
		System.out.println("Username in ManLoginServlet is "+uname  + pass);

		Manager loginman=manserv.loginManager(uname, pass);
		
		System.out.println(loginman);
		
		if(loginman==null) {
			response.getWriter().append("Sorry! Login Failed. Try Again"); 
			//request.getRequestDispatcher("EmployeeLogin.html").include(request, response);
		}
		
		else {
			HttpSession sess= request.getSession();
			sess.setAttribute("manusername", uname);
			sess.setAttribute("manid", loginman.getmId());
			//response.sendRedirect("/ReimbursementWebApplication/api/EmpHomePageServ");
			//request.getRequestDispatcher("EmpHomePage.html").forward(request, response);
			
		}
		
		/*Gson gson = new Gson();	    
	    String json=gson.toJson(empserv.loginEmployee(uname, pass));
		response.getWriter().append(json);*/
		
//		HttpSession sess= request.getSession();
//		sess.setAttribute("username", uname);
		
		//request.getRequestDispatcher("EmpHomePage.html").include(request, response);
		      	
		//response.getWriter().append("Served at: ").append(request.getContextPath());
	}
	
	public void ManHome(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String username=(String) request.getSession().getAttribute("manusername");
        int mid= (int) request.getSession().getAttribute("manid");
		System.out.println("Username in ManHomePage Servlet is "+username);
	 	System.out.println("Emp id in ManHomePage Servlet is "+mid);
		response.getWriter().append(username);
		//response.getWriter().append(username);
		//response.getWriter().append("Served at: ").append(request.getContextPath());
	}
	
	public void ManGetReimb(HttpServletRequest request, HttpServletResponse response) throws IOException {

	    //String body=request.getReader().lines().reduce("", (accumulator,actual)->accumulator+actual);
	    Gson gson = new Gson();
	    
		int mid= (int) request.getSession().getAttribute("manid");

	    String json=gson.toJson(manserv.viewAllReimbursementsbyMId(mid));
		response.getWriter().append(json);
		}
	
	public void ManGetSubReimb(HttpServletRequest request, HttpServletResponse response) throws IOException {

	    //String body=request.getReader().lines().reduce("", (accumulator,actual)->accumulator+actual);
	    Gson gson = new Gson();
	    
		int mid= (int) request.getSession().getAttribute("manid");

	    String json=gson.toJson(manserv.viewAllSubmittedReimbursements(mid));
		response.getWriter().append(json);
		}
	
	public void ManApproveReimb(HttpServletRequest request, HttpServletResponse response) throws IOException {

		/*String reimbid=request.getParameter("reimbid");
		int rid=Integer.parseInt(reimbid);
		System.out.println("Reimb id to be approved "+rid);
	    //String body=request.getReader().lines().reduce("", (accumulator,actual)->accumulator+actual);
	    Gson gson = new Gson();
	    
		int mid= (int) request.getSession().getAttribute("manid");
		

	    String json=gson.toJson(manserv.approveReimbursement(rid));
		response.getWriter().append(json);*/
		
		Gson gson=new Gson();
		String json=request.getReader().lines().reduce("", (accumulator,actual)->accumulator+actual);
		Reimbursement reimb=gson.fromJson(json, Reimbursement.class);
		manserv.approveReimbursement(reimb);
		System.out.println("Approved Reimb"+ reimb.getrId());
	    //tserv.markTaskComplete(task);
	    response.getWriter().append("Successfully Approved Reimb.");
		}
	public void ManDenyReimb(HttpServletRequest request, HttpServletResponse response) throws IOException {

		
		Gson gson=new Gson();
		String json=request.getReader().lines().reduce("", (accumulator,actual)->accumulator+actual);
		Reimbursement reimb=gson.fromJson(json, Reimbursement.class);
		manserv.denyReimbursement(reimb);
		System.out.println("Denied Reimb"+ reimb.getrId());
	    //tserv.markTaskComplete(task);
	    response.getWriter().append("Successfully Denied Reimb.");
	    
	    /*String reimbid=request.getParameter("reimbid");
		int rid=Integer.parseInt(reimbid);
	    //String body=request.getReader().lines().reduce("", (accumulator,actual)->accumulator+actual);
	    Gson gson = new Gson();
	    
		int mid= (int) request.getSession().getAttribute("manid");
		

	    String json=gson.toJson(manserv.denyReimbursement(rid));
		response.getWriter().append(json);*/
		}
}
