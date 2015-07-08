package com.epam.automation.GmailTest.webdriver;


import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

public abstract class BaseEntity{

	protected Browser browser;
	
	@BeforeClass
	public void before() {
		browser = Browser.getInstance();		
	}

	
	@AfterClass
	public void after() {
		browser.exit();
	}	
}
