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

	List<Reimbursement> retrieveSubmittedTasksByMId(int id);
	//List<Reimbursement> retrieveCompletedTasks();
	
	Reimbursement approveReimbursement(int id);
	Reimbursement denyReimbursement(int id);
	
	Reimbursement updateReimbursement(Reimbursement reimbursement);
	
	Reimbursement deleteReimbursement(Reimbursement reimbursement);
}
