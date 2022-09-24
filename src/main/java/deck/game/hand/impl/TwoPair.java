package deck.game.hand.impl;


import deck.game.hand.DeckHand;

import static deck.game.hand.Ranking.TWO_PAIR;


/**
 * We say two pairs when we have two different pairs of two different ranks
 *
 */
class TwoPair implements HandRanking {

    @Override
    public String name() {
        return TWO_PAIR.toString();
    }

    @Override
    public boolean evaluate(DeckHand hand) {
        return hand.hasExactlyTwoPairs();
    }

    @Override
    public int value() {
        return TWO_PAIR.value();
    }

}
