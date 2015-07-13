package selenium.step2;

import org.openqa.selenium.WebElement;

abstract class AbstractElement implements Element {
    protected final WebElement wrappedElement;

    protected AbstractElement(final WebElement wrappedElement) {
        this.wrappedElement = wrappedElement;
    }

    public boolean isDisplayed() {
        return wrappedElement.isDisplayed();
    }
}
