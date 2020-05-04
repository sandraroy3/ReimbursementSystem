package dev.sandra.servicetests;

import static org.junit.Assert.*;

import java.util.List;

import org.junit.Test;

import dev.sandra.entities.Manager;
import dev.sandra.entities.Reimbursement;
import dev.sandra.services.EmployeeServiceImpl;
import dev.sandra.services.EmployeeServices;
import dev.sandra.services.ManagerServiceImpl;
import dev.sandra.services.ManagerServices;

public class ManagerServiceTests {

	ManagerServices managserv=new ManagerServiceImpl();
	
   /* @Test
	public void loginManager() {

    	  Manager manag=managserv.loginManager("Thomas1", "Thomas123");
    	  System.out.println(manag);
   	}*/

	/*@Test
	public void createReimb(){
		Reimbursement reimb=new Reimbursement();
		reimb.setAmount(100);
		reimb.setDescription("Relocation Assistance");
		reimb.setStatus("SUBMITTED");
		reimb.setRequesterId(3);
        empserv.submitReimbursement(reimb);
        System.out.println(reimb);
	}
	
	@Test
	public void getReimbbyId(){
		List<Reimbursement> reimb=empserv.viewAllReimbursementsById(2);
		System.out.println(reimb);
	}*/
	
	
	@Test
	public void getAllReimbByMid(){
		List<Reimbursement> reimb=managserv.viewAllReimbursementsbyMId(1);
		System.out.println("All reimb "+reimb);
	}
	
	 @Test
		public void getAllSubReimb(){
			List<Reimbursement> reimb=managserv.viewAllSubmittedReimbursements(1);
			System.out.println("All sub reimb "+reimb);
		}
	 
	/* @Test
		public void approveReimb(){
			Reimbursement reimb=managserv.approveReimbursement(1));
			System.out.println("Approved reimb "+reimb);
		}*/
	 
	/* @Test
		public void denyReimb(){
			Reimbursement reimb=managserv.denyReimbursement(2);
			System.out.println(reimb);
		}*/

}
