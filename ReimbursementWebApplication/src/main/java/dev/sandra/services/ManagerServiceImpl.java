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
	public List<Reimbursement> viewAllSubmittedReimbursements(int id) {
		List<Reimbursement> subreimbursements =reimbdao.retrieveSubmittedReimbByMId(id);
		return subreimbursements;
	}

	@Override
	public boolean approveReimbursement(Reimbursement reimbursement) {
		//Reimbursement reimbursement=reimbdao.getReimbursementById(id);
		return reimbdao.approveReimbursement(reimbursement);
		//return reimbursement1;
	}

	@Override
	public boolean denyReimbursement(Reimbursement reimbursement) {
		//Reimbursement reimbursement=reimbdao.getReimbursementById(id);
		return reimbdao.denyReimbursement(reimbursement);
		//return reimbursement2;
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
