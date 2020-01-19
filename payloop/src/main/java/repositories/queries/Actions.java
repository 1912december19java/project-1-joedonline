package repositories.queries;

public final class Actions {

	public Actions() {
		System.out.println("[Actions] reached.");
	}

	/*
	 * AUTH
	 */
//	public static String GET_USER_PASS(String username) {
	public static String GET_USER_PASS() {
//		return "SELECT userpass FROM ers_users WHERE username = '" + username + "'";
		return "SELECT userpass FROM ers_users WHERE username = ?";
	}

	public static String GET_USER_BY_USERNAME() {
		return "SELECT * FROM ers_users WHERE username = ?";
	}

	public static String GET_EMPLOYEE_BY_ID(String employeeId) {
		String select = "SELECT employee_id, firstName, lastName, city, state, zipcode ";
		String from = "FROM employees ";
		String where = "WHERE employee_id = ?";
		return select + " " + from + " " + where;
	}

	public static String GET_EMAIL_USERNAME_USERROLE() {
		return "SELECT email, username, userrole FROM ers_users WHERE employee_id = ?";
	}

}
