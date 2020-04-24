package dev.sandra.services;

import java.util.List;

import dev.sandra.daos.ManagerDao;
import dev.sandra.daos.ManagerDaoImpl;
import dev.sandra.daos.ReimbursementDao;
import dev.sandra.daos.ReimbursementDaoImpl;
import dev.sandra.entities.Manager;
import dev.sandra.entities.Reimbursement;

public class ManagerServiceImpl implements ManagerServices{

	ManagerDao managdao=new ManagerDaoImpl();
	ReimbursementDao reimbdao=new ReimbursementDaoImpl();
	
	@Override
	public Manager loginManager(String username, String password) {
		Manager manager=managdao.readManager(username, password);
		return manager;
	}

	@Override
	public List<Reimbursement> viewAllReimbursementsbyMId(int id) {
		List<Reimbursement> reimbursements=reimbdao.retrieveAllReimbursementsByMId(id);
		return reimbursements;
	}

	@Override
	public List<Reimbursement> submittedReimbursements(int id) {
		List<Reimbursement> subreimbursements =reimbdao.retrieveSubmittedTasksByMId(id);
		return subreimbursements;
	}

	@Override
	public Reimbursement approveReimbursement(int id) {
		//Reimbursement reimbursement=reimbdao.getReimbursementById(id);
		Reimbursement reimbursement=reimbdao.approveReimbursement(id);
		return reimbursement;
	}

	@Override
	public Reimbursement denyReimbursement(int id) {
		//Reimbursement reimbursement=reimbdao.getReimbursementById(id);
		Reimbursement reimbursement=reimbdao.denyReimbursement(id);
		return reimbursement;
	}

	@Override
	public Manager logoutManager(Manager manager) {
		// TODO Auto-generated method stub
		return null;
	}

	/*@Override
	public Reimbursement submitReimbursement(Reimbursement reimbursement) {
		// TODO Auto-generated method stub
		return null;
	}
	*/

}
