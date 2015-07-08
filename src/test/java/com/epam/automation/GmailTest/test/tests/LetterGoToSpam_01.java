package com.epam.automation.GmailTest.test.tests;

import org.testng.annotations.Test;

import com.epam.automation.GmailTest.test.Pages.LoginPage;
import com.epam.automation.GmailTest.webdriver.BaseTest;

public class LetterGoToSpam_01 extends BaseTest{

	@Test
	public void letterGoToSpam(){
		
		String username1 = null;
		String password1 = null;
		
		browser.navigate("http://gmail.com/");
		
		//step1
		LoginPage loginPage = new LoginPage();
		loginPage.login(username1, password1);
		assert(steps., dfsgd)
		
		
	}
	
	
}
