package webdriver.fieldDecorator;

import org.openqa.selenium.WebElement;

import webdriver.Logger;

public class ContainerFactory implements IContainerFactory {

    public <C extends Container> C create(final Class<C> containerClass, final WebElement wrappedElement) {
        final C container = createInstanceOf(containerClass);
        container.init(wrappedElement);
        return container;
    }

    private <C extends Container> C createInstanceOf(final Class<C> containerClass) {
        try {
            return containerClass.newInstance();
        } catch (InstantiationException e) {
        	Logger.getInstance().warn(containerClass.getSimpleName() + " " + e);
            throw new RuntimeException(e);
        } catch (IllegalAccessException e) {
        	Logger.getInstance().warn(containerClass.getSimpleName() + " " + e);
            throw new RuntimeException(e);
        }
    }
}
