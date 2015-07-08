package com.epam.automation.GmailTest.webdriver;


import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

public abstract class BaseEntity {

	protected WebDriver browser = Browser.getInstance();
	
	@BeforeClass
	public void before() {
		browser = Browser.getInstance();		
	}

	
	@AfterClass
	public void after() {
		browser.quit();
	}	
}
