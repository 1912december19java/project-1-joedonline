package servlets;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

import exceptions.InvalidRequestException;
import exceptions.InvalidUsernameOrPasswordException;
import models.User;
import repositories.dao.UserDAOImpl;
import services.UserService;

/**
 * Servlet implementation class UserServlet
 */
@WebServlet(name = "UserServlet", urlPatterns = { "/v2/user/*" })
public class UserServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	private User user = new User();
	private ObjectMapper objMapper;

	@Override
	public void init() throws ServletException {
		this.objMapper = new ObjectMapper();
		super.init();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String[] endpoints = request.getRequestURI().split("/");
		
		switch (endpoints[4]) {
		case "logout":
			user.setPath(endpoints[4]);
			String jsonLogout = "{ \"path\": \"/login\", \"isLoggedIn\": false, \"message\": \"User is logged out.\" }";
			response.getWriter().write(jsonLogout);
			break;
		default:
			try {
				throw new InvalidRequestException();
			} catch (InvalidRequestException e) {
				response.getWriter().write("{ \"path\": \"\", \"message\": \"Invalid request.\" }");
			}
			
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		String bodyString = request.getReader().lines().collect(Collectors.joining(System.lineSeparator()));
		String[] endpoints = request.getRequestURI().split("/");
		
		UserService userService;
		switch (endpoints[4]) {
		case "login":
			
			JsonNode rootNode = objMapper.readTree(bodyString);	
			List<String> creds = new ArrayList<String>(); 
			
			rootNode.forEach((s) -> {
				creds.add(s.asText());
			});
			
			String uname = creds.get(0);
			String upass = creds.get(1);
			
			UserDAOImpl userDao = new UserDAOImpl();
			String homepageURL = "";
			userService = new UserService(userDao);
			Boolean isAuthenticated = false;
			
			try {
				isAuthenticated = userService.authenticate(uname, upass);
				System.out.println("[UserServlet] isAuthenticated " + isAuthenticated);
				
				if (isAuthenticated) {		
					user = userService.getUserByUsername(uname);
					System.out.println("[UserServlet] user.getUserRole() " + user.getUserRole());
					
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
				
			} catch (SQLException | InvalidUsernameOrPasswordException e1) {
				System.out.println("[UserServlet] ERROR: InvalidUsernameOrPasswordException: " + e1);
			}
			
			response.getWriter().write("{ \"path\": \"/logout\", \"homepage\": \"" + homepageURL + "\", \"isLoggedIn\": true, \"message\": \"User is logged in.\" }");
			break;
		default:
			try {
				throw new InvalidRequestException();
			} catch (InvalidRequestException e) {
				response.getWriter().write("{ \"path\": \"\", \"message\": \"Invalid request.\" }");
			}
		}
	} // END doPost()

} // END class
