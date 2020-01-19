package services;

import java.util.Properties;

import models.Employee;
import models.EmployeeUserInfo;
import models.User;
import repositories.dao.EmployeeDAOImpl;

public class EmployeeService {

	private EmployeeDAOImpl employeeDaoImpl;

	public EmployeeService(EmployeeDAOImpl userDao) {
		this.employeeDaoImpl = userDao;
	}

	public void addNew(Properties props) {

	}

	public void update() {

	}

	public void delete() {

	}

	public Employee getEmployeeById(String employeeId) {
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
