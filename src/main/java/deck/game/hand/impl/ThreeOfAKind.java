package deck.game.hand.impl;

import deck.game.hand.DeckHand;

import static deck.game.hand.Ranking.THREE_OF_A_KIND;

/**
 * We say three of a kind when we have the same rank in three different suits
 *
 */
class ThreeOfAKind implements HandRanking {

    @Override
    public String name() {
        return THREE_OF_A_KIND.toString();
    }

    @Override
    public boolean evaluate(DeckHand hand) {
        return hand.hasThreeOfAKind();
    }

    @Override
    public int value() {
        return THREE_OF_A_KIND.value();
    }

}
