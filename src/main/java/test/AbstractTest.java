package test;

import deck.game.Deck;
import deck.game.card.Card;
import deck.game.hand.DeckHand;
import deck.game.hand.HandComparison;
import formatter.CardFormatter;
import formatter.DeckFormatter;
import formatter.DeckHandFormatter;
import formatter.HandComparisonFormatter;

abstract class AbstractTest {

    protected static void display(Deck deck) {
        display(format(deck));
    }

    protected static void display(DeckHand hand) {
        display(format(hand));
    }

    protected static void display(Card card) {
        display(format(card));
    }

    protected static void display(HandComparison comparison) {
        display(format(comparison));
    }

    protected static String format(Card card) {
        return new CardFormatter().format(card);
    }

    protected static String format(HandComparison comparison) {
        return new HandComparisonFormatter().format(comparison);
    }

    protected static String format(DeckHand hand) {
        return new DeckHandFormatter().format(hand);
    }

    protected static String format(Deck deck) {
        return new DeckFormatter().format(deck);
    }

    protected static void display(Object object) {
        System.out.println(object);
    }

}