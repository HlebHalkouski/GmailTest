package test;

import java.io.File;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import webdriver.BaseTest;
import webdriver.utils.RandomUtil;

public class MainMailBoxPage_03  extends BaseTest{
	
	private static final int SIZE_FILE_MB = 26;

	private String username1;
	private File attachFile;
	
	
	@BeforeMethod
	@Parameters({"username1", "password1", "username2"})
	public void beforeMainMailBoxPageTest(String username1, String password1, String username2){
		info("Precondition: ");
		this.username1 = username1;
		steps.loginGmail(username1, password1);
		attachFile = RandomUtil.getFile(SIZE_FILE_MB);
	}
	
	
	@Test
	public void MainMailBoxPageTest()
	{
		step(1);
		steps.startWriteNewMessage();
		
		step(2,4);
		steps.sendAttachMessage(username1, attachFile);
		Assert.assertTrue(steps.isAlertBigFile(),"File bigger then 25mb!", "File approve!");
		
	}

}
