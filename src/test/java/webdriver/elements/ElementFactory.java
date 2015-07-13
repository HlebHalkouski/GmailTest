package webdriver.elements;

import org.openqa.selenium.WebElement;

import webdriver.elements.interfaces.Element;
import webdriver.elements.interfaces.IElementFactory;

import java.lang.reflect.InvocationTargetException;

import static java.text.MessageFormat.format;

public class ElementFactory implements IElementFactory{
    public <E extends Element> E create(final Class<E> elementClass, final WebElement wrappedElement) {
        try {
            return findImplementationFor(elementClass)
                    .getDeclaredConstructor(WebElement.class)
                    .newInstance(wrappedElement);
        } catch (InstantiationException e) {
            throw new RuntimeException(e);
        } catch (IllegalAccessException e) {
            throw new RuntimeException(e);
        } catch (InvocationTargetException e) {
            throw new RuntimeException(e);
        } catch (NoSuchMethodException e) {
            throw new RuntimeException(e);
        }
    }

    @SuppressWarnings("unchecked")
	private <E extends Element> Class<? extends E> findImplementationFor(final Class<E> elementClass) {
        try {
        	System.out.println((Class<? extends E>) Class.forName(format("{0}.{1}", getClass().getPackage().getName(), elementClass.getSimpleName())));
        	return (Class<? extends E>) Class.forName(format("{0}.{1}", getClass().getPackage().getName(), elementClass.getSimpleName()));
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }
}

