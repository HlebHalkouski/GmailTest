package webdriver.elements;

import org.openqa.selenium.WebElement;

import webdriver.elements.interfaces.ITextBox;

class TextBox extends BaseElement implements ITextBox {
   
	protected TextBox(final WebElement wrappedElement) {
        super(wrappedElement);
    }

    
    public void type(final String text) {
        element.sendKeys(text);
    }

   
    public void clear() {
        element.clear();
    }

    
    public void clearAndType(final String text) {
        clear();
        type(text);
    }


	public void click() {
		element.click();
		
	}
}
