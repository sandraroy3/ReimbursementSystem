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
	public List<Reimbursement> viewAllReimbursements() {
		List<Reimbursement> reimbursements=reimbdao.retrieveAllReimbursements();
		return reimbursements;
	}

	@Override
	public List<Reimbursement> submittedReimbursements() {
		List<Reimbursement> subreimbursements =reimbdao.retrieveSubmittedTasks();
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
