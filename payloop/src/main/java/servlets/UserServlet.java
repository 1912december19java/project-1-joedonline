package servlets;

import java.io.IOException;
import java.util.stream.Collectors;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.fasterxml.jackson.databind.ObjectMapper;

import exceptions.InvalidRequestException;
import models.User;

/**
 * Servlet implementation class UserServlet
 */
@WebServlet(name = "UserServlet", urlPatterns = { "/user/*" })
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
		String qs = request.getReader().lines().collect(Collectors.joining(System.lineSeparator()));
		String[] endpoints = request.getRequestURI().split("/");
		
		switch (endpoints[4]) {
		case "login":
			
			// JDBC here...
			
			response.getWriter().write("{ \"path\": \"/logout\", \"isLoggedIn\": true, \"message\": \"User is logged in.\" }");
			System.out.println("[UserServlet] POST qs " + qs);
			break;
		default:
			try {
				throw new InvalidRequestException();
			} catch (InvalidRequestException e) {
				response.getWriter().write("{ \"path\": \"\", \"message\": \"Invalid request.\" }");
			}
		}
	}

}
