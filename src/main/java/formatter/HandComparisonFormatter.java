package formatter;

import deck.game.hand.HandComparison;
import deck.game.hand.impl.HandRanking;

public class HandComparisonFormatter extends AbstractFormatter {

    private final HandRankingFormatter rankingFormatter;

    public HandComparisonFormatter() {
        rankingFormatter = new HandRankingFormatter();
    }

    public String format(HandComparison comparison) {
        return f("WINNER ----> %s \nLOSER  ----> %s",
                format(comparison.winnerRanking()), format(comparison.loserRanking()));
    }

    private String format(HandRanking ranking) {
        return rankingFormatter.format(ranking);
    }

}
