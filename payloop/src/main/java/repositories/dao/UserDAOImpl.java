package repositories.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Properties;

import models.User;
import repositories.queries.Actions;
import repositories.queries.MyStatements;
import repositories.utilities.ConnectionManager;
import repositories.utilities.DataAccessObject;

public class UserDAOImpl extends DataAccessObject implements UserDAO {

	@Override
	public Boolean addNew(Properties props) {
		// REMEMBER TO RETURN TRUE OR FALSE AFTER IMPLEMENTATION!
		return null;
	}

	@Override
	public Boolean update(Properties props) {
		// REMEMBER TO RETURN TRUE OR FALSE AFTER IMPLEMENTATION!
		return null;
	}

	@Override
	public Boolean delete(Properties props) {
		// REMEMBER TO RETURN TRUE OR FALSE AFTER IMPLEMENTATION!
		return null;
	}

	@Override
	public Boolean authenticate(String username, String password) throws SQLException {
		
		String pw = "";
		PreparedStatement stmt = MyStatements.sendQuery(Actions.GET_USER_PASS());
		ResultSet rs = null;
		
		try {
			
			stmt.setString(1, username);
			if (stmt.execute()) {
				rs = stmt.getResultSet();
			}
			
			while (rs.next()) {
				pw = rs.getString(1);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return pw.equalsIgnoreCase(password);
	}

	@Override
	public void invalidate(User user) {
		user.setIsLoggedIn(false);
	}

	@Override
	public User getUserByUsername(String username) {
		User user = new User();
		try {
			PreparedStatement stmt = MyStatements.sendQuery(Actions.GET_USER_BY_USERNAME());
			ResultSet rs = null;
			
			stmt.setString(1, username);
			if (stmt.execute()) {
				rs = stmt.getResultSet();
				while (rs.next()) {
					user.setUserName(rs.getString(1));
					user.setUserPass(rs.getString(2));
					user.setUserRole(rs.getString(3));
					user.setEmail(rs.getString(4));
					user.setEmployeeId(rs.getString(5));
				}
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return user;
	}

}
