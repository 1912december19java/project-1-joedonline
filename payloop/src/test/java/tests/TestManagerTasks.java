package tests;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.Properties;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import models.Employee;
import models.EmployeeUserInfo;
import models.Reimbursement;
import repositories.dao.EmployeeDAOImpl;
import repositories.dao.ReimbursementDAOImpl;
import repositories.dao.UserDAOImpl;
import services.EmployeeService;
import services.ReimbursementService;
import services.UserService;

public class TestManagerTasks {

	Employee employee;
	EmployeeUserInfo employeeUserInfo;
	ArrayList<Employee> allEmployees;
	EmployeeService employeeService;
	UserService userService;
	ReimbursementService reimbursementService;
	ArrayList<Reimbursement> pendingReimbursementRequests;
	
	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
	}

	@Before
	public void setUp() throws Exception {
		employeeUserInfo = new EmployeeUserInfo();
		employeeService = new EmployeeService(new EmployeeDAOImpl());
		userService = new UserService(new UserDAOImpl());
		reimbursementService = new ReimbursementService(new ReimbursementDAOImpl());
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void testManagerIsAbleToRetrieveAllEmployeeInformation() {
		// "Servlet" receives get all employee information request...
		// some other implementation...
		// process getAllRequest()...
		allEmployees = employeeService.getAllEmployees();
		System.out.println("[TestManagerTask] allEmployees " + allEmployees);
		if (allEmployees == null) {
			assertTrue("Manager is able to retrieve all employee information", false);
		} else {
			assertTrue(true);
		}
	}
	
	@Test
	public void testManagerIsAbleToRetrieveAllPendingRequestsWithEmployeeNames() {
		
		// "Servlet" receives get all employee information request...
		// some other implementation...
		// process getAllRequest()...
		ArrayList<Properties> allPropsPendingRequestsWithEmployeeNames = new ArrayList<Properties>();
		allEmployees = employeeService.getAllEmployees();
		allEmployees.forEach((employee) -> {
			Properties propsAllPendingRequestsWithEmployeeName = new Properties();
			ArrayList<Reimbursement> allPendingRequests = reimbursementService.getAllPendingRequests(employee.getEmployee_id());
			propsAllPendingRequestsWithEmployeeName.setProperty("employeeId", employee.getEmployee_id());
			propsAllPendingRequestsWithEmployeeName.setProperty("firstName", employee.getFirstName());
			propsAllPendingRequestsWithEmployeeName.setProperty("lastName", employee.getLastName());
			propsAllPendingRequestsWithEmployeeName.setProperty("allPendingRequests", allPendingRequests.toString()); // would later require ObjectMapper.readTree(someString);
			allPropsPendingRequestsWithEmployeeNames.add(propsAllPendingRequestsWithEmployeeName);
			System.out.println("[TestManagerTask] propsAllPendingRequestsWithEmployeeName " + propsAllPendingRequestsWithEmployeeName);
		});
		
		System.out.println("[TestManagerTask] allPropsPendingRequestsWithEmployeeNames: " + allPropsPendingRequestsWithEmployeeNames);
		
		assertTrue("Manager is able to retrieve all employee information", allPropsPendingRequestsWithEmployeeNames.isEmpty() == false);
		
	}
	
	@Test
	public void testManagerCanViewReimbursementRequestsFromASingleEmployee() {
		fail("FIRST FAIL / fail first");
	}

}
