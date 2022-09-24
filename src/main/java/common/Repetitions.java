package common;


import assertions.Assert;

import java.util.*;

import static java.lang.String.format;
import static java.util.stream.Collectors.toList;
import static java.util.Map.Entry;

public class Repetitions <T> {

    private static final String INVALID_NUMBERS_OF_REPETITIONS
            = "Invalid number of repetitions. Expected: 2 or higher. Found: %d";

    private final Map<T, Integer> counter;

    private Repetitions(Map<T, Integer> counter) {
        this.counter = counter;
    }

    public static <T> Repetitions<T> in(Collection<? extends T> all) {
        Assert.notEmpty(all);
        final var counter = new HashMap<T, Integer>();
        for (T each : all) {
            counter.put(each, nextValue(each, counter));
        }
        return new Repetitions<>(counter);
    }

    private static <T> Integer nextValue(T element, HashMap<T, Integer> counter) {
        return (counter.containsKey(element)) ? counter.get(element) + 1 : 1;
    }

    public boolean isAnyRepeated(int numberOfTimes) {
        validate(numberOfTimes);
        return counter.values().stream()
            .anyMatch(repetitionsPerElement -> repetitionsPerElement.equals(numberOfTimes));
    }

    public List<T> elementsWithNumberOfRepetitions(int numberOfTimes) {
        validate(numberOfTimes);
        return counter.entrySet().stream()
                .filter(entry -> isKeyRepeated(entry, numberOfTimes))
                .map(Entry::getKey)
                .collect(toList());
    }

    private boolean isKeyRepeated(Entry<T, Integer> entry, int numberOfTimes) {
        validate(numberOfTimes);
        return repetitions(entry) == numberOfTimes;
    }

    private int repetitions(Entry<T, Integer> entry) {
        return entry.getValue();
    }

    private void validate(int numberOfTimes) {
        int minimumNumberOfTimesToBeConsideredRepeated = 2;
        Assert.isGreater(numberOfTimes, minimumNumberOfTimesToBeConsideredRepeated - 1,
                format(INVALID_NUMBERS_OF_REPETITIONS, numberOfTimes));
    }

}
