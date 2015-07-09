package com.epam.automation.GmailTest.test;

import org.testng.annotations.Test;

import com.epam.automation.GmailTest.test.Pages.LoginPage;
import com.epam.automation.GmailTest.webdriver.BaseTest;

public class LetterGoToSpam_01 extends BaseTest{

	@Test
	public void letterGoToSpam(){
		
		String username1 = "hlebtemp@gmail.com";
		String password1 = "dr71gleb";
		
		browser.navigate("http://gmail.com/");
		
		step.loginGmail(username1, password1);
		step.sendMessageToUser2();
		
		
		
	}
	
	
}
