package tests;

import static org.junit.Assert.*;

import java.io.IOException;
import java.sql.Connection;
import java.util.ArrayList;
import java.util.Properties;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

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
	Properties props;
//	Employee employee = new Employee("123456789012", "Ronald", "McDonald", "Sacramento", "California", "94203");
//	Employee employee = new Employee("567890123456", "Babs", "Bunny", "Orlando", "Florida", "32789");
	Employee employee = new Employee("789012345678", "Mickey", "Mouse", "Tysons Corner", "Virginia", "22043");
	EmployeeUserInfo employeeUserInfo;
	EmployeeService employeeService = new EmployeeService(new EmployeeDAOImpl());
	User user;
	Reimbursement reimbursement;
	ReimbursementService reimbursementService;

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
	}

	@Before
	public void setUp() throws Exception {
		reimbursementService = new ReimbursementService(new ReimbursementDAOImpl());
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void testEmployeeCanViewOnlyTheirInformationOnEmployeePageAccordingToEmployeeIdURL() {
		employeeUserInfo = employeeService.getEmployeeWithUserInfo(employee.getEmployee_id());
		System.out.println(
				"[TestEmployeeHomepage] testEmployeeCanViewOnlyTheirInformationOnEmployeePageAccordingToEmployeeIdURL() employeeUserInfo "
						+ employeeUserInfo);

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
				employeeUserInfo.getFirstName().equalsIgnoreCase("Mickey")
						& employeeUserInfo.getLastName().equalsIgnoreCase("Mouse")
						& employeeUserInfo.getUsername().equalsIgnoreCase("mickeymouse")
						& employeeUserInfo.getUserrole().equalsIgnoreCase("manager"));
	}

	@Test
	public void testEmployeeCanViewPendingReimbursementRequests() {
		
		ArrayList<Reimbursement> allPendingRequests;
		try {
			allPendingRequests = reimbursementService.getAllPendingRequests(employee.getEmployee_id());
			assertTrue("Error fetching pending requests for employeeId: ", allPendingRequests != null);
		} catch (NullPointerException e) {
			System.out.println("[TestEmployeeHomepage] testEmployeeCanViewPendingReimbursementRequests() ERROR: " + e);
		}
		
	}

	@Test
	public void testEmployeeCanViewResolvedReimbursementRequests() {
		
		ArrayList<Reimbursement> allPendingRequests;
		try {
			allPendingRequests = reimbursementService.getAllPendingRequests(employee.getEmployee_id());
			System.out.println(
					"[TestEmployeeHomepage] testEmployeeCanViewPendingReimbursementRequests() -> allPendingRequests: "
							+ allPendingRequests);
			assertTrue("Error fetching resolved requests for employeeId ", allPendingRequests != null);
		} catch (NullPointerException e) {
			System.out.println("[TestEmployeeHomepage] testEmployeeCanViewPendingReimbursementRequests() ERROR: " + e);
		}
		
	}
	
	@Test
	public void testEmployeeReceivesConfirmationAfterSubmittingAReimbursementRequest() {
		Boolean boolIsSubmitted = false;
		ObjectMapper objMapper = new ObjectMapper();
		props = new Properties();
		props.setProperty("employeeId", "789012345678");
		props.setProperty("todaysDate", "01/20/2020");
		props.setProperty("amount", "232.71");
		props.setProperty("receiptUrl", "https://picsum.photos/id/237/300/200");
		props.setProperty("approvedBy", "mickeymouse");
		String strIsSubmitted = reimbursementService.saveReimbursementRequest(props); // returns a jsonString
//		String strIsSubmitted = "{ \"isSubmitted\": \"true\" }";
		try {
			JsonNode rootNode = objMapper.readTree(strIsSubmitted);
			boolIsSubmitted = rootNode.get("isSubmitted").asText().equalsIgnoreCase("true");
			System.out.println("[TestEmployeeHomepage] boolIsSubmitted " + boolIsSubmitted);
			if (boolIsSubmitted) {
				assertTrue(true);
			} else {
				assertTrue("Reimbursement request failed to confirm", false);
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	@Test
	public void testEmployeeInformationReceivedAreNotEmptyAndNotWhiteSpaces() {
		
		Boolean isCompleteAndNotWhiteSpaces = false; // Unit testing var only
		
		/* Servlet interactions... */
		ObjectMapper objMapper = new ObjectMapper();
		// some servlet implementation here...
		
		/* Process information */
		props = new Properties();
		props.setProperty("employeeId", "567890123456"); // tbl: employees
		props.setProperty("firstName", "Babs"); // tbl: employees
		props.setProperty("lastName", "Bunny"); // tbl: employees
		props.setProperty("city", "Orlando"); // tbl: employees
		props.setProperty("state", "Florida"); // tbl: employees
		props.setProperty("zipcode", "32789"); // tbl: employees
		props.setProperty("username", "babsbunny"); // tbl: ers_users
		props.setProperty("userpass", "herpassword"); // tbl: ers_users
		props.setProperty("userrole", "employee"); // tbl: ers_users
		props.setProperty("email", "babs.bunny@fake.email"); // tbl: ers_users
		
		/* Check information */
		// check for null or empty values
		String employeeId = props.get("employeeId").toString();
		String firstName = props.get("firstName").toString();
		String lastName = props.get("lastName").toString();
		String city = props.get("city").toString();
		String state = props.get("state").toString();
		String zipcode = props.get("zipcode").toString();
		String username = props.get("username").toString();
		String userpass = props.getProperty("userpass").toString();
		String userrole = props.get("userrole").toString();
		String email = props.get("email").toString();
		System.out.println("[TestEmployeeHomepage] testEmployeeInformationReceivedAreCompleteAndAreProperTypes() employeeId: " + employeeId);
		System.out.println("[TestEmployeeHomepage] testEmployeeInformationReceivedAreCompleteAndAreProperTypes() firstName: " + firstName);
		System.out.println("[TestEmployeeHomepage] testEmployeeInformationReceivedAreCompleteAndAreProperTypes() lastName: " + lastName);
		System.out.println("[TestEmployeeHomepage] testEmployeeInformationReceivedAreCompleteAndAreProperTypes() city: " + city);
		System.out.println("[TestEmployeeHomepage] testEmployeeInformationReceivedAreCompleteAndAreProperTypes() state: " + state);
		System.out.println("[TestEmployeeHomepage] testEmployeeInformationReceivedAreCompleteAndAreProperTypes() zipcode: " + zipcode);
		System.out.println("[TestEmployeeHomepage] testEmployeeInformationReceivedAreCompleteAndAreProperTypes() username: " + username);
		System.out.println("[TestEmployeeHomepage] testEmployeeInformationReceivedAreCompleteAndAreProperTypes() userpass: " + userpass);
		System.out.println("[TestEmployeeHomepage] testEmployeeInformationReceivedAreCompleteAndAreProperTypes() userrole: " + userrole);
		System.out.println("[TestEmployeeHomepage] testEmployeeInformationReceivedAreCompleteAndAreProperTypes() email: " + email);
		
		System.out.println("[TestemployeeHomepage] isCompleteAndNotWhiteSpaces: -> before if: " + isCompleteAndNotWhiteSpaces);
		if (!employeeId.trim().isEmpty() & 
			!firstName.trim().isEmpty() & 
			!lastName.trim().isEmpty() & 
			!city.trim().isEmpty() & 
			!state.trim().isEmpty() & 
			!zipcode.trim().isEmpty() & 
			!username.trim().isEmpty() &
			!userpass.trim().isEmpty() &
			!userrole.trim().isEmpty() & 
			!email.trim().isEmpty()) {
			
			isCompleteAndNotWhiteSpaces = employeeService.update(props);
			System.out.println("[TestemployeeHomepage] isCompleteAndNotWhiteSpaces -> at end if: " + isCompleteAndNotWhiteSpaces);
		}
		
		assertTrue("Employee information submitted are not empty or not white spaces only", isCompleteAndNotWhiteSpaces);
		
	}

}
