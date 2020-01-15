package repositories.queries;

public final class Actions {

	/*
	 * AUTH
	 */
	public static String GET_USER_PASS() {
		return "SELECT userpass FROM ers_users WHERE username = ?";
	}
	
}
