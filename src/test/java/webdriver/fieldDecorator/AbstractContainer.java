package webdriver.fieldDecorator;

import org.openqa.selenium.WebElement;

public abstract class AbstractContainer implements Container {
    private WebElement wrappedElement;

   
    public final void init(final WebElement wrappedElement) {
        this.wrappedElement = wrappedElement;
    }

   
    public boolean isDisplayed() {
        return wrappedElement.isDisplayed();
    }
}
