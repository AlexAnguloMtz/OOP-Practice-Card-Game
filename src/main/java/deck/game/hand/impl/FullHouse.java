package deck.game.hand.impl;

import deck.game.hand.DeckHand;

import static deck.game.hand.Ranking.FULL_HOUSE;

/**
 * A full house happens when we have three of a kind and a pair
 */

class FullHouse implements HandRanking {

    @Override
    public String name() {
        return FULL_HOUSE.toString();
    }

    @Override
    public boolean evaluate(DeckHand hand) {
        return isFullHouse(hand);
    }

    private boolean isFullHouse(DeckHand hand) {
        return     hand.hasThreeOfAKind()
                && hand.hasExactlyOnePair();
    }

    @Override
    public int value() {
        return FULL_HOUSE.value();
    }

}