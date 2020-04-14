package dev.sandra.daos;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;

import dev.sandra.entities.Reimbursement;
import dev.sandra.utils.ConnectionUtils;

public class ReimbursementDaoImpl implements ReimbursementDao{

	@Override
	public Reimbursement createReimbursement(Reimbursement reimbursement) {
			try(Connection conn=ConnectionUtils.createConnection()){
				String sql="INSERT INTO Project1Reimbursements.REIMBURSEMENT VALUES(?,?,?,?,?)";
				PreparedStatement ps=conn.prepareStatement(sql,Statement.RETURN_GENERATED_KEYS);
				
				ps.setInt(1, 0);
				ps.setInt(2, reimbursement.getAmount());
				ps.setString(3, reimbursement.getDescription());
				ps.setInt(4, reimbursement.getrId());
				ps.setString(5, reimbursement.getStatus());
				ps.execute();
				
				ResultSet rs=ps.getGeneratedKeys();
				rs.next();
				
				int key= rs.getInt("R_ID");
				
				reimbursement.setrId(key);
				return reimbursement;
				
	         } catch (SQLException e) {
				e.printStackTrace();
			}
			return null;
		}
	

//	@Override
//	public Reimbursement readReimbursement(Reimbursement reimbursement) {
//		// TODO Auto-generated method stub
//		return null;
//	}

	@Override
	public Reimbursement updateReimbursement(Reimbursement reimbursement) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Reimbursement deleteReimbursement(Reimbursement reimbursement) {
		// TODO Auto-generated method stub
		return null;
	}


	@Override
	public Reimbursement getReimbursementById(int id) {
		// TODO Auto-generated method stub
		return null;
	}


	@Override
	public List<Reimbursement> retrieveAllReimbursements() {
		// TODO Auto-generated method stub
		return null;
	}


	@Override
	public List<Reimbursement> retrieveSubmittedTasks() {
		// TODO Auto-generated method stub
		return null;
	}

}
