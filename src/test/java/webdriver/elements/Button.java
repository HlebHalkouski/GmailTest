package webdriver.elements;

import org.openqa.selenium.WebElement;

import webdriver.elements.interfaces.IButton;

class Button extends BaseElement implements IButton {
    
	protected Button(final WebElement wrappedElement) {
        super(wrappedElement);
    }

    public void click() {
        element.click();
    }
}
