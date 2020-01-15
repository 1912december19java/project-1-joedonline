package models;

public class User {

	private String employeeId;
	private String userName;
	private String userPass;
	private String userRole;
	private String email;
	private Boolean isLoggedIn = false;

	public User() {
	}

	public User(String employeeId, String userName, String userPass, String userRole, String email) {
		this.employeeId = employeeId;
		this.userName = userName;
		this.userPass = userPass;
		this.userRole = userRole;
		this.email = email;
	}

	public String getEmployeeId() {
		return employeeId;
	}

	public void setEmployeeId(String employeeId) {
		this.employeeId = employeeId;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getUserPass() {
		return userPass;
	}

	public void setUserPass(String userPass) {
		this.userPass = userPass;
	}

	public String getUserRole() {
		return userRole;
	}

	public void setUserRole(String userRole) {
		this.userRole = userRole;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public Boolean isLoggedIn() {
		return isLoggedIn;
	}

	public void setIsLoggedIn(Boolean isLoggedIn) {
		this.isLoggedIn = isLoggedIn;
	}

	@Override
	public String toString() {
		return "User [employeeId=" + employeeId + ", userName=" + userName + ", userPass=" + userPass + ", userRole="
				+ userRole + ", email=" + email + ", isLoggedIn=" + isLoggedIn + "]";
	}

}
