package dev.sandra.daos;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
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
				ps.setString(4, reimbursement.getStatus());
				ps.setInt(5, reimbursement.getRequesterId());
				
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
	

	@Override
	public Reimbursement getReimbursementById(int id) {
		try(Connection conn=ConnectionUtils.createConnection()){
			String sql="SELECT * FROM Project1Reimbursements.REIMBURSEMENT WHERE R_ID=?";
			PreparedStatement ps=conn.prepareStatement(sql);
			ps.setInt(1, id);
			
			ResultSet rs=ps.executeQuery();
			rs.next();
			
			Reimbursement reimbursement=new Reimbursement();
			ps.setInt(1, 0);
			ps.setInt(2, reimbursement.getAmount());
			ps.setString(3, reimbursement.getDescription());
			ps.setString(4, reimbursement.getStatus());
			ps.setInt(5, reimbursement.getRequesterId());
			
			
			
			return reimbursement;
		}catch (SQLException e) {
			e.printStackTrace();
	 }
		return null;
	}

	@Override
	public List<Reimbursement> retrieveAllReimbursementsById(int id) {
		try(Connection conn= ConnectionUtils.createConnection()){
			String sql="SELECT * FROM Project1Reimbursements.REIMBURSEMENT WHERE E_ID=?";
	        PreparedStatement ps=conn.prepareStatement(sql);
	        ps.setInt(1, id);
	        
	        ResultSet rs=ps.executeQuery();
	        
	        List<Reimbursement> reimbursements=new ArrayList<Reimbursement>();
	        
	        while(rs.next()) {
	        
	        	Reimbursement reimbursement=new Reimbursement();
	        	reimbursement.setrId(rs.getInt("R_ID"));
	        	reimbursement.setAmount(rs.getInt("AMOUNT"));
	        	reimbursement.setDescription(rs.getString("DESCRIPTION"));
	        	reimbursement.setRequesterId(rs.getInt("E_ID"));
	        	reimbursement.setStatus(rs.getString("STATUS"));
	       
	        
	        	reimbursements.add(reimbursement);
	        }
	        return reimbursements;
		}catch(SQLException e) {
	  	e.printStackTrace();
	   }
	return null;
	}
	
	@Override
	public List<Reimbursement> retrieveSubmittedTasks() {
		try(Connection conn= ConnectionUtils.createConnection()){
			String sql="SELECT * FROM Project1Reimbursements.REIMBURSEMENT WHERE STATUS=?";
	        PreparedStatement ps=conn.prepareStatement(sql);
	        ps.setString(1, "SUBMITTED");
	        
	        ResultSet rs=ps.executeQuery();
	        
	        List<Reimbursement> reimbursements=new ArrayList<Reimbursement>();
	        
	        while(rs.next()) {
	        
	        	Reimbursement reimbursement=new Reimbursement();
	        	reimbursement.setrId(rs.getInt("R_ID"));
	        	reimbursement.setAmount(rs.getInt("AMOUNT"));
	        	reimbursement.setDescription(rs.getString("DESCRIPTION"));
	        	reimbursement.setRequesterId(rs.getInt("E_ID"));
	        	reimbursement.setStatus(rs.getString("STATUS"));
	       
	        
	        	reimbursements.add(reimbursement);
	        }
	        return reimbursements;
		}catch(SQLException e) {
	  	e.printStackTrace();
	   }
	return null;
	}
	
	
	@Override
	public List<Reimbursement> retrieveAllReimbursements() {
		try(Connection conn= ConnectionUtils.createConnection()){
			String sql="SELECT * FROM Project1Reimbursements.REIMBURSEMENT";
	        PreparedStatement ps=conn.prepareStatement(sql);
	       
	        ResultSet rs=ps.executeQuery();
	        
	        List<Reimbursement> reimbursements=new ArrayList<Reimbursement>();
	        
	        while(rs.next()) {
	        
	        	Reimbursement reimbursement=new Reimbursement();
	        	reimbursement.setrId(rs.getInt("R_ID"));
	        	reimbursement.setAmount(rs.getInt("AMOUNT"));
	        	reimbursement.setDescription(rs.getString("DESCRIPTION"));
	        	reimbursement.setRequesterId(rs.getInt("E_ID"));
	        	reimbursement.setStatus(rs.getString("STATUS"));
	       
	        
	        	reimbursements.add(reimbursement);
	        }
	        return reimbursements;
		}catch(SQLException e) {
	  	e.printStackTrace();
		}
		return null;
	}


	
	@Override
	public Reimbursement approveReimbursement(int id) {
		try(Connection conn=ConnectionUtils.createConnection()){
			String sql="UPDATE Project1Reimbursements.REIMBURSEMENT SET STATUS=? WHERE R_ID=?";
			PreparedStatement ps=conn.prepareStatement(sql);
			
			ps.setString(1, "APPROVED");
			ps.setInt(2, id);
						
			boolean success=ps.execute();
			
			//return reimbursement;
			
         } catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}
	
	@Override
	public Reimbursement denyReimbursement(int id) {
		try(Connection conn=ConnectionUtils.createConnection()){
			String sql="UPDATE Project1Reimbursements.REIMBURSEMENT SET STATUS=? WHERE R_ID=?";
			PreparedStatement ps=conn.prepareStatement(sql);
			
			ps.setString(1,"DENIED" );
			ps.setInt(2, id);
						
			boolean success=ps.execute();
			
			//return reimbursement;
			
         } catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public Reimbursement deleteReimbursement(Reimbursement reimbursement) {
		// TODO Auto-generated method stub
		return null;
	}


	@Override
	public Reimbursement updateReimbursement(Reimbursement reimbursement) {
		// TODO Auto-generated method stub
		return null;
	}


}
