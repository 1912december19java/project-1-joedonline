package tests;

import static org.junit.Assert.*;

import java.sql.Connection;
import java.util.ArrayList;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import models.Employee;
import models.EmployeeUserInfo;
import models.Reimbursement;
import models.User;
import repositories.dao.EmployeeDAOImpl;
import repositories.dao.ReimbursementDAOImpl;
import services.EmployeeService;
import services.ReimbursementService;

public class TestEmployeeHomepage {
	
	Connection connection;
//	Employee employee = new Employee("123456789012", "Ronald", "McDonald", "Sacramento", "California", "94203");
//	Employee employee = new Employee("567890123456", "Babs", "Bunny", "Orlando", "Florida", "32789");
	Employee employee = new Employee("789012345678", "Mickey", "Mouse", "Tysons Corner", "Virginia", "22043");
	EmployeeUserInfo employeeUserInfo;
	EmployeeService employeeService = new EmployeeService(new EmployeeDAOImpl());
	User user;
	Reimbursement reimbursement;

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
	public void testEmployeeCanViewOnlyTheirInformationOnEmployeePageAccordingToEmployeeIdURL() {
		employeeUserInfo = employeeService.getEmployeeWithUserInfo(employee.getEmployee_id());
		System.out.println("[TestEmployeeHomepage] testEmployeeCanViewOnlyTheirInformationOnEmployeePageAccordingToEmployeeIdURL() employeeUserInfo " + employeeUserInfo);
		
//		assertTrue("Insufficient User information displayed to the front end", 
//			employeeUserInfo.getFirstName().equalsIgnoreCase("Ronald") &
//			employeeUserInfo.getLastName().equalsIgnoreCase("McDonald") &
//			employeeUserInfo.getUsername().equalsIgnoreCase("ronaldmcdonald") &
//			employeeUserInfo.getUserrole().equalsIgnoreCase("employee"));
		
//		assertTrue("Insufficient User information displayed to the front end", 
//				employeeUserInfo.getFirstName().equalsIgnoreCase("Babs") &
//				employeeUserInfo.getLastName().equalsIgnoreCase("Bunny") &
//				employeeUserInfo.getUsername().equalsIgnoreCase("babsbunny") &
//				employeeUserInfo.getUserrole().equalsIgnoreCase("employee"));
		
		assertTrue("Insufficient User information displayed to the front end", 
				employeeUserInfo.getFirstName().equalsIgnoreCase("Mickey") &
				employeeUserInfo.getLastName().equalsIgnoreCase("Mouse") &
				employeeUserInfo.getUsername().equalsIgnoreCase("mickeymouse") &
				employeeUserInfo.getUserrole().equalsIgnoreCase("manager"));
	}
	
	@Test
	public void testEmployeeCanViewPendingReimbursementRequests() {
		System.out.println("[TestEmployeeHomepage] testEmployeeCanViewPendingReimbursementRequests() employee: " + employee);
		
		ReimbursementService reimbursementService = new ReimbursementService(new ReimbursementDAOImpl());
		ArrayList<Reimbursement> allPendingRequests;
		
		try {
			allPendingRequests = reimbursementService.getAllPendingRequests(employee.getEmployee_id());
			System.out.println("[TestEmployeeHomepage] testEmployeeCanViewPendingReimbursementRequests() -> allPendingRequests: "+ allPendingRequests);
			assertTrue("No pending requests for employeeId: " + employee.getEmployee_id(), allPendingRequests != null);
		} catch (NullPointerException e) {
			System.out.println("[TestEmployeeHomepage] testEmployeeCanViewPendingReimbursementRequests() ERROR: " + e);
		}
		
	}

}
