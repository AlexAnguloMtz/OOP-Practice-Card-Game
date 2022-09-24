package test;

import deck.game.card.Card;
import test.AbstractTest;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.IntStream;

import static deck.game.card.Card.getCard;
import static java.util.Collections.sort;
import static java.util.Collections.max;
import static java.util.Collections.min;

public class CardTest extends AbstractTest {

    public static void main(String args[] ) {

        List<Card> hand = new ArrayList<>();

        IntStream.range(0, 5)
                 .forEach(iteration -> hand.add(getCard()));

        display(hand);

        Card min = min(hand);
        Card max = max(hand);

        display(min);
        display(max);

        sort(hand);

        display(hand);
    }


}
