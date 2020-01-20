package servlets;

import java.io.IOException;
import java.util.ArrayList;
import java.util.stream.Collectors;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

import models.Reimbursement;
import repositories.dao.ReimbursementDAOImpl;
import services.ReimbursementService;

/**
 * Servlet implementation class ReimbursementServlet
 */
@WebServlet(name = "ReimbursementServlet", urlPatterns = { "/v2/reimbursements/*" })
public class ReimbursementServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	private Reimbursement reimbursement;
	private ObjectMapper objMapper;
	
	@Override
	public void init() throws ServletException {
		this.objMapper = new ObjectMapper();
		super.init();
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		System.out.println("[ReimbursementServlet] doGet() reached");

		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		String bodyString = request.getReader().lines().collect(Collectors.joining(System.lineSeparator()));
		System.out.println("[ReimbursementServlet] bodyString: " + bodyString);
		
		JsonNode rootNode = objMapper.readTree(bodyString);
		
		String employeeId = rootNode.get("employeeId").asText();

		String[] requestURLArr = request.getRequestURI().split("/");
		String path = requestURLArr[4];
		
		ReimbursementService reimbursementService = new ReimbursementService(new ReimbursementDAOImpl());
		ArrayList<Reimbursement> allPendingRequests;
		
		reimbursement = new Reimbursement();

		try {
			allPendingRequests = reimbursementService.getAllPendingRequests(employeeId);
			System.out.println("[ReimbursementServlet] allPendingRequests");			
			response.getWriter().write(objMapper.writeValueAsString(allPendingRequests).toString());
		} catch (NullPointerException e) {
			System.out.println("[TestEmployeeHomepage] testEmployeeCanViewPendingReimbursementRequests() ERROR: " + e);
			response.getWriter().write("{\"message\": \"Something went wrong during fetch.\"}");
		}

	}

}