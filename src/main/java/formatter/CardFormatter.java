package formatter;

import deck.game.card.Card;

public class CardFormatter extends AbstractFormatter {

    public String format(Card card) {
        return f("%2s %4s %s",
                card.suitSymbol(), card.getRank(), card.suitSymbol());
    }

}