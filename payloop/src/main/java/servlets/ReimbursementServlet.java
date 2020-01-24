package servlets;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Properties;
import java.util.stream.Collectors;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

import exceptions.InvalidRequestException;
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
		response.getWriter().write("{ \"message\": \"GET request reached; from ReimbursementServlet.\" }");
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
		
		String employeeId = "";

		String[] requestURLArr = request.getRequestURI().split("/");
		String path = requestURLArr[4];
		System.out.println("[ReimbursementServlet] path: " + path);
		
		ReimbursementService reimbursementService = new ReimbursementService(new ReimbursementDAOImpl());
		ArrayList<Reimbursement> allRequests = null;
		
		reimbursement = new Reimbursement();

		try {
			switch (path) {
			case "pending" :
				employeeId = rootNode.get("employeeId").asText();
				allRequests = reimbursementService.getAllPendingRequests(employeeId);
				System.out.println("[ReimbursementServlet] allPendingRequests " + allRequests);
				response.getWriter().write(objMapper.writeValueAsString(allRequests).toString());
				break;
			case "resolved" :
				employeeId = rootNode.get("employeeId").asText();
				allRequests = reimbursementService.getAllResolvedRequests(employeeId);
				System.out.println("[ReimbursementServlet] allResolvedRequests");
				response.getWriter().write(objMapper.writeValueAsString(allRequests).toString());
				break;
			case "requests" :
				System.out.println("[ReimbursementServlet] requests");
				Properties props = new Properties();
				props.setProperty("employeeId", rootNode.get("employeeId").asText());
				props.setProperty("todaysDate", rootNode.get("todaysDate").asText());
				props.setProperty("amount", rootNode.get("amount").asText());
				props.setProperty("receiptUrl", rootNode.get("receiptUrl").asText());
//				props.setProperty("approvedBy", rootNode.get("approvedBy").asText());
				props.setProperty("approvedBy", "all_by_mickeymouse_fornow");
				String isSubmitted = reimbursementService.saveReimbursementRequest(props); // returns a jsonString
				response.getWriter().write(isSubmitted); // :: { isSubmitted: true | false }
				break;
			default:
				response.getWriter().write("{ \"message\": \"Invalid request.\" }");
				throw new InvalidRequestException();
			}
		} catch (NullPointerException e) {
			response.getWriter().write("{\"message\": \"Something went wrong during fetch.\"}");
		} catch (InvalidRequestException e) {
			response.getWriter().write("{\"message\": \"Something went wrong during fetch.\"}");
		}
	}

}
