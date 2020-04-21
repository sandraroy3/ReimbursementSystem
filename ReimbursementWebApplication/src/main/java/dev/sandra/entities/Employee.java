package dev.sandra.entities;

public class Employee {

	private int eId;
	
	private String firstname;
	private String lastname;
	private int phno;
	private String address;
	
	private String username;
	private String password;
	
	public Employee() {
		super();
	}

	

	public Employee(int eId, String firstname, String lastname, int phno, String address, String username,
			String password) {
		super();
		this.eId = eId;
		this.firstname = firstname;
		this.lastname = lastname;
		this.phno = phno;
		this.address = address;
		this.username = username;
		this.password = password;
	}


	public int geteId() {
		return eId;
	}

	public void seteId(int eId) {
		this.eId = eId;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	
	@Override
	public String toString() {
		return "Employee [eId=" + eId + ", firstname=" + firstname + ", lastname=" + lastname + ", phno=" + phno
				+ ", address=" + address + ", username=" + username + ", password=" + password + "]";
	}



	public String getFirstname() {
		return firstname;
	}

	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}

	public String getLastname() {
		return lastname;
	}

	public void setLastname(String lastname) {
		this.lastname = lastname;
	}



	public int getPhno() {
		return phno;
	}



	public void setPhno(int phno) {
		this.phno = phno;
	}



	public String getAddress() {
		return address;
	}



	public void setAddress(String address) {
		this.address = address;
	}
	
	
	
	
	
}
