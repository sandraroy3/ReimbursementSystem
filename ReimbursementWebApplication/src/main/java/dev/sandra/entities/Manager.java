package dev.sandra.entities;

public class Manager {

	private int mId;
	
	private String firstname;
	private String lastname;
	private int phno;
	private String address;
	
	private String username;
	private String password;
	
	
	public Manager() {
		super();
	}

	public Manager(int mId, String firstname, String lastname, int phno, String address, String username,
			String password) {
		super();
		this.mId = mId;
		this.firstname = firstname;
		this.lastname = lastname;
		this.phno = phno;
		this.address = address;
		this.username = username;
		this.password = password;
	}



	public int getmId() {
		return mId;
	}
	public void setmId(int mId) {
		this.mId = mId;
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
		return "Manager [mId=" + mId + ", firstname=" + firstname + ", lastname=" + lastname + ", phno=" + phno
				+ ", address=" + address + ", username=" + username + ", password=" + password + "]";
	}

	public String getFirstname() {
		return firstname;
	}

	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}

	public int getPhno() {
		return phno;
	}

	public void setPhno(int phno) {
		this.phno = phno;
	}

	public String getLastname() {
		return lastname;
	}

	public void setLastname(String lastname) {
		this.lastname = lastname;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}
	
	
}
