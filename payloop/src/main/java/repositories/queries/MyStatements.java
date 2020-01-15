package repositories.queries;

import java.sql.PreparedStatement;
import java.sql.SQLException;

import repositories.utilities.ConnectionManager;

public final class MyStatements {
	
	public static PreparedStatement sendQuery(String statement) {
		
		PreparedStatement stmt = null;
		
		try {
			stmt = ConnectionManager.getConnection().prepareStatement(statement);			
		} catch (SQLException e) {
			e.printStackTrace();
			// CUSTOM EXCEPTION WILL GO HERE
		}
		
		return stmt;
	}
	
}
