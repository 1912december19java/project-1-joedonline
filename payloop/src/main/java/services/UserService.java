package services;


import java.sql.SQLException;
import java.util.Properties;

import models.User;
import repositories.dao.UserDAOImpl;


public class UserService {

	private UserDAOImpl userDaoImpl;

	public UserService(UserDAOImpl userDao) {
		this.userDaoImpl = userDao;
	}
	
	public Boolean authenticate(String username, String password) throws SQLException {
		return userDaoImpl.authenticate(username, password);
	}
	
	public void invalidate(User user) {
		userDaoImpl.invalidate(user);
	}
	
	public User getUserByUsername(String username) {
		return userDaoImpl.getUserByUsername(username);
	}
	
	public Boolean addNew(Properties props) {
		System.out.println("[EmployeeService] addNew(Properties props): " + props.elements().toString());
		return this.userDaoImpl.update(props);
	}

	public Boolean update(Properties props) {
		System.out.println("[EmployeeService] update(Properties props): " + props.elements().toString());
		return this.userDaoImpl.update(props);
	}

	public Boolean delete(Properties props) {
		System.out.println("[EmployeeService] delete(Properties props): " + props.elements().toString());
		return this.userDaoImpl.delete(props);
	}
	
}
