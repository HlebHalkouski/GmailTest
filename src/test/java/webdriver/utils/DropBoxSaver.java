package webdriver.utils;

import java.io.File;
import java.io.FileInputStream;
import java.util.Locale;

import com.dropbox.core.*;

public class DropBoxSaver {

	private static DbxEntry.File uploadedFile;
	private static DbxRequestConfig config;
	private static FileInputStream inputStream;
	private static DbxClient client;
	private static final String accessToken = "8iriXI5B9WAAAAAAAAAACaXQyHfdVPXuq8uaSE8aeQfcZKi-Cc-iKRtTo3hlVknl";
	//TODO accessToken в проперти
	
	public static String saveScreenshop(File uploadImage) {
		try {
			config = new DbxRequestConfig("GmailTest/1.0", Locale.getDefault().toString());
			client = new DbxClient(config, accessToken);
			inputStream = new FileInputStream(uploadImage);
			try {
				uploadedFile = client.uploadFile("/"+ uploadImage.getName(), DbxWriteMode.add(), uploadImage.length(), inputStream);
			} finally {
				inputStream.close();
			}
			return client.createShareableUrl(uploadedFile.path);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return "";
	}

}
