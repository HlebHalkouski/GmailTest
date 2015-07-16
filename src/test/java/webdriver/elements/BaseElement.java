package webdriver.elements;


import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import webdriver.BaseEntity;
import webdriver.Browser;
import webdriver.elements.interfaces.Element;

abstract class BaseElement extends BaseEntity implements Element {
    
	protected WebElement element;
	private By locator;
	
  
	protected BaseElement(final WebElement wrappedElement) {
        this.element =  wrappedElement;
    }
    
    public BaseElement(By locator) {
		this.locator = locator;
    	this.element = browser.getWebDriver().findElement(locator);
	}

    
    
	/**
	 * Click on the item.
	 */
	public void click() {
		info("clicking");
		pickElementRed();
		element.click();
	};

    public void pickElementRed() {
    	if (browser.getWebDriver() instanceof JavascriptExecutor) {
			((JavascriptExecutor) browser.getWebDriver()).executeScript("arguments[0].style.border='3px solid red'",
					element);
		}		
	}

	public WebElement getElement() {
		return element;
	}
    
    /**
	 * The implementation of an abstract method for logging of BaseEntity
	 * @param message Message to display in the log
	 * @return Formatted message (containing the name and type of item)
	 */
	protected String formatLogMsg(final String message) {
		return String.format("%1$s %2$s ", getElementType(), message);
	}

	/**
	 * The method returns the element type (used for logging)
	 * @uml.property name="elementType"
	 * @return Type of element
	 */
	protected abstract String getElementType();

	public boolean isDisplayed() {
        return element.isDisplayed();
    }
	
	/**
	 * Wait for element is present.
	 */
	public void waitForIsElementPresent() {
		isPresent(Integer.valueOf(browser.getImplicitlyWait()));
		Assert.assertTrue(element.isDisplayed(), "is absent");
	}
	
	/**
	 * Wait for element is present.
	 */
	public void waitForIsElementPresent(By locator) {
		this.locator = locator;
		isPresent(Integer.valueOf(browser.getImplicitlyWait()));
		Assert.assertTrue(element.isDisplayed(), "is absent");
	}
	

	public boolean isPresent() {
		return false;
	}
	
	/**
	 * Check for is element present on the page.
	 * @return Is element present
	 */
	public boolean isPresent(int timeout) {
		WebDriverWait wait = new WebDriverWait(Browser.getInstance().getWebDriver(), timeout);
		try {
			wait.until((ExpectedCondition<Boolean>) new ExpectedCondition<Boolean>() {
				public Boolean apply(final WebDriver driver) {
					try {
						List<WebElement> list = driver.findElements(locator);
						for (WebElement el : list) {
							if (el instanceof WebElement && el.isDisplayed()) 
								return el.isDisplayed();
						}
						element = driver.findElement(locator);
					} catch (Exception e) {
						return false;
					}
					return element.isDisplayed();
				}
			});
		} catch (Exception e) {
			warn(e.getMessage());
			return false;
		}
		try {
			browser.getWebDriver().manage().timeouts().implicitlyWait(Integer.valueOf(browser.getImplicitlyWait()), TimeUnit.SECONDS);
			return element.isDisplayed();
		} catch (Exception e) {
			warn(e.getMessage());
		}
		return false;
	}
	
	  public By getLocator() {
			return locator;
		}

		public void setLocator(By locator) {
			this.locator = locator;
		}

	
}
