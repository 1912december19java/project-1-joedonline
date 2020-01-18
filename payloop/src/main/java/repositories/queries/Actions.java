package repositories.queries;

public final class Actions {

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
	
}
