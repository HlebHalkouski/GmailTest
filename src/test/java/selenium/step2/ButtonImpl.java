package selenium.step2;

import org.openqa.selenium.WebElement;

class ButtonImpl extends AbstractElement implements Button {
    protected ButtonImpl(final WebElement wrappedElement) {
        super(wrappedElement);
    }

    public void click() {
        wrappedElement.click();
    }
}
