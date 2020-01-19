package models;

public class Employee {

	private String employee_id;
	private String firstName;
	private String lastName;
	private String city;
	private String state;
	private String zipcode;
	
	public Employee() {
		super();
	}

	public Employee(String employee_id, String firstName, String lastName, String city, String state, String zipcode) {
		super();
		this.employee_id = employee_id;
		this.firstName = firstName;
		this.lastName = lastName;
		this.city = city;
		this.state = state;
		this.zipcode = zipcode;
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

	@Override
	public String toString() {
		return "Employee [employee_id=" + employee_id + ", firstName=" + firstName + ", lastName=" + lastName
				+ ", city=" + city + ", state=" + state + ", zipcode=" + zipcode + "]";
	}

}
