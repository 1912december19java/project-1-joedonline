package repositories.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Properties;

import models.Employee;
import models.EmployeeUserInfo;
import models.User;
import repositories.queries.Actions;
import repositories.queries.MyStatements;
import repositories.utilities.DataAccessObject;

public class EmployeeDAOImpl extends DataAccessObject implements EmployeeDAO {
	
	PreparedStatement stmt;
	ResultSet rs = null;
	Employee employee;
	User user;

	public EmployeeDAOImpl() {
		
	}

	@Override
	public Boolean addNew(Properties props) {
		// REMEMBER TO RETURN TRUE OR FALSE AFTER IMPLEMENTATION!
		return null;
	}

	@Override
	public Boolean update(Properties props) {
		
		Boolean updateIsSuccessful = false;
		String employeeId = props.getProperty("employeeId");
		employee = this.getEmployeeById(employeeId);
		
		try {			
			String[] updateQueries = Actions.UPDATE_EMPLOYEE_AND_USER_RECORD();
			stmt = MyStatements.sendQuery(updateQueries[0]);
			stmt.setString(1, props.getProperty("firstName"));
			stmt.setString(2, props.getProperty("lastName"));
			stmt.setString(3, props.getProperty("city"));
			stmt.setString(4, props.getProperty("state"));
			stmt.setString(5, props.getProperty("zipcode"));
			stmt.setString(6, employeeId); // set above, logically separate because it goes in the WHERE clause
			Boolean employeeUpdateIsSuccessful = stmt.execute();
			
			stmt = MyStatements.sendQuery(updateQueries[1]);
			stmt.setString(1, props.getProperty("username"));
			stmt.setString(2, props.getProperty("userpass"));
			stmt.setString(3, props.getProperty("userrole"));
			stmt.setString(4, props.getProperty("email"));
			stmt.setString(5, employeeId);
			
			Boolean userUpdateIsSuccessful = stmt.execute();
			if (!employeeUpdateIsSuccessful && !userUpdateIsSuccessful) {
				updateIsSuccessful = true;
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return updateIsSuccessful;
	}

	@Override
	public Boolean delete(Properties props) {
		// REMEMBER TO RETURN TRUE OR FALSE AFTER IMPLEMENTATION!
		return null;
	}

	@Override
	public Employee getEmployeeById(String str) {
		System.out.println("[EmployeeDAOImpl] getEmployeeById() str: " + str);
		Employee emp = new Employee();
		System.out.println("[EmployeeDAOImpl] getEmployeeId() str: " + str);
		try {
			stmt = MyStatements.sendQuery(Actions.GET_EMPLOYEE_BY_ID());
			stmt.setString(1, str);
			if (stmt.execute()) {
				rs = stmt.getResultSet();
			}
			System.out.println("[EmployeeDAOImpl] getEmployeeById(...) emp before while: " + emp);
			while (rs.next()) {
				emp.setEmployee_id(str);
				emp.setFirstName(rs.getString(2));
				emp.setLastName(rs.getString(3));
				emp.setCity(rs.getString(4));
				emp.setState(rs.getString(5));
				emp.setZipcode(rs.getString(6));
				System.out.println("[EmployeeDAOImpl] getEmployeeById(...) emp inside while: " + emp);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		System.out.println("[EmployeeDAOImpl] getEmployeeById(...) emp before return: " + emp);
		return emp;
	}

	@Override
	public User getUserInfo(String employeeId) {
		
		try {
			stmt = MyStatements.sendQuery(Actions.GET_EMAIL_USERNAME_USERROLE());
			stmt.setString(1, employeeId);
			if (stmt.execute()) {
				rs = stmt.getResultSet();
			}
			while (rs.next()) {
				System.out.println("[EmployeeDAOImpl] getUserInfo() rs -> email: " + rs.getString(1));
				System.out.println("[EmployeeDAOImpl] getUserInfo() rs -> userName: " + rs.getString(2));
				System.out.println("[EmployeeDAOImpl] getUserInfo() rs -> userRole: " + rs.getString(3));
				user = new User(
					rs.getString(1), //email
					rs.getString(2), //userName 
					rs.getString(3) //userRole
					);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		System.out.println("[EmployeeDAOImpl] getUserInfo() before return user: " + user);
		return user;
	}

	@Override
	public EmployeeUserInfo getEmployeeWithUserInfo(String employeeId) {
		System.out.println("[EmployeeDAOImpl] getEmployeeWithUserInfo() employeeId param: " + employeeId);
		Employee emp = this.getEmployeeById(employeeId);
		System.out.println("[EmployeeDAOImpl] getEmployeeWithUserInfo() emp var: " + employeeId);
		User user = this.getUserInfo(employeeId);
		System.out.println("[EmployeeDAOImpl] getEmployeeWithUserInfo() user var: " + employeeId);
		EmployeeUserInfo empUserInfo = new EmployeeUserInfo(
			employeeId,
			emp.getFirstName(),
			emp.getLastName(),
			emp.getCity(),
			emp.getState(),
			emp.getZipcode(),
			user.getEmail(),
			user.getUserName(), 
			user.getUserRole()
			);
		System.out.println("[EmployeeDAOImpl] getEmployeeWithUserInfo() empUserInfo param: " + empUserInfo);
		return empUserInfo;
	}

}
