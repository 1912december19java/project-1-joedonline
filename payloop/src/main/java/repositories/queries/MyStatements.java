package repositories.queries;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import repositories.utilities.ConnectionManager;

public final class MyStatements {
	
	/**
	 * This method is used for retrieving a PreparedStatement
	 * 
	 * @param statement
	 * @return statement
	 * @throws SQLException
	 */
	public static PreparedStatement sendQuery(String sqlQuery) throws SQLException {
		
		System.out.println("[MyStatements] sendQuery() -> sqlQuery " + sqlQuery);
		PreparedStatement statement = ConnectionManager.getConnection().prepareStatement(sqlQuery);
		
		try {
			statement = ConnectionManager.getConnection().prepareStatement(sqlQuery);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return statement;
	}
	
	/**
	 * This method is used for retrieving a ResultSet
	 * 
	 * @param statement
	 * @return resultSet
	 * @throws SQLException
	 */
	public static ResultSet executeQuery(String sqlQuery) throws SQLException {
		
		System.out.println("[MyStatements] executeQuery() -> sqlQuery: " + sqlQuery);
		PreparedStatement statement = ConnectionManager.getConnection().prepareStatement(sqlQuery);
		ResultSet resultSet = statement.executeQuery();
		
		return resultSet;
	}
	
}
