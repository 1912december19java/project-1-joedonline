package repositories.queries;

import java.sql.PreparedStatement;
import java.sql.SQLException;

import repositories.utilities.ConnectionManager;

public final class MyStatements {
	
	public static PreparedStatement sendQuery(String statement) throws SQLException {
		
		System.out.println("[MyStatements] statement " + statement);
		PreparedStatement stmt = ConnectionManager.getConnection().prepareStatement(statement);
		
		try {
			stmt = ConnectionManager.getConnection().prepareStatement(statement);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return stmt;
	}
	
}
