package webdriver.elements;

import org.openqa.selenium.WebElement;

import webdriver.elements.interfaces.Element;

abstract class BaseElement implements Element {
    protected final WebElement wrappedElement;

    protected BaseElement(final WebElement wrappedElement) {
        this.wrappedElement = wrappedElement;
    }

    
    public boolean isDisplayed() {
        return wrappedElement.isDisplayed();
    }
}
