package repositories.dao;

import java.sql.SQLException;

public interface UserDAO {

	Boolean authenticate(String username, String password) throws SQLException;
	
}
