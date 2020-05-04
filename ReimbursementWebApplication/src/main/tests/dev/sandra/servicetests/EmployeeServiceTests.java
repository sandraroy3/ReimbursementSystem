package dev.sandra.servicetests;

import static org.junit.Assert.*;

import java.util.List;

import org.junit.Test;

import dev.sandra.daos.EmployeeDao;
import dev.sandra.entities.Employee;
import dev.sandra.entities.Reimbursement;
import dev.sandra.services.EmployeeServiceImpl;
import dev.sandra.services.EmployeeServices;

public class EmployeeServiceTests {

	EmployeeServices empserv=new EmployeeServiceImpl();
	
	/*@Test
	public void loginEmployee() {

          Employee emp=empserv.loginEmployee("Rony1", "Rony123");
          System.out.println(emp);
	}*/

	@Test
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
	}
	
	/*
	 *@Test
	public void getAllReimb(){
		List<Reimbursement> reimb=empserv.
		System.out.println(reimb);
	}*/
}
