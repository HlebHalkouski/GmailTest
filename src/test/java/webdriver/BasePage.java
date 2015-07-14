package webdriver;

import org.openqa.selenium.By;

import webdriver.elements.LabelElement;

public abstract class BasePage extends BaseEntity{

	protected By locator;
	protected String pageTitle;
	
	protected BasePage(By locator, String pageTitle){
		this.locator = locator;
		this.pageTitle = pageTitle;		
		assertIsOpen();
	}


	private void assertIsOpen() {
		LabelElement titleElement = new LabelElement(locator);
		try {
			titleElement.waitForIsElementPresent();
			info(String.format("Page %s appears", pageTitle));
		} catch (Throwable e) {
			fatal(String.format("Page %s doesn't appears", pageTitle));
		}
	}	
	
	protected String formatLogMsg(final String message) {
		return message;
	}
	
}
