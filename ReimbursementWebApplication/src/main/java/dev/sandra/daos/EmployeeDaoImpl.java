package dev.sandra.daos;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import dev.sandra.entities.Employee;
import dev.sandra.utils.ConnectionUtils;

public class EmployeeDaoImpl implements EmployeeDao{

	public Employee readEmployee(String username, String password) {
		try(Connection conn=ConnectionUtils.createConnection()){
			String sql= "SELECT * FROM Project1Reimbursements.EMPLOYEE WHERE USERNAME=? AND PASSWORD=?";
			PreparedStatement ps=conn.prepareStatement(sql);
			ps.setString(1, username);
			ps.setString(2, password);
			
			ResultSet rs= ps.executeQuery();
			rs.next();
			
			Employee employee=new Employee();
			employee.seteId(rs.getInt("E_ID"));
			employee.setFirstname(rs.getString("F_NAME"));
			employee.setLastname(rs.getString("L_NAME"));
			//employee.setPhno(phno);
			
            return employee;
		}catch (SQLException e) {
			e.printStackTrace();
			return null;
		}
		
	}

//	public Employee updateEmployee(Employee employee) {
//		// TODO Auto-generated method stub
//		return null;
//	}
//
//	public Employee deleteEmployee(Employee employee) {
//		// TODO Auto-generated method stub
//		return null;
//	}
	

}
