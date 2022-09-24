package deck.game.hand.impl;

import deck.game.hand.DeckHand;


public interface HandRanking extends Comparable<HandRanking> {

    String name();

    boolean evaluate(DeckHand hand);

    int value();

    @Override
    default int compareTo(HandRanking other) {
        return value() - other.value();
    }

}
