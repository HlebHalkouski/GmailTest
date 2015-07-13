package webdriver.fieldDecorator;

import org.openqa.selenium.WebElement;

public interface IContainerFactory {
    <C extends Container> C create(Class<C> containerClass, WebElement wrappedElement);
}
