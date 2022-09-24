package formatter;

import deck.game.card.Card;
import deck.game.hand.DeckHand;
import deck.game.hand.impl.HandRanking;

import java.util.List;

import static java.lang.String.join;
import static java.util.stream.Collectors.toList;

public class DeckHandFormatter extends AbstractFormatter {

    private static final String BETWEEN_CARDS = " | ";

    private final CardFormatter cardFormatter;
    private final HandRankingFormatter handRankingFormatter;

    public DeckHandFormatter() {
        this.cardFormatter = new CardFormatter();
        this.handRankingFormatter = new HandRankingFormatter();
    }

    public String format(DeckHand hand) {
        return f("\n|%s |   ----> %s", formatCardsIn(hand), format(hand.ranking()));
    }

    private String format(HandRanking ranking) {
        return handRankingFormatter.format(ranking);
    }

    private String formatCardsIn(DeckHand hand) {
        return join(BETWEEN_CARDS, formatCards(hand.cards()));
    }

    private List<String> formatCards(List<Card> cards) {
        return cards.stream()
                .map(cardFormatter::format)
                .collect(toList());
    }

}