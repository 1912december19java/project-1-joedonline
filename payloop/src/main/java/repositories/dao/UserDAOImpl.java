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
	public void addNew(Properties props) {

	}

	@Override
	public void update() {

	}

	@Override
	public void delete() {

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
					System.out.println("[UserDAOImpl] rs.getString(1) " + rs.getString(1));
					System.out.println("[UserDAOImpl] rs.getString(2) " + rs.getString(2));
					System.out.println("[UserDAOImpl] rs.getString(3) " + rs.getString(3));
					System.out.println("[UserDAOImpl] rs.getString(4) " + rs.getString(4));
					System.out.println("[UserDAOImpl] rs.getString(5) " + rs.getString(5));
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
