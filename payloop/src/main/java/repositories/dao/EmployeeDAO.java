package repositories.dao;

import java.util.ArrayList;

import models.Employee;
import models.EmployeeUserInfo;
import models.User;


public interface EmployeeDAO {

	Employee getEmployeeById(String employeeId);
	User getUserInfo(String employeeId);
	EmployeeUserInfo getEmployeeWithUserInfo(String employeeId);
	ArrayList<Employee> getAllEmployees();
	
}
