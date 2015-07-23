package webdriver.elements;

import org.openqa.selenium.WebElement;

import webdriver.elements.interfaces.TextBox;

public class TextBoxElement extends BaseElement implements TextBox {
    
	protected TextBoxElement(final WebElement wrappedElement) {
        super(wrappedElement);
    }

    public void type(final String text) {
    	info(String.format("typing '%s'", text));
    	pickElementRed();
    	element.sendKeys(text);
    }

    public void clear() {
        element.clear();
    }

    public void clearAndType(final String text) {
    	clear();
        type(text);
    }

	@Override
	protected String getElementType() {
		return this.getClass().getSimpleName();
	}
}
