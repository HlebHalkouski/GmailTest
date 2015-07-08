package com.epam.automation.GmailTest.webdriver;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class Browser {
	
	private static WebDriver driver;
	
	private Browser(){};
	
	public static WebDriver getInstance(){
		if(driver == null){
			driver = new FirefoxDriver();
		}
		return driver;
	}

	public static WebDriver getWebDriver() {
		return driver;
	}

	
	
}
