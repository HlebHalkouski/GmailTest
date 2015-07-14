package webdriver.elements;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import webdriver.elements.interfaces.Label;

public class LabelElement extends BaseElement implements Label {

	protected LabelElement(final WebElement wrappedElement) {
		super(wrappedElement);	
	}
	
	public LabelElement(By xpath) {
		super(xpath);
		
	}


	@Override
	protected String getElementType() {
		return this.getClass().getSimpleName();
	}

}
