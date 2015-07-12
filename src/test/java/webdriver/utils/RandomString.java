package webdriver.utils;

import java.util.Random;

public class RandomString {

	private static final String CHARTS = " 0123456789ABCDEFGHIJKLMNOPQRSTUVWXYZ";
	private static Random random = new Random();
	
	public static String getRandomString(int len) {
		StringBuilder sb = new StringBuilder(len);
		for (int i = 0; i < len; i++) 
			sb.append(CHARTS.charAt(random.nextInt(CHARTS.length())));
		return sb.toString();
	}

}
