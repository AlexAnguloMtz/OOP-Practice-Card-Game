package deck.game.hand.impl;


import deck.game.hand.DeckHand;

import static deck.game.hand.Ranking.ONE_PAIR;

/**
 * We say one pair when we have one pair
 * of the same rank in two different suits
 *
 */
class OnePair implements HandRanking {

    @Override
    public String name() {
        return ONE_PAIR.toString();
    }

    @Override
    public boolean evaluate(DeckHand hand) {
        return hand.hasExactlyOnePair();
    }

    @Override
    public int value() {
        return ONE_PAIR.value();
    }

}
