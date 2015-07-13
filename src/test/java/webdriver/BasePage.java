package webdriver;

import org.openqa.selenium.By;

public abstract class BasePage extends BaseEntity{

	protected By titleLocator;
	protected String pageTitle;
	
	protected BasePage(By locator, String pageTitle){
		init(locator, pageTitle);
		assertIsOpen();
		
	}


	private void assertIsOpen() {
			
	}

	private void init(By locator, String title) {
		this.titleLocator = locator;
		this.pageTitle = title;			
	}

	
}
