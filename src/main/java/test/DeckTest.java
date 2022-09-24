package test;

import deck.game.Deck;

import java.util.stream.IntStream;

import static java.lang.String.format;

public class DeckTest extends AbstractTest {

    public static void main(String[] args) {

        Deck deck = new Deck();

        drawAndShowRemainingCards(5, deck);
        drawAndShowRemainingCards(5, deck);

        display(String.format("Cards in the deck: %d%n", deck.size()));

        deck.shuffle();

        display(deck);

    }

    private static void drawAndShowRemainingCards(int cardsToDraw, Deck deck) {
        IntStream.range(0, cardsToDraw)
                .mapToObj(eachIteration -> deck.draw())
                .forEach(DeckTest::display);

        display(String.format("Cards in the deck: %d%n", deck.size()));
    }

}
