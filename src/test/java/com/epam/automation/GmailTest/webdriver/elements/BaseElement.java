package com.epam.automation.GmailTest.webdriver.elements;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.remote.RemoteWebElement;

import com.epam.automation.GmailTest.webdriver.BaseEntity;

public class BaseElement extends BaseEntity {

	protected RemoteWebElement element;
	
	/**
	 * Click on the item.
	 */
	public void click() {
		waitForIsElementPresent();
		browser.getWebDriver().getMouse().mouseMove(element.getCoordinates());
		if (browser instanceof JavascriptExecutor) {
	        ((JavascriptExecutor)browser).executeScript("arguments[0].style.border='3px solid red'", element);
	    }
		element.click();
		
	}

	private void waitForIsElementPresent() {
		
	}

	public void clear() {
		
		
	}

	


	
}
