package servlets;

import java.io.IOException;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import models.EmployeeUserInfo;
import repositories.dao.EmployeeDAOImpl;
import services.EmployeeService;

/**
 * Servlet implementation class EmployeeServlet
 */
@WebServlet(name = "EmployeeServlet", urlPatterns = { "/v2/employee/*" })
public class EmployeeServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public EmployeeServlet() {
        super();
    }

	/**
	 * @see Servlet#init(ServletConfig)
	 */
	public void init(ServletConfig config) throws ServletException {
		
	}

	/**
	 * @see Servlet#destroy()
	 */
	public void destroy() {
		
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("[EmployeeServlet] doGet() reached.");
		
		String URI = request.getRequestURI();
		String[] paths = URI.split("/");
		System.out.println("[EmployeeServet] doGet() role: " + paths[3]);
		String userRole = paths[3];
		String employeeId = paths[4];
		System.out.println("[EmployeeServet] doGet() employeeId: " + employeeId);
		
		EmployeeService employeeService = new EmployeeService(new EmployeeDAOImpl());
//		EmployeeUserInfo employeeUserInfo = employeeService.getEmployeeWithUserInfo("789012345678");
		EmployeeUserInfo employeeUserInfo = null;
		try {
			employeeUserInfo = employeeService.getEmployeeWithUserInfo(employeeId);
			System.out.println("[EmployeeServlet] doGet() employeeUserInfo: " + employeeUserInfo);
			
//			String jsonString = "{}";
			
			String jsonString = "{" +
			"\"employee_id\": \"" + employeeUserInfo.getEmployee_id() + "\"," +
			"\"firstName\": \" " + employeeUserInfo.getFirstName() + "\"," +
			"\"lastName\": \"" + employeeUserInfo.getLastName() + "\"," +
			"\"city\": \"" + employeeUserInfo.getCity() + "\"," +
			"\"state\": \"" + employeeUserInfo.getState() + "\"," +
			"\"zipcode\": \"" + employeeUserInfo.getZipcode() + "\"," +
			"\"email\": \"" + employeeUserInfo.getEmail() + "\"," +
			"\"username\": \" " + employeeUserInfo.getUsername() + "\"," +
			"\"userrole\": \"" + employeeUserInfo.getUserrole() + "\"," +
			"\"homepage\": \"" + "/employee/" + employeeUserInfo.getEmployee_id() + "\"" +
			"}";
			
			response.getWriter().write(jsonString);
		} catch (NullPointerException e) {
			response.getWriter().write("{ \"message\": \"" + employeeId + " appears to be invalid.\" }");
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.getWriter().write("{ \"method\": \"doPost()\" }");
	}

}
