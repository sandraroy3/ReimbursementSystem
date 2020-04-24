package dev.sandra.servlets;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dev.sandra.Controller.ControllerClass;


public class DispatcherServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    ControllerClass controller=new ControllerClass();
    
    public DispatcherServlet() {
        super();
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String uri=request.getRequestURI();
		switch(uri) {
		
		//API - Appln Program Interface does not usually return HTMLpages/css/js
		//They r endpoints that u can send and get info from (usually in json)
		case "/ReimbursementWebApplication/api/EmploginServlet": controller.EmpLogin(request, response);
		                               break;
		case "/ReimbursementWebApplication/api/EmpHomePageServ": controller.EmpHome(request, response);
        							   break;
		case "/ReimbursementWebApplication/api/EmpSubmitReimbServ": controller.EmpSubmitReimb(request, response);
		                               break;
		case "/ReimbursementWebApplication/api/EmpGetReimbServ": controller.EmpGetReimb(request, response);
        break;
        
        
		case "/ReimbursementWebApplication/api/ManloginServlet": controller.ManLogin(request, response);
						break;
		case "/ReimbursementWebApplication/api/ManHomePageServ": controller.ManHome(request, response);
		   break;
		case "/ReimbursementWebApplication/api/ManGetReimbServ": controller.ManGetReimb(request, response);
			break;
		/*case "/ReimbursementWebApplication/api/EmpGetReimbServ": controller.EmpGetReimb(request, response);
			break;*/
		                               
		/*case "/ReimbursementWebApplication/api/addtask": tcontroller.addTask(request, response);
                                       break;
		case "/ReimbursementWebApplication/api/pendingtasks": tcontroller.getPendingTasks(request, response);
											break; 
		case "/ReimbursementWebApplication/api/updatetask": tcontroller.updateTask(request, response);
												break; 
		case "/ReimbursementWebApplication/api/completedtasks": tcontroller.getCompletedTasks(request, response);
        break; */
		}
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
