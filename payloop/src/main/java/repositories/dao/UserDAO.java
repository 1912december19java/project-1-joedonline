package repositories.dao;

import java.sql.SQLException;

import models.User;

public interface UserDAO {

	Boolean authenticate(String username, String password) throws SQLException;
	void invalidate(User user);
	
}
