package formatter;

import deck.game.Deck;

public class DeckFormatter extends AbstractFormatter {
    public String format(Deck deck) {
        return f("Deck with %d cards", deck.size());
    }
}
