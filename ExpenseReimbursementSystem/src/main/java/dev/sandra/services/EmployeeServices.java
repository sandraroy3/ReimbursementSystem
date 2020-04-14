package dev.sandra.services;

import dev.sandra.entities.Employee;
import dev.sandra.entities.Reimbursement;

public interface EmployeeServices {

	Employee loginEmployee(String username, String password);
	
	Reimbursement submitReimbursement(Reimbursement reimbursement);
	Reimbursement viewAllReimbursements(Reimbursement reimbursement);
	
	Employee logoutEmployee(Employee employee);
	
	
}
