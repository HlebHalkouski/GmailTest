package webdriver.elements.interfaces;

public interface ITextBox extends Element {
   
	void type(String text);

    void clear();

    void clearAndType(String text);
}
