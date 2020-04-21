package dev.sandra.daos;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import dev.sandra.entities.Employee;
import dev.sandra.entities.Manager;
import dev.sandra.utils.ConnectionUtils;

public class ManagerDaoImpl implements ManagerDao{

	@Override
	public Manager readManager(String username, String password) {
		try(Connection conn=ConnectionUtils.createConnection()){
			String sql= "SELECT * FROM Project1Reimbursements.MANAGER WHERE USERNAME=? AND PASSWORD=?";
			PreparedStatement ps=conn.prepareStatement(sql);
			ps.setString(1, username);
			ps.setString(2, password);
			
			ResultSet rs= ps.executeQuery();
			rs.next();
			
			Manager manager=new Manager();
			manager.setmId(rs.getInt("M_ID"));
			manager.setFirstname(rs.getString("F_NAME"));
			manager.setLastname(rs.getString("L_NAME"));
			//employee.setPhno(phno);
			
            return manager;
		}catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}

//	@Override
//	public Manager updateManager(Manager manager) {
//		// TODO Auto-generated method stub
//		return null;
//	}
//
//	@Override
//	public Manager deleteManager(Manager manager) {
//		// TODO Auto-generated method stub
//		return null;
//	}

}
