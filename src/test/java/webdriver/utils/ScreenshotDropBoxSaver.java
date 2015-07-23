package webdriver.utils;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Locale;

import com.dropbox.core.*;

public class ScreenshotDropBoxSaver {

	private static final String APP_SECRET = "spwpbjpb5kul82l";
	private static final String APP_KEY = "a9jq12n43lunx8m";
	private static DbxEntry.File uploadedFile;
	
	
	public static String saveScreenshop(File uploadFile) throws IOException, DbxException{
		
		DbxAppInfo appInfo = new DbxAppInfo(APP_KEY, APP_SECRET);

        DbxRequestConfig config = new DbxRequestConfig(
            "JavaTutorial/1.0", Locale.getDefault().toString());
        DbxWebAuthNoRedirect webAuth = new DbxWebAuthNoRedirect(config, appInfo);
        String authorizeUrl = webAuth.start();
        
        String code = new BufferedReader(new InputStreamReader(System.in)).readLine().trim();
        DbxAuthFinish authFinish = webAuth.finish(code);
        
        String accessToken = authFinish.accessToken;
        
        DbxClient client = new DbxClient(config, accessToken);
      
        FileInputStream inputStream = new FileInputStream(uploadFile);
        try {
             uploadedFile = client.uploadFile("/magnum-opus.txt",
                DbxWriteMode.add(), uploadFile.length(), inputStream);
            System.out.println("Uploaded: " + uploadedFile.toString());
		
		} finally {
           
				inputStream.close();
			
        }
		
		return uploadedFile.toString();
		
	}
	
}
