package com.epam.automation.GmailTest.webdriver;

import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.support.PageFactory;

public abstract class BasePage extends BaseEntity{

	protected By titleLocator;
	protected String pageTitle;
	
	protected BasePage(By locator, String pageTitle){
		init(locator, pageTitle);
		assertIsOpen();
		//Logger.getLogger(this.getClass()).info(pageTitle + "is opened");
		//PageFactory.initElements(browser.getWebDriver(), this.getClass());
	}


	private void assertIsOpen() {
		
		
	}

	private void init(By locator, String title) {
		this.titleLocator = locator;
		this.pageTitle = title;			
	}

	
}
