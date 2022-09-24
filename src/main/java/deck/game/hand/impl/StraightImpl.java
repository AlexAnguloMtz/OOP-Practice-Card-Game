package deck.game.hand.impl;

import deck.game.hand.DeckHand;

import static deck.game.hand.Ranking.STRAIGHT;

public class StraightImpl implements HandRanking, Straight {

    @Override
    public String name() {
        return STRAIGHT.toString();
    }

    @Override
    public boolean evaluate(DeckHand hand) {
        return isStraight(hand);
    }

    @Override
    public int value() {
        return STRAIGHT.value();
    }

}
