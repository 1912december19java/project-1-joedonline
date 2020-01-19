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
	User user;

	public EmployeeDAOImpl() {
		
	}

	@Override
	public void addNew(Properties props) {
		// TODO Auto-generated method stub

	}

	@Override
	public void update() {
		// TODO Auto-generated method stub

	}

	@Override
	public void delete() {
		// TODO Auto-generated method stub

	}

	@SuppressWarnings("null")
	@Override
	public Employee getEmployeeById(String employeeId) {
		System.out.println("[EmployeeDAOImpl] getEmployeeById() employeeId param: " + employeeId);
		Employee emp = new Employee();
		System.out.println("[EmployeeDAOImpl] getEmployeeId() reached " + employeeId);
		try {
			stmt = MyStatements.sendQuery(Actions.GET_EMPLOYEE_BY_ID(employeeId));
			stmt.setString(1, employeeId);
			if (stmt.execute()) {
				rs = stmt.getResultSet();
			}
			System.out.println("[EmployeeDAOImpl] getEmployeeById(...) emp before while: " + emp);
			while (rs.next()) {
				emp.setEmployee_id(employeeId);
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
