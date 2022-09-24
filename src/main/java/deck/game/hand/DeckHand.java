package deck.game.hand;

import common.Repetitions;
import deck.game.Deck;
import deck.game.card.Card;
import deck.game.card.Rank;
import deck.game.card.Suit;
import deck.game.hand.impl.HandRanker;
import deck.game.hand.impl.HandRanking;

import java.util.*;

import static java.util.Collections.unmodifiableList;
import static java.util.stream.Collectors.*;
import static java.util.stream.IntStream.range;

/**
 * Representation of a DeckHand in a deck game
 *
 * @author Alex Angulo
 */
public class DeckHand implements Comparable<DeckHand> {

    public static final int HAND_SIZE = 5;

    private final List<Card> sortedCards;

    protected DeckHand(Deck deck) {
        this.sortedCards = sort(takeCardsFrom(deck));
    }

    protected DeckHand(List<Card> cards) {
        this.sortedCards = sort(cards);
    }

    public static DeckHand winner(DeckHand firstHand, DeckHand secondHand) {
        return firstHand.beats(secondHand) ? firstHand : secondHand;
    }

    public static DeckHand loser(DeckHand firstHand, DeckHand secondHand) {
        return firstHand.beats(secondHand) ? secondHand : firstHand;
    }

    public static DeckHand with(List<Card> cards) {
        return new DeckHand(cards);
    }

    public boolean beats(DeckHand otherHand) {
        return compareTo(otherHand) > 0;
    }

    /**
     * Determines whether this hand has a higher or lower value than the other hand
     *
     * @param other the hand to be compared
     * @return A value higher than 0 if this hand's value is greater than the compared hand,
     * or a value lower than 0 otherwise.
     */
    @Override
    public int compareTo(DeckHand other) {
        return compareRankingsWith(other);
    }


    public boolean hasDifferentRankingThan(DeckHand second) {
        return !ranking().equals(second.ranking());
    }

    public HandRanking ranking() {
        return HandRanker.rank(this);
    }

    public int size() {
        return sortedCards.size();
    }

    /**
     * Take a certain amount of cards from a deck.
     * The resulting List will be sorted
     *
     * @param deck the deck to take cards from
     * @return the cards that this instance will have
     */
    private List<Card> takeCardsFrom(Deck deck) {
        return range(0, HAND_SIZE)
                .mapToObj(eachIteration -> deck.draw())
                .collect(toList());
    }

    public int amountOfUniqueSuits() {
        return uniqueSuitsInHand().size();
    }

    public Rank rankAt(int position) {
        Card card = sortedCards.get(position);
        return card.getRank();
    }

    public boolean startsAt(Rank rank) {
        return lowest().equals(rank);
    }

    public boolean endsAt(Rank rank) {
        return highest().equals(rank);
    }

    public List<Rank> allRanks() {
        return sortedCards.stream()
                .map(Card::getRank)
                .collect(toList());
    }

    public boolean isAnyCardRepeated(int numberOfRepetitions) {
        final Repetitions<Rank> repetitions = Repetitions.in(allRanks());
        return repetitions.isAnyRepeated(numberOfRepetitions);
    }

    public boolean hasExactlyOnePair() {
        return amountOfPairs() == 1;
    }

    public boolean hasExactlyTwoPairs() {
        return amountOfPairs() == 2;
    }

    public boolean hasThreeOfAKind() {
        final int requiredRepetitionsForThreeOfAKind = 3;
        return isAnyCardRepeated(requiredRepetitionsForThreeOfAKind);
    }

    public int highCardComparisonWith(DeckHand other) {
        return highest().compareTo(other.highest());
    }


    public List<Card> cards() {
        return unmodifiableList(sortedCards);
    }

    public HandComparison comparisonWith(DeckHand otherHand) {
        return HandComparison.of(this, otherHand);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        DeckHand deckHand = (DeckHand) o;
        return sortedCards.equals(deckHand.sortedCards);
    }

    @Override
    public int hashCode() {
        return Objects.hash(sortedCards);
    }

    @Override
    public String toString() {
        return "DeckHand{" +
                "sortedCards=" + sortedCards +
                '}';
    }


    private Card cardAt(int position) {
        return sortedCards.get(position);
    }

    private int amountOfPairs() {
        final int repetitionsInAPair = 2;
        return cardsWithNumberOfRepetitions(repetitionsInAPair);
    }
    private int cardsWithNumberOfRepetitions(int numberOfRepetitions) {
        Repetitions<Rank> repetitions = Repetitions.in(allRanks());

        List<Rank> ranksWithSpecifiedNumberOfRepetitions =
                repetitions.elementsWithNumberOfRepetitions(numberOfRepetitions);

        return ranksWithSpecifiedNumberOfRepetitions.size();
    }

    private int compareRankingsWith(DeckHand other) {
        return ranking().compareTo(other.ranking());
    }

    private Rank highest() {
        return Rank.highestOf(uniqueRanksInHand());
    }

    private Rank lowest() {
        return Rank.lowestOf(uniqueRanksInHand());
    }


    private Set<Rank> uniqueRanksInHand() {
        return sortedCards.stream()
                .map(Card::getRank)
                .collect(toSet());
    }

    private Set<Suit> uniqueSuitsInHand() {
        return sortedCards.stream()
                .map(Card::getSuit)
                .collect(toSet());
    }

    private List<Card> sort(Collection<? extends Card> cards) {
        return cards.stream()
                .sorted()
                .collect(toList());
    }


}