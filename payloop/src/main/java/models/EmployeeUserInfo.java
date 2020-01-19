package models;

public class EmployeeUserInfo {

	private String employee_id;
	private String firstName;
	private String lastName;
	private String city;
	private String state;
	private String zipcode;
	private String email;
	private String username;
	private String userrole;

	public EmployeeUserInfo() {

	}

	public EmployeeUserInfo(String employee_id, String firstName, String lastName, String city, String state,
			String zipcode, String email, String username, String userrole) {
		super();
		this.employee_id = employee_id;
		this.firstName = firstName;
		this.lastName = lastName;
		this.city = city;
		this.state = state;
		this.zipcode = zipcode;
		this.email = email;
		this.username = username;
		this.userrole = userrole;
	}

	public String getEmployee_id() {
		return employee_id;
	}

	public void setEmployee_id(String employee_id) {
		this.employee_id = employee_id;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public String getZipcode() {
		return zipcode;
	}

	public void setZipcode(String zipcode) {
		this.zipcode = zipcode;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getUserrole() {
		return userrole;
	}

	public void setUserrole(String userrole) {
		this.userrole = userrole;
	}

	public EmployeeUserInfo getMe() {
		return this;
	}

	@Override
	public String toString() {
		return "EmployeeUserInfo [employee_id=" + employee_id + ", firstName=" + firstName + ", lastName=" + lastName
				+ ", city=" + city + ", state=" + state + ", zipcode=" + zipcode + ", email=" + email + ", username="
				+ username + ", userrole=" + userrole + "]";
	}

}
