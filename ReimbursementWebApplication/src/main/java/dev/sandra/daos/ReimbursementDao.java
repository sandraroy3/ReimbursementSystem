package dev.sandra.daos;

import java.util.List;

import dev.sandra.entities.Reimbursement;

public interface ReimbursementDao {

	Reimbursement createReimbursement(Reimbursement reimbursement);
	
	//Reimbursement readReimbursement(Reimbursement reimbursement);
	
	//Reimbursement markRe(Task task);
	
	Reimbursement getReimbursementByRId(int id);
	List<Reimbursement> retrieveAllReimbursementsByEId(int id);
	//List<Reimbursement> retrieveAllReimbursements();
	
	
	List<Reimbursement> retrieveAllReimbursementsByMId(int id);
	List<Reimbursement> retrieveSubmittedReimbByMId(int id);
	List<Reimbursement> retrieveApprovedReimbByMId(int id);
	List<Reimbursement> retrieveDeniedReimbByMId(int id);
	//List<Reimbursement> retrieveCompletedTasks();
	
	Reimbursement approveReimbursement(Reimbursement reimbursement);
	Reimbursement denyReimbursement(Reimbursement reimbursement);
	
	Reimbursement updateReimbursement(Reimbursement reimbursement);
	
	Reimbursement deleteReimbursement(Reimbursement reimbursement);
}
