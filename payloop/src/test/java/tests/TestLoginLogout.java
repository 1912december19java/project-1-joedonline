package tests;

import static org.junit.Assert.*;

import java.sql.Connection;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import models.User;
import repositories.dao.UserDAOImpl;
import repositories.utilities.ConnectionManager;
import services.UserService;

public class TestLoginLogout {
	
	User user = new User();
	Connection connection;
	UserDAOImpl userDao = new UserDAOImpl();

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
	}

	@Before
	public void setUp() throws Exception {
		connection = ConnectionManager.getConnection();
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void testWrongPasswordFailsToAuthenticate() {
		UserService userService = new UserService(userDao);		
		assertTrue("Wrong password fails to authenticate", userService.authenticate("babsbunny", "notherpassword") == false);
	}
	
	@Test
	public void testRightPasswordSuccessfullyAuthenticates() {
		UserService userService = new UserService(userDao);		
		assertTrue("Employee is not able to login", userService.authenticate("babsbunny", "herpassword"));
	}
	
	@Test
	public void testEmployeeIsRedirectedToEmployeeHomepageAfterSuccessfulLogin() {
		fail("FIRST FAIL / fail first");
	}
	
	@Test
	public void testEmployeeIsRedirectedToLoginPageAfterLogout() {
//		fail("FIRST FAIL / fail first");
	}
	
	@Test
	public void testEmployeeCanLogout() {
		UserService userService = new UserService(userDao);
		userService.invalidate(user);
		assertTrue(user.isLoggedIn() == false);
	}

}