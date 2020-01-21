package repositories.queries;

public final class Actions {

	public Actions() {
		System.out.println("[Actions] reached.");
	}

	/*
	 * USERS
	 */
	public static String GET_USER_PASS() {
		return "SELECT userpass FROM ers_users WHERE username = ?";
	}
	
	public static String GET_USER_PASS(String username) {
		return "SELECT userpass FROM ers_users WHERE username = '" + username + "'";
	}

	public static String GET_USER_BY_USERNAME() {
		return "SELECT * FROM ers_users WHERE username = ?";
	}

	/*
	 * EMPLOYEES
	 */
	public static String GET_EMPLOYEE_BY_ID(String employeeId) {
		String select = "SELECT employee_id, firstName, lastName, city, state, zipcode ";
		String from = "FROM employees ";
		String where = "WHERE employee_id = ?";
		return select + " " + from + " " + where;
	}

	public static String GET_EMAIL_USERNAME_USERROLE() {
		return "SELECT email, username, userrole FROM ers_users WHERE employee_id = ?";
	}

	/*
	 * REIMBURSEMENTS
	 */
	public static String GET_ALL_BY_REIMBURSEMENT_STATUS() {
		return "SELECT * FROM reimbursements WHERE employee_id = ? AND reimbursement_status = ?";
	}

	public static String SAVE_NEW_REIMBURSEMENT_REQUEST() {
		String insertInto = "INSERT INTO reimbursements (reimbursement_id, reimbursement_amount, reimbursement_status, reimbursement_date_submitted, reimbursement_date_approved, employee_id, receipt_url)";
		String values = "VALUES (?, ?, ?, ?, ?, ?, ?)";
		return insertInto + " " + values;
	}

}
