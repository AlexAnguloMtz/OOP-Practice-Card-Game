package deck.game.hand.impl;

import deck.game.hand.DeckHand;

import static deck.game.hand.Ranking.STRAIGHT_FLUSH;

/**
 * A straight flush is a hand that is a straight and also a flush
 *
 */
class StraightFlush implements HandRanking, Straight, Flush {

    @Override
    public String name() {
        return STRAIGHT_FLUSH.toString();
    }

    @Override
    public boolean evaluate(DeckHand hand) {
        return isStraightFlush(hand);
    }

    @Override
    public int value() {
        return STRAIGHT_FLUSH.value();
    }

    boolean isStraightFlush(DeckHand hand) {
        return isStraight(hand) && isFlush(hand);
    }

}
