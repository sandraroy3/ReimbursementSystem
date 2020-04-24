package dev.sandra.entities;

public class Reimbursement {

	private int rId;
	
	private int amount;
	private String description;
	private String status;
	
	
	private int requesterId;
	private int mId;
	
	
	public Reimbursement() {
		super();
	}
	
	
	
	public Reimbursement(int rId, int amount, String description, String status,int requesterId,int mId) {
		super();
		this.rId = rId;
		this.amount = amount;
		this.description = description;
		this.status = status;
		this.requesterId = requesterId;
		this.mId=mId;
	}



	public int getrId() {
		return rId;
	}
	public void setrId(int rId) {
		this.rId = rId;
	}
	public int getAmount() {
		return amount;
	}
	public void setAmount(int amount) {
		this.amount = amount;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public int getRequesterId() {
		return requesterId;
	}
	public void setRequesterId(int requesterId) {
		this.requesterId = requesterId;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}

	



	@Override
	public String toString() {
		return "Reimbursement [rId=" + rId + ", amount=" + amount + ", description=" + description + ", status="
				+ status + ", requesterId=" + requesterId + ", mId=" + mId + "]";
	}



	public int getmId() {
		return mId;
	}



	public void setmId(int mId) {
		this.mId = mId;
	}
	
	
}
