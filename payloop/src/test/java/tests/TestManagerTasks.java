package tests;

import static org.junit.Assert.*;

import java.util.ArrayList;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import models.Employee;
import repositories.dao.EmployeeDAOImpl;
import services.EmployeeService;
import services.UserService;

public class TestManagerTasks {

	Employee employee;
	ArrayList<Employee> allEmployees;
	EmployeeService employeeService;
	EmployeeDAOImpl employeeDaoImpl;
	UserService userService;
	
	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
	}

	@Before
	public void setUp() throws Exception {
		employeeDaoImpl = new EmployeeDAOImpl();
		employeeService = new EmployeeService(employeeDaoImpl);
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
			assertTrue("Manage is able to retrieve all employee information", false);
		} else {
			assertTrue(true);
		}
	}

}
