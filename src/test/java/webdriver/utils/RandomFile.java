package webdriver.utils;

import java.io.File;
import java.io.IOException;
import java.io.RandomAccessFile;

public class RandomFile {

	private static File file;

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
}
