package webdriver.elements;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import webdriver.elements.interfaces.Button;

public class ButtonElement extends BaseElement implements Button {
    
	protected ButtonElement(final WebElement wrappedElement) {
        super(wrappedElement);
    }

	public ButtonElement(By locator) {
		super(locator);	
	}
    
	@Override
	protected String getElementType() {
		return this.getClass().getSimpleName();
	}


	
}
