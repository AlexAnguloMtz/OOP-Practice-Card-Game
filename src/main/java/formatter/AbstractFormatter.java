package formatter;

public class AbstractFormatter {
    public String f(String template, Object...args) {
        return String.format(template, args);
    }
}
