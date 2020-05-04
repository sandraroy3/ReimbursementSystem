package dev.sandra.utils;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

public class ConnectionUtils {

	public static void main(String[] args) {
		createConnection();
	}
	
	public static Connection createConnection() {
		
		try {
			Properties props = new Properties();
			
			Class.forName("org.mariadb.jdbc.Driver");
			
			FileInputStream in= 
					new FileInputStream(ConnectionUtils.class.getClassLoader().getResource("Connection.properties").getFile());
			
			//FileInputStream in= new FileInputStream("src/main/resources/Connection.properties");
			
			props.load(in);

			String details=props.getProperty("condetails");
			
			Connection conn= DriverManager.getConnection(details);
			return conn;
		}catch (SQLException e) {
			e.printStackTrace();
			return null;
		}catch (FileNotFoundException e) {
			e.printStackTrace();
			return null;
	    }catch (IOException e) {
		e.printStackTrace();
		return null;
	    } catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
}
