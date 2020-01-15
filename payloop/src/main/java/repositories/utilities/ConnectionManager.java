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

		try {
			Class.forName("org.postgresql.Driver");
		} catch (ClassNotFoundException e) {
//			System.out.println("ERROR: " + e);
			e.printStackTrace();
		}

		try {
			connection = DriverManager.getConnection(endpoint, username, password);
		} catch (SQLException e) {

		}

	}

	public static Connection getConnection() {
//		System.out.println("[ConnectionManager] connection -> " + connection);
		return connection;
	}

}
