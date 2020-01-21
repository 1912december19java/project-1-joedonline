package repositories.utilities;

import java.util.Random;

public final class RandomGenerator {
	private static final long serialVersionUID = 1L;

	public static String digits(Integer n) {
		Random rand = new Random();
		StringBuilder strBuild = new StringBuilder();
		for (Integer i = 0; i < n; i++) {
			strBuild.append("" + rand.nextInt(10) + "");
		}
		String str = strBuild.toString();
		return str;
	}
}
