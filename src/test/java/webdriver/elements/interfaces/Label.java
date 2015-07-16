package webdriver.elements.interfaces;

import org.openqa.selenium.By;

public interface Label extends Element {
	void click();

	void waitForIsElementPresent();

	boolean isPresent();

	void setLocator(By xpath);

	void waitForIsElementPresent(By xpath);
}
