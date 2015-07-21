package webdriver.utils;

import java.io.File;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.util.Random;

public class RandomUtil {

	private static final String CHARTS = "_0123456789ABCDEFGHIJKLMNOPQRSTUVWXYZ";
	private static final int COUNT_ICONS = 37;
	private static Random random = new Random();
	private static File file;
	
	/**
	 * Gets the random string.
	 *
	 * @param len the lenght of string
	 * @return the random string
	 */
	public static String getRandomString(int len) {
		StringBuilder sb = new StringBuilder(len);
		for (int i = 0; i < len; i++) 
			sb.append(CHARTS.charAt(random.nextInt(CHARTS.length())));
		return sb.toString();
	}
	
	
	/**
	 * Gets the file.
	 *
	 * @param size
	 *            the size file in mb
	 * @return the file
	 */
	public static File getFile(int size) {
		try {
			file = new File("RandomFile.txt");
			RandomAccessFile randomFile = new RandomAccessFile(file, "rw");
			randomFile.setLength(mbToByte(size));
			randomFile.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return file;
	}

	private static long mbToByte(int size) {
		return 1024 * 1024 * size;
	}


	public static String generateIconNumber() {
		String iconNumber = "1f6";
		int number = random.nextInt(COUNT_ICONS);
		if(number/10 == 0)
			iconNumber = iconNumber + "0";
		return iconNumber + number;
	}
}
