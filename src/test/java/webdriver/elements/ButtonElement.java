package webdriver.elements;

import org.openqa.selenium.WebElement;

import webdriver.elements.interfaces.Button;

class ButtonElement extends BaseElement implements Button {
    
	protected ButtonElement(final WebElement wrappedElement) {
        super(wrappedElement);
    }

    
	@Override
	protected String getElementType() {
		return this.getClass().getSimpleName();
	}


	
}
