package deck.game.hand.impl;

import deck.game.hand.DeckHand;

import static deck.game.hand.Ranking.FLUSH;

public class FlushImpl implements HandRanking, Flush {

    @Override
    public String name() {
        return FLUSH.toString();
    }

    @Override
    public boolean evaluate(DeckHand hand) {
        return isFlush(hand);
    }

    @Override
    public int value() {
        return FLUSH.value();
    }

}
