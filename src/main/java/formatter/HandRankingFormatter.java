package formatter;

import deck.game.hand.impl.HandRanking;

public class HandRankingFormatter {

    public String format(HandRanking ranking) {
        return ranking.name();
    }

}
