package dev.sandra.services;

import dev.sandra.entities.Reimbursement;

public interface ReimbursementService {

	public Reimbursement submitReimbursement(Reimbursement reimbursement);

	public Reimbursement approveReimbursement(Reimbursement reimbursement);

	public Reimbursement approveReimbursement(Reimbursement reimbursement, boolean isApproved);

	public Reimbursement denyReimbursement(Reimbursement reimbursement);

}
