package deck.game.card;

import common.Random;

import java.util.Objects;

public class Card implements Comparable<Card> {

    private final Rank rank;
    private final Suit suit;

    public Card(Suit suit, Rank rank) {
        this.suit = suit;
        this.rank = rank;
    }

    public static Card getCard() {
        return new Card(randomSuit(), randomRank());
    }

    private static Suit randomSuit() {
        return pickRandom(Suit.values());
    }

    private static Rank randomRank() {
        return pickRandom(Rank.values());
    }

    private static <T> T pickRandom(T[] elements) {
        return Random.pickOne(elements);
    }

    public char suitSymbol() {
        return suit.symbol();
    }

    public Rank getRank() {
        return rank;
    }

    public Suit getSuit() {
        return suit;
    }


    @Override
    public int compareTo(Card other) {
        if (differentRankThan(other)) {
            return rank.compareTo(other.rank);
        }
        return suit.compareTo(other.suit);
    }

    private boolean differentRankThan(Card other) {
        return ! rank.equals(other.rank);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o)
            return true;
        if (!(o instanceof Card))
            return false;
        Card card = (Card) o;
        return rank == card.rank && suit == card.suit;
    }

    @Override
    public int hashCode() {
        return Objects.hash(rank, suit);
    }

    @Override
    public String toString() {
        return "Card{" +
                "rank=" + rank +
                ", suit=" + suit +
                '}';
    }

}
