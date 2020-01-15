package services;


import repositories.dao.UserDAOImpl;


public class UserService {

	private UserDAOImpl userDaoImpl;

	public UserService(UserDAOImpl userDao) {
		this.userDaoImpl = userDao;
	}
	
	public Boolean authenticate(String username, String password) {
		return userDaoImpl.authenticate(username, password);
	}
	
}
