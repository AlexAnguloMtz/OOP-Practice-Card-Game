package deck.game.hand.impl;

import deck.game.hand.DeckHand;

import static deck.game.card.Rank.ACE;
import static deck.game.card.Rank.TEN;
import static deck.game.hand.Ranking.ROYAL_FLUSH;

/**
 * A royal flush is a straight flush that goes from Ten to Ace
 *
 */
class RoyalFlush extends StraightFlush {

    private static boolean goesFromTenToAce(DeckHand hand) {
        return hand.startsAt(TEN) && hand.endsAt(ACE);
    }

    @Override
    public String name() {
        return ROYAL_FLUSH.toString();
    }

    @Override
    public boolean evaluate(DeckHand hand) {
        return isStraightFlush(hand) && goesFromTenToAce(hand);
    }

    @Override
    public int value() {
        return ROYAL_FLUSH.value();
    }

}
