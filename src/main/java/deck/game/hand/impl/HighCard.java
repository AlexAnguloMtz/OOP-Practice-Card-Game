package deck.game.hand.impl;

import deck.game.hand.DeckHand;

import static deck.game.hand.Ranking.HIGH_CARD;

public class HighCard implements HandRanking {

    @Override
    public String name() {
        return HIGH_CARD.toString();
    }

    @Override
    public boolean evaluate(DeckHand hand) {
        return true;
    }

    @Override
    public int value() {
        return HIGH_CARD.value();
    }

}