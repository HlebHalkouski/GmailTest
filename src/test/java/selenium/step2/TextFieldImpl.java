package selenium.step2;

import org.openqa.selenium.WebElement;

class TextFieldImpl extends AbstractElement implements TextField {
    protected TextFieldImpl(final WebElement wrappedElement) {
        super(wrappedElement);
    }

    public void type(final String text) {
        wrappedElement.sendKeys(text);
    }

    public void clear() {
        wrappedElement.clear();
    }

    public void clearAndType(final String text) {
        clear();
        type(text);
    }
}
