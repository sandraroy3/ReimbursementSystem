package dev.sandra.services;

import dev.sandra.daos.EmployeeDao;
import dev.sandra.daos.EmployeeDaoImpl;
import dev.sandra.daos.ReimbursementDao;
import dev.sandra.daos.ReimbursementDaoImpl;
import dev.sandra.entities.Employee;
import dev.sandra.entities.Reimbursement;

public class EmployeeServiceImpl implements EmployeeServices{

	EmployeeDao empdao=new EmployeeDaoImpl();
	ReimbursementDao reimbdao=new ReimbursementDaoImpl();
	
	@Override
	public Employee loginEmployee(String username, String password) {
		Employee employee=empdao.readEmployee(username, password);
		return employee;
	}

	@Override
	public Reimbursement submitReimbursement(Reimbursement reimbursement) {
		Reimbursement reimbursement2=reimbdao.createReimbursement(reimbursement);
		return reimbursement2;
	}

	@Override
	public Reimbursement viewAllReimbursements(Reimbursement reimbursement) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Employee logoutEmployee(Employee employee) {
		// TODO Auto-generated method stub
		return null;
	}

}
