package models;

public class Reimbursement {

	String id;
	Double amount;
	String status;
	String dateSubmitted;
	String dateApproved;
	String employeeId;

	public Reimbursement() {

	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public Double getAmount() {
		return amount;
	}

	public void setAmount(Double amount) {
		this.amount = amount;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getDateSubmitted() {
		return dateSubmitted;
	}

	public void setDateSubmitted(String dateSubmitted) {
		this.dateSubmitted = dateSubmitted;
	}

	public String getDateApproved() {
		return dateApproved;
	}

	public void setDateApproved(String dateApproved) {
		this.dateApproved = dateApproved;
	}

	public String getEmployeeId() {
		return employeeId;
	}

	public void setEmployeeId(String employeeId) {
		this.employeeId = employeeId;
	}

	@Override
	public String toString() {
		return "Reimbursement [id=" + id + ", amount=" + amount + ", status=" + status + ", dateSubmitted="
				+ dateSubmitted + ", dateApproved=" + dateApproved + ", employeeId=" + employeeId + "]";
	}

}
