package dev.sandra.services;

import java.util.List;

import dev.sandra.entities.Employee;
import dev.sandra.entities.Reimbursement;

public interface EmployeeServices {

	Employee loginEmployee(String username, String password);
	
	Reimbursement submitReimbursement(Reimbursement reimbursement);
	List<Reimbursement> viewAllReimbursementsById(int id);
	
	
	Employee logoutEmployee(Employee employee);
	
	
}
