package test;

import java.io.File;

import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import webdriver.BaseTest;
import webdriver.utils.RandomFile;

public class Themes_04 extends BaseTest{
	
	private static final int SIZE_ATACH_FILE = 1;
	private File attachFile;

	@BeforeTest
	@Parameters({"username1", "password1"})
	public void beforeMainMailBoxPageTest(String username1, String password1){
		info("Precondition: ");
		steps.loginGmail(username1, password1);
		attachFile = RandomFile.getFile(SIZE_ATACH_FILE);
	}

	@Test
	public void ThemesTest(){
		
		step(1);
		steps.clickBtnSetting();
		//Assert.assertTrue(steps.isSettingDropDown(), "Setting Drop Down is visible", "Setting Drop Down isn't visible");
		
		step(2);
		steps.enterSettingTheme();
		
		step(5);
		steps.enterUploadTheme();
		
		step(6);
		steps.uploadThemeFile(attachFile);
		Assert.assertTrue(steps.isAlertWrongFilePresent(), "Upload error is present", "Upload error isn't present");
	
		
	}
}
