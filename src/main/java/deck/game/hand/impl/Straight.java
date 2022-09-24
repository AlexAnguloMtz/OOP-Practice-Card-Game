package deck.game.hand.impl;

import deck.game.card.Rank;
import deck.game.hand.DeckHand;

interface Straight {

    default boolean isStraight(DeckHand hand) {
        for (int position = 1; position < hand.size(); position++) {
            Rank currentRank = hand.rankAt(position);
            Rank previousRank = hand.rankAt(position - 1);
            if ( ! currentRank.comesExactlyAfter(previousRank) ) {
                return false;
            }
        }
        return true;
    }

}