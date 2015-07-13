package webdriver.elements;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebElement;

import webdriver.elements.interfaces.Element;

public abstract class BaseElement implements Element {
    
	protected final RemoteWebElement element;

    protected BaseElement(final WebElement wrappedElement) {
        this.element = (RemoteWebElement) wrappedElement;
    }
    
    public boolean isDisplayed() {
        return element.isDisplayed();
    }
}
