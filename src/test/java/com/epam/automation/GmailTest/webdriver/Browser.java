package com.epam.automation.GmailTest.webdriver;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.RemoteWebDriver;

public class Browser {
	
	private static RemoteWebDriver driver;
	private static Browser instance;
	private static long IMPLICITY_WAIT = 10;
	private static final long PAGE_LOAD_TIMEOUT = 20;
	
	
	private Browser(){};
	
	public static Browser getInstance(){
		if(instance == null){
			driver = new FirefoxDriver();
			driver.manage().timeouts().implicitlyWait(IMPLICITY_WAIT , TimeUnit.SECONDS);
			driver.manage().timeouts().pageLoadTimeout(PAGE_LOAD_TIMEOUT, TimeUnit.SECONDS);  		 
		}
		instance = new Browser();
		return instance;
	}

	public RemoteWebDriver getWebDriver() {
		return driver;
	}
	
	
	public void exit() {
		try {
			driver.quit();
			} catch (Exception e) {
			e.printStackTrace();
		} finally {
			instance = null;
		}
	}

	/**
	 * Navgates to the Url
	 * @param url Url
	 */
	public void navigate(final String url) {
		driver.navigate().to(url);
	}
	
	
}
