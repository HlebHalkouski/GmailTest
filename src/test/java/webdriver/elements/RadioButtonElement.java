package webdriver.elements;

import org.openqa.selenium.WebElement;

import webdriver.elements.interfaces.RadioButton;

public class RadioButtonElement extends BaseElement implements RadioButton {

	protected RadioButtonElement(WebElement wrappedElement) {
		super(wrappedElement);
		
	}

	public boolean isSelect() {
		boolean condition = element.isSelected();
		info(getElementType() + " is selected: " + condition);
		return condition;
	}

	@Override
	protected String getElementType() {
		return this.getClass().getSimpleName();
	}

}
