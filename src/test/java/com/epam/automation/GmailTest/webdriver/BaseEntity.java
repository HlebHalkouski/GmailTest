package com.epam.automation.GmailTest.webdriver;


import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

public abstract class BaseEntity{

	protected Browser browser = Browser.getInstance();
	
	@BeforeClass(alwaysRun = true)
	public void before() {
		browser = Browser.getInstance();	
	}

	
	@AfterClass(alwaysRun = true)
	public void after() {
		browser.exit();
	}	
}
