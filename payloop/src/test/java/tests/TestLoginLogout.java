package tests;

import static org.junit.Assert.*;

import java.sql.Connection;
import java.sql.SQLException;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import exceptions.InvalidUsernameOrPasswordException;
import models.User;
import repositories.dao.UserDAOImpl;
import repositories.utilities.ConnectionManager;
import services.UserService;
import servlets.UserServlet;

public class TestLoginLogout {

	User user;
	Connection connection;
	UserDAOImpl userDao;
	UserService userService;
	UserServlet userServlet;
	String endpoint;
	String path[];
	String homepageURL;

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
	}

	@Before
	public void setUp() throws Exception {
		user = new User("567890123456", "babsbunny", "herpassword", "employee", "babs.bunny@fake.email");
		connection = ConnectionManager.getConnection();
		userDao = new UserDAOImpl();
		userServlet = new UserServlet();
	}

	@After
	public void tearDown() throws Exception {
//		userService.invalidate(user);
	}

	@Test
	public void testWrongPasswordFailsToAuthenticate() throws SQLException {
		userService = new UserService(userDao);
		assertTrue("Wrong password fails to authenticate",
				userService.authenticate("babsbunny", "notherpassword") == false);
	}

	@Test
	public void testRightPasswordSuccessfullyAuthenticates() throws SQLException {
		userService = new UserService(userDao);
		assertTrue("Employee is not able to login", userService.authenticate("babsbunny", "herpassword"));
	}

	@Test
	public void testLoginPathIsSentBackToUserAfterSuccessfulLogIn() throws InvalidUsernameOrPasswordException, SQLException {
		
		userService = new UserService(userDao);
		Boolean isAuthenticated = userService.authenticate("babsbunny", "herpassword");
		
		if (isAuthenticated) {
			endpoint = "/payloop/v2/user/login";
			path = endpoint.split("/");
			
			switch (path[4]) {
			case "login":
				user.setPath("/" + path[4]);
				break;
			default:
				System.out.println("/login ep: STATUS 404 - Page not found");
				// CUSTOM EXCEPTION OR REDIRECT HERE
			}
		} else {
			throw new InvalidUsernameOrPasswordException();
		}

		assertTrue("Failed to send /login path after successful login", user.getPath().equalsIgnoreCase("/login"));
	}

	@Test
	public void testLogoutPathIsSentBackToUserAfterSuccessfulLogOut() {
		
		endpoint = "/payloop/v2/user/logout";
		path = endpoint.split("/");
		
		switch (path[4]) {
		case "logout":
			user.setPath("/" + path[4]);
			break;
		default:
			System.out.println("/logout ep: STATUS 404 - Page not found");
			// CUSTOM EXCEPTION OR REDIRECT HERE
		}

		assertTrue("Failed to send logout path after successful logout", user.getPath().equalsIgnoreCase("/logout"));
	}

	@Test
	public void testEmployeeCanLogout() {
		userService = new UserService(userDao);
		userService.invalidate(user);
		assertTrue(user.isLoggedIn() == false);
	}
	
	@Test
	public void testTheRightHomepageURLIsSentBackToClientAfterEmployeeLogsIn() throws InvalidUsernameOrPasswordException, SQLException {	
		userService = new UserService(userDao);
		Boolean isAuthenticated = userService.authenticate(user.getUserName(), user.getUserPass());
		
		if (isAuthenticated) {			
			switch (user.getUserRole()) {
			case "employee":
				homepageURL = "/user/employee";
				break;
			case "manager":
				homepageURL = "/user/manager";
				break;
			default:
				homepageURL = "/user/invalid";
			}
		} else {
			throw new InvalidUsernameOrPasswordException();
		}
		
		Boolean isValidHomepageURL = homepageURL.equalsIgnoreCase("/user/employee") || homepageURL.equalsIgnoreCase("/user/manager");
		assertTrue("homepageURL for '" + user.getUserRole() + "' role doesn't exist", isValidHomepageURL);
	}

}
