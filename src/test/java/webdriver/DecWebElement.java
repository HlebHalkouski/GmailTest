package webdriver;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Point;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebElement;

public class DecWebElement extends BaseEntity implements WebElement{

	protected RemoteWebElement element;
	
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

	public WebElement findElement(By arg0) {
		
		return element.findElement(arg0);
	}

	public List<WebElement> findElements(By arg0) {
		
		return element.findElements(arg0);
	}

	public String getAttribute(String arg0) {
		
		return element.getAttribute(arg0);
	}

	public String getCssValue(String arg0) {
		
		return element.getCssValue(arg0);
	}

	public Point getLocation() {
		return element.getLocation();
	}

	public Dimension getSize() {
		return element.getSize();
	}

	public String getTagName() {
		return element.getTagName();
	}

	public String getText() {
		return element.getText();
	}

	public boolean isDisplayed() {
		return element.isDisplayed();
	}

	public boolean isEnabled() {
		return element.isEnabled();
	}

	public boolean isSelected() {
		return element.isSelected();
	}

	public void sendKeys(CharSequence... arg0) {
		element.sendKeys(arg0);
		
	}

	public void submit() {
		element.submit();
		
	}

	


	
}
