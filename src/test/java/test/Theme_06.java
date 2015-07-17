package test;

import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import webdriver.BaseTest;

public class Theme_06 extends BaseTest{

	@BeforeTest
	@Parameters({"username1", "password1"})
	public void beforeMainMailBoxPageTest(String username1, String password1){
		info("Precondition: ");
		steps.loginGmail(username1, password1);
	}
	
	@Test(enabled=false)
	public void ThemeTest(){
		
		step(1,2);
		steps.enterSetting();
		
		
	}
}
