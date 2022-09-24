package deck.game;

import deck.game.card.Card;
import deck.game.card.Rank;
import deck.game.card.Suit;

import java.util.Collections;
import java.util.LinkedList;

public class Deck {

    LinkedList<Card> cards = null;

    public Deck() {
        cards = new LinkedList<>();
        for (Suit suit : Suit.values()) {
            for (Rank rank : Rank.values()) {
                Card c = new Card(suit, rank);
                cards.add(c);
            }
        }
        // shuffle();
    }

    public void shuffle() {
        Collections.shuffle(cards);
    }

    public Card draw() {
        Card topCard = null;

        if ( !cards.isEmpty() )
            topCard = cards.removeLast();

        return topCard;
    }

    public boolean isEmpty() {
        return cards.isEmpty();
    }

    public int size() {
        return cards.size();
    }

}
