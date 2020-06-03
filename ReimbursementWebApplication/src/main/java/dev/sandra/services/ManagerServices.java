package dev.sandra.services;

import java.util.List;

import dev.sandra.entities.Manager;
import dev.sandra.entities.Reimbursement;

public interface ManagerServices {

	Manager loginManager(String username, String password);
	

	public List<Reimbursement> viewAllReimbursementsbyMId(int id);
	public List<Reimbursement> viewAllSubmittedReimbursements(int id);
	
	//public Reimbursement submitReimbursement(Reimbursement reimbursement);

	public boolean approveReimbursement(Reimbursement reimbursement);
	//public Reimbursement approveReimbursement(Reimbursement reimbursement, boolean isApproved);
	
	public boolean denyReimbursement(Reimbursement reimbursement);
	
	
	
	Manager logoutManager(Manager manager);
}
