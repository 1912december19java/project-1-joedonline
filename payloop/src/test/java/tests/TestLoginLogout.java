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
		assertTrue("Wrong password fails to authenticate",
				userService.authenticate("babsbunny", "notherpassword") == false);
	}

	@Test
	public void testRightPasswordSuccessfullyAuthenticates() {
		UserService userService = new UserService(userDao);
		assertTrue("Employee is not able to login", userService.authenticate("babsbunny", "herpassword"));
	}

	@Test
	public void testLoginPathIsSentBackToUserAfterSuccessfulLogIn() {
		
//		String host = "http://localhost:8080";
		String endpoint = "/payloop/user/login";
		String[] path = endpoint.split("/");
		
		switch (path[3]) {
		case "login":
			user.setPath("/" + path[3]);
			break;
		default:
			System.out.println("/login ep: STATUS 404 - Page not found");
			// CUSTOM EXCEPTION OR REDIRECT HERE
		}

		assertTrue("Failed to send /login path after successful login", user.getPath().equalsIgnoreCase("/login"));
	}

	@Test
	public void testLogoutPathIsSentBackToUserAfterSuccessfulLogOut() {

//		String host = "http://localhost:8080";
		String endpoint = "/payloop/user/logout";
		String[] path = endpoint.split("/");
		
		switch (path[3]) {
		case "logout":
			user.setPath("/" + path[3]);
			break;
		default:
			System.out.println("/logout ep: STATUS 404 - Page not found");
			// CUSTOM EXCEPTION OR REDIRECT HERE
		}

		assertTrue("Failed to send logout path after successful logout", user.getPath().equalsIgnoreCase("/logout"));
	}

	@Test
	public void testEmployeeCanLogout() {
		UserService userService = new UserService(userDao);
		userService.invalidate(user);
		assertTrue(user.isLoggedIn() == false);
	}

}
