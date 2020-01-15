package repositories.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Properties;

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
	public Boolean authenticate(String username, String password) {
		
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

}
