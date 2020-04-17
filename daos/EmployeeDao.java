package dev.sandra.daos;

import dev.sandra.entities.Employee;

public interface EmployeeDao {

	Employee readEmployee(String username, String password);
	
	//Employee updateEmployee(Employee employee);
	
	//Employee deleteEmployee(Employee employee);
}
