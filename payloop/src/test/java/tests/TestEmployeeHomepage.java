package tests;

import static org.junit.Assert.*;

import java.sql.Connection;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import models.Employee;
import models.EmployeeUserInfo;
import models.User;
import repositories.dao.EmployeeDAOImpl;
import services.EmployeeService;

public class TestEmployeeHomepage {
	
	Connection connection;
	Employee employee = new Employee("123456789012", "Ronald", "McDonald", "Sacramento", "California", "94203");
	EmployeeUserInfo employeeUserInfo;
	EmployeeService employeeService = new EmployeeService(new EmployeeDAOImpl());
	User user;

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
	}

	@Before
	public void setUp() throws Exception {
		//Get employee here (JDBC)
	}

	@After
	public void tearDown() throws Exception {
	}
	
	@Test
	public void anotherTest() {
//		fail();
	}

	@Test
	public void testEmployeeCanViewOnlyTheirInformationOnEmployeePageAccordingToEmployeeIdURL() {
		employeeUserInfo = employeeService.getEmployeeWithUserInfo("123456789012");
		System.out.println("[TestEmployeeHomepage] testEmployeeCanViewOnlyTheirInformationOnEmployeePageAccordingToEmployeeIdURL() employeeUserInfo " + employeeUserInfo);
		
		assertTrue("Insufficient User information displayed to the front end", 
			employeeUserInfo.getFirstName().equalsIgnoreCase("Ronald") &
			employeeUserInfo.getLastName().equalsIgnoreCase("McDonald") &
			employeeUserInfo.getUsername().equalsIgnoreCase("ronaldmcdonald") &
			employeeUserInfo.getUserrole().equalsIgnoreCase("employee"));
	}

}
