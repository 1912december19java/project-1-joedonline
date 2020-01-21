package services;

import java.util.Properties;

import models.Employee;
import models.EmployeeUserInfo;
import models.User;
import repositories.dao.EmployeeDAOImpl;

public class EmployeeService {

	private EmployeeDAOImpl employeeDaoImpl;

	public EmployeeService(EmployeeDAOImpl employeeDao) {
		this.employeeDaoImpl = employeeDao;
	}

	public Boolean addNew(Properties props) {
		System.out.println("[EmployeeService] addNew(Properties props): " + props.elements().toString());
		return this.employeeDaoImpl.update(props);
	}

	public Boolean update(Properties props) {
		System.out.println("[EmployeeService] update(Properties props): " + props.elements().toString());
		return this.employeeDaoImpl.update(props);
	}

	public Boolean delete(Properties props) {
		System.out.println("[EmployeeService] delete(Properties props): " + props.elements().toString());
		return this.employeeDaoImpl.delete(props);
	}

	public Employee getEmployeeByIdxx(String employeeId) {
		System.out.println("[EmployeeService] getEmployeeById(String employeeId): " + employeeId);
		return this.employeeDaoImpl.getEmployeeById(employeeId);
	}

	public User getUserInfo(String employeeId) {
		return this.employeeDaoImpl.getUserInfo(employeeId);
	}

	public EmployeeUserInfo getEmployeeWithUserInfo(String employeeId) {
		System.out.println("[EmployeeService] getEmployeeWithUserInfo() employeId param: " + employeeId);
		return employeeDaoImpl.getEmployeeWithUserInfo(employeeId);
	}

}
