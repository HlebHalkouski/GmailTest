package webdriver.elements.interfaces;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public interface Element {
    
	boolean isDisplayed();

	boolean isPresent(By by);
	
	boolean isPresent();

	void setLocator(By locator);

	void waitForIsElementPresent(By locator);

	WebElement getElement();
}
