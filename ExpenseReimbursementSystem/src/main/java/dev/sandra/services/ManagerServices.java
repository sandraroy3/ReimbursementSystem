package dev.sandra.services;

import dev.sandra.entities.Manager;
import dev.sandra.entities.Reimbursement;

public interface ManagerServices {

	Manager loginManager(Manager manager);
	

	Reimbursement viewAllReimbursements(Reimbursement reimbursement);
	
	public Reimbursement submitReimbursement(Reimbursement reimbursement);

	public Reimbursement approveReimbursement(Reimbursement reimbursement);
	//public Reimbursement approveReimbursement(Reimbursement reimbursement, boolean isApproved);
	
	public Reimbursement denyReimbursement(Reimbursement reimbursement);
	
	
	Manager logoutManager(Manager manager);
}
