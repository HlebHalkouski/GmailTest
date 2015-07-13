package selenium.step2;

public interface TextField extends Element {
    void type(String text);

    void clear();

    void clearAndType(String text);
}
