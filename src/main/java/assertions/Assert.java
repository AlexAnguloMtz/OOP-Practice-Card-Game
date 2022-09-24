package assertions;

import java.util.Collection;

import static java.util.Objects.requireNonNull;

public class Assert {

    public static <T> void equals(T first, T second, String message) {
        if (!first.equals(second))
            throw new IllegalArgumentException(message);
    }

    public static void nonNull(Object object) {
        requireNonNull(object);
    }

    public static <T> void notEmpty(T[] elements, String message) {
        Assert.nonNull(elements);
        if (elements.length == 0)
            throw new IllegalArgumentException(message);
    }

    public static <T> void notEmpty(Collection<? extends T> elements) {
        Assert.nonNull(elements);
        if (elements.size() == 0)
            throw new IllegalArgumentException();
    }

    public static <T> void notEmpty(Collection<? extends T> elements, String message) {
        Assert.nonNull(elements);
        if (elements.size() == 0)
            throw new IllegalArgumentException(message);
    }

    public static void isGreater(int tested, int floor, String message) {
        if (tested <= floor)
            throw new IllegalArgumentException(message);
    }

}