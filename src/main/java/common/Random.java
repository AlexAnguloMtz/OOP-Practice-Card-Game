package common;

import assertions.Assert;

import java.security.SecureRandom;
import java.util.List;

public class Random {

    private static final SecureRandom random = new SecureRandom();

    public static <T> T pickOne(T[] elements) {
        Assert.notEmpty(elements, "Cannot pick an element from empty array");
        return elements[random(elements.length)];
    }


    public static <T> T pickOne(List<? extends T> elements) {
        Assert.notEmpty(elements, "Cannot pick an element from empty list");
        return elements.get(random(elements.size()));
    }

    private static int random(int top) {
        return random.nextInt(top);
    }
}
