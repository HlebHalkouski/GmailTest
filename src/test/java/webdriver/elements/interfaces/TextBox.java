package webdriver.elements.interfaces;

public interface TextBox extends Element {
    
	void type(String text);

    void clear();

    void clearAndType(String text);
}
