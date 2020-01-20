package repositories.utilities;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionManager {

	private static Connection connection;

	static {

		String dbname = System.getenv("payloop-dbName");
		String endpoint = "jdbc:postgresql://" + System.getenv("payloop-dbEndpoint") + ":5432" + "/" + dbname;
		String password = System.getenv("payloop-dbPassword");
		String username = System.getenv("payloop-dbUsername");
		
//		String dbname = System.getenv("local-payloop-dbName");
//		String endpoint = "jdbc:postgresql://" + System.getenv("local-payloop-dbEndpoint") + ":5432" + "/" + dbname;
//		String password = System.getenv("local-payloop-dbPassword");
//		String username = System.getenv("local-payloop-dbUsername");

		try {
			Class.forName("org.postgresql.Driver");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}

		try {
			connection = DriverManager.getConnection(endpoint, username, password);
		} catch (SQLException e) {
			System.out.println("[ConnectionManager] static {...} ERROR: " + e);
		}

	}

	public static Connection getConnection() {
		System.out.println("[ConnectionManager] connection " + connection);
		return connection;
	}
	
	public static void close() {
		try {
			connection.close();
		} catch (SQLException e) {
			System.out.println("[ConnectionManager] void close() ERROR: " + e);
		}
	}

}
