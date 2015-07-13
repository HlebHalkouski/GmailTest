package webdriver.fieldDecorator;

import org.openqa.selenium.WebElement;

import webdriver.elements.interfaces.Element;

public interface Container extends Element {
    void init(WebElement wrappedElement);
}
