package servlets;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.fasterxml.jackson.databind.ObjectMapper;

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
		
		System.out.println("[doGet] request.getRequestURI() " + request.getRequestURI());

		switch (endpoints[3]) {
		case "logout":
			user.setPath(endpoints[3]);
			String jsonLogout = "{ \"path\": \"/logout\", \"isLoggedIn\": false, \"message\": \"User is logged out.\" }";
			response.getWriter().write(jsonLogout);
			break;
		case "login":
			user.setPath(endpoints[3]);
			String jsonLogin = "{ \"path\": \"/login\", \"isLoggedIn\": true, \"message\": \"User is logged in.\" }";
			response.getWriter().write(jsonLogin);
			break;
		default:
			System.out.println("STATUS 404 - Page not found");
			// CUSTOM EXCEPTION OR REDIRECT HERE
		}

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

}
