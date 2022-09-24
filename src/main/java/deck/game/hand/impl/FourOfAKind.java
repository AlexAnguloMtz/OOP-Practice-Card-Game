package deck.game.hand.impl;

import deck.game.hand.DeckHand;

import static deck.game.hand.Ranking.FOUR_OF_A_KIND;


/**
 * A four of a kind happens when we have all the four suits for the same card
 *
 */

class FourOfAKind implements HandRanking {

    private static final int REQUIRED_RANK_REPETITIONS = 4;

    @Override
    public String name() {
        return FOUR_OF_A_KIND.toString();
    }

    @Override
    public boolean evaluate(DeckHand hand) {
        return hand.isAnyCardRepeated(REQUIRED_RANK_REPETITIONS);
    }

    @Override
    public int value() {
        return FOUR_OF_A_KIND.value();
    }

}