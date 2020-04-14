package dev.sandra.daos;

import java.util.List;

import dev.sandra.entities.Reimbursement;

public interface ReimbursementDao {

	Reimbursement createReimbursement(Reimbursement reimbursement);
	
	//Reimbursement readReimbursement(Reimbursement reimbursement);
	
	//Reimbursement markRe(Task task);
	
	Reimbursement getReimbursementById(int id);
	List<Reimbursement> retrieveAllReimbursements();
	List<Reimbursement> retrieveSubmittedTasks();
	//List<Reimbursement> retrieveCompletedTasks();
	
	Reimbursement updateReimbursement(Reimbursement reimbursement);
	
	Reimbursement deleteReimbursement(Reimbursement reimbursement);
}
