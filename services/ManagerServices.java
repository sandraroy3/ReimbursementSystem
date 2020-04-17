package dev.sandra.services;

import java.util.List;

import dev.sandra.entities.Manager;
import dev.sandra.entities.Reimbursement;

public interface ManagerServices {

	Manager loginManager(String username, String password);
	

	public List<Reimbursement> viewAllReimbursements();
	public List<Reimbursement> submittedReimbursements();
	
	//public Reimbursement submitReimbursement(Reimbursement reimbursement);

	public Reimbursement approveReimbursement(int id);
	//public Reimbursement approveReimbursement(Reimbursement reimbursement, boolean isApproved);
	
	public Reimbursement denyReimbursement(int id);
	
	
	Manager logoutManager(Manager manager);
}
