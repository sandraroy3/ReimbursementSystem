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
				String sql="INSERT INTO Project1Reimbursements.REIMBURSEMENT VALUES(?,?,?,?,?,?)";
				PreparedStatement ps=conn.prepareStatement(sql,Statement.RETURN_GENERATED_KEYS);
				
				ps.setInt(1, 0);
				ps.setInt(2, reimbursement.getAmount());
				ps.setString(3, reimbursement.getDescription());
				ps.setString(4, reimbursement.getStatus());
				ps.setInt(5, reimbursement.getRequesterId());
				ps.setInt(6, reimbursement.getmId());
				
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
	public Reimbursement getReimbursementByRId(int id) {
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
			ps.setInt(6, reimbursement.getmId());
			
			
			return reimbursement;
		}catch (SQLException e) {
			e.printStackTrace();
	 }
		return null;
	}

	@Override
	public List<Reimbursement> retrieveAllReimbursementsByEId(int id) {
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
	        	reimbursement.setStatus(rs.getString("STATUS"));
	        	reimbursement.setRequesterId(rs.getInt("E_ID"));
	        	reimbursement.setmId(rs.getInt("M_ID"));
	       
	        
	        	reimbursements.add(reimbursement);
	        }
	        return reimbursements;
		}catch(SQLException e) {
	  	e.printStackTrace();
	   }
	return null;
	}
	
	@Override
	public List<Reimbursement> retrieveAllReimbursementsByMId(int id) {
		try(Connection conn= ConnectionUtils.createConnection()){
			String sql="SELECT * FROM Project1Reimbursements.REIMBURSEMENT WHERE M_ID=? ORDER BY E_ID ";
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
	        	reimbursement.setmId(rs.getInt("M_ID"));
	       
	        
	        	reimbursements.add(reimbursement);
	        }
	        return reimbursements;
		}catch(SQLException e) {
	  	e.printStackTrace();
	   }
	return null;
	}
	
	@Override
	public List<Reimbursement> retrieveSubmittedReimbByMId(int id) {
		try(Connection conn= ConnectionUtils.createConnection()){
			String sql="SELECT * FROM Project1Reimbursements.REIMBURSEMENT WHERE STATUS=? AND M_ID=?";
	        PreparedStatement ps=conn.prepareStatement(sql);
	        ps.setString(1, "SUBMITTED");
	        ps.setInt(2, id);
	        
	        ResultSet rs=ps.executeQuery();
	        
	        List<Reimbursement> reimbursements=new ArrayList<Reimbursement>();
	        
	        while(rs.next()) {
	        
	        	Reimbursement reimbursement=new Reimbursement();
	        	reimbursement.setrId(rs.getInt("R_ID"));
	        	reimbursement.setAmount(rs.getInt("AMOUNT"));
	        	reimbursement.setDescription(rs.getString("DESCRIPTION"));
	        	reimbursement.setRequesterId(rs.getInt("E_ID"));
	        	reimbursement.setStatus(rs.getString("STATUS"));
	        	reimbursement.setmId(rs.getInt("M_ID"));
	       
	        
	        	reimbursements.add(reimbursement);
	        }
	        return reimbursements;
		}catch(SQLException e) {
	  	e.printStackTrace();
	   }
	return null;
	}
	
	@Override
	public List<Reimbursement> retrieveApprovedReimbByMId(int id) {
		try(Connection conn= ConnectionUtils.createConnection()){
			String sql="SELECT * FROM Project1Reimbursements.REIMBURSEMENT WHERE STATUS=? AND M_ID=?";
	        PreparedStatement ps=conn.prepareStatement(sql);
	        ps.setString(1, "APPROVED");
	        ps.setInt(2, id);
	        
	        ResultSet rs=ps.executeQuery();
	        
	        List<Reimbursement> reimbursements=new ArrayList<Reimbursement>();
	        
	        while(rs.next()) {
	        
	        	Reimbursement reimbursement=new Reimbursement();
	        	reimbursement.setrId(rs.getInt("R_ID"));
	        	reimbursement.setAmount(rs.getInt("AMOUNT"));
	        	reimbursement.setDescription(rs.getString("DESCRIPTION"));
	        	reimbursement.setRequesterId(rs.getInt("E_ID"));
	        	reimbursement.setStatus(rs.getString("STATUS"));
	        	reimbursement.setmId(rs.getInt("M_ID"));
	       
	        
	        	reimbursements.add(reimbursement);
	        }
	        return reimbursements;
		}catch(SQLException e) {
	  	e.printStackTrace();
	   }
	return null;
	}
	
	@Override
	public List<Reimbursement> retrieveDeniedReimbByMId(int id) {
		try(Connection conn= ConnectionUtils.createConnection()){
			String sql="SELECT * FROM Project1Reimbursements.REIMBURSEMENT WHERE STATUS=? AND M_ID=?";
	        PreparedStatement ps=conn.prepareStatement(sql);
	        ps.setString(1, "DENIED");
	        ps.setInt(2, id);
	        
	        ResultSet rs=ps.executeQuery();
	        
	        List<Reimbursement> reimbursements=new ArrayList<Reimbursement>();
	        
	        while(rs.next()) {
	        
	        	Reimbursement reimbursement=new Reimbursement();
	        	reimbursement.setrId(rs.getInt("R_ID"));
	        	reimbursement.setAmount(rs.getInt("AMOUNT"));
	        	reimbursement.setDescription(rs.getString("DESCRIPTION"));
	        	reimbursement.setRequesterId(rs.getInt("E_ID"));
	        	reimbursement.setStatus(rs.getString("STATUS"));
	        	reimbursement.setmId(rs.getInt("M_ID"));
	       
	        
	        	reimbursements.add(reimbursement);
	        }
	        return reimbursements;
		}catch(SQLException e) {
	  	e.printStackTrace();
	   }
	return null;
	}
	
	/*@Override
	public List<Reimbursement> retrieveAllReimbursements() {
		try(Connection conn= ConnectionUtils.createConnection()){
			String sql="SELECT * FROM Project1Reimbursements.REIMBURSEMENT ";
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
	}*/


	
	@Override
	public boolean approveReimbursement(Reimbursement reimbursement) {
		try(Connection conn=ConnectionUtils.createConnection()){
			String sql="UPDATE Project1Reimbursements.REIMBURSEMENT SET STATUS='APPROVED' WHERE R_ID=?";
			PreparedStatement ps=conn.prepareStatement(sql);
			
			//ps.setString(1, "APPROVED");
			ps.setInt(1, reimbursement.getrId());
						
			boolean success=ps.execute();
			
			return success;
			
         } catch (SQLException e) {
			e.printStackTrace();
			return false;
		}
		//return null;
	}
	
	@Override
	public boolean denyReimbursement(Reimbursement reimbursement) {
		try(Connection conn=ConnectionUtils.createConnection()){
			String sql="UPDATE Project1Reimbursements.REIMBURSEMENT SET STATUS='DENIED' WHERE R_ID=?";
			PreparedStatement ps=conn.prepareStatement(sql);
			
			//ps.setString(1,"DENIED" );
			ps.setInt(1, reimbursement.getrId());
						
			boolean success=ps.execute();
			
			return success;
			//return reimbursement;
			
         } catch (SQLException e) {
			e.printStackTrace();
			return false;
		}
		//return null;
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
