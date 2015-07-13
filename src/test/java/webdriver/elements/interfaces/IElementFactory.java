package webdriver.elements.interfaces;

import org.openqa.selenium.WebElement;

public interface IElementFactory {
    <E extends Element> E create(Class<E> elementClass, WebElement wrappedElement);
}
