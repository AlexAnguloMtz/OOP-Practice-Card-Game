package test;

import deck.game.card.Card;
import deck.game.hand.DeckHand;
import deck.game.hand.HandComparison;
import common.Random;

import java.util.List;

import static deck.game.card.Rank.*;
import static deck.game.card.Suit.*;
import static java.util.stream.IntStream.range;

public class DeckHandTest extends AbstractTest {

    private static final List<DeckHand> HANDS = List.of(
            royalFlush(),
            straightFlush(),
            fourOfAKind(),
            fullHouse(),
            flush(),
            straight(),
            threeOfAKind(),
            twoPair(),
            onePair(),
            highCard()
    );

    private static final String WHITE_SPACE_TO_CLEAR_THE_SCREEN =
            "\n\n\n";


    public static void main(String[] args) {
        range(0, 20).forEach(iteration -> runTest());
        display(WHITE_SPACE_TO_CLEAR_THE_SCREEN);
    }

    private static void runTest() {
        final DeckHand[] twoDifferentHands = twoDifferentHands();
        final DeckHand firstHand = twoDifferentHands[0];
        final DeckHand secondHand = twoDifferentHands[1];
        displayComparison(firstHand, secondHand);
    }

    private static DeckHand[] twoDifferentHands() {
        DeckHand firstHand = null;
        DeckHand secondHand = null;
        while (firstHand == secondHand) {
            firstHand = randomHand();
            secondHand = randomHand();
        }
        return new DeckHand[] { firstHand, secondHand };
    }

    private static DeckHand randomHand() {
        return Random.pickOne(HANDS);
    }

    private static void displayComparison(DeckHand firstHand, DeckHand secondHand) {

        // Show header for a new test
        display("\n\n================= TEST ==================");

        // Show both hands
        display(firstHand);
        display("\n");
        display(secondHand);

        // White space
        display("\n");

        // Compare both hands and show who beats who
        HandComparison comparison = firstHand.comparisonWith(secondHand);
        display(comparison);
    }

    private static DeckHand highCard() {
        List<Card> highCard = List.of(
                new Card(DIAMONDS, ACE),
                new Card(CLUBS, THREE),
                new Card(HEARTS, FIVE),
                new Card(SPADES, NINE),
                new Card(DIAMONDS, QUEEN)
        );
        return DeckHand.with(highCard);
    }

    private static DeckHand onePair() {
        List<Card> onePair = List.of(
                new Card(DIAMONDS, SEVEN),
                new Card(CLUBS, SEVEN),
                new Card(SPADES, TEN),
                new Card(HEARTS, JACK),
                new Card(DIAMONDS, KING)
        );
        return DeckHand.with(onePair);
    }

    private static DeckHand twoPair() {
        List<Card> twoPair = List.of(
                new Card(DIAMONDS, EIGHT),
                new Card(CLUBS, EIGHT),
                new Card(HEARTS, FIVE),
                new Card(CLUBS, FIVE),
                new Card(SPADES, TEN)
        );
        return DeckHand.with(twoPair);
    }

    private static DeckHand threeOfAKind() {
        List<Card> threeOfAKind = List.of(
                new Card(DIAMONDS, SEVEN),
                new Card(CLUBS, SEVEN),
                new Card(SPADES, SEVEN),
                new Card(HEARTS, NINE),
                new Card(DIAMONDS, TEN)
        );
        return DeckHand.with(threeOfAKind);
    }

    private static DeckHand straight() {
        List<Card> straight = List.of(
                new Card(DIAMONDS, SIX),
                new Card(CLUBS, SEVEN),
                new Card(SPADES, EIGHT),
                new Card(HEARTS, NINE),
                new Card(DIAMONDS, TEN)
        );
        return DeckHand.with(straight);
    }

    private static DeckHand flush() {
        List<Card> flush = List.of(
                new Card(DIAMONDS, ACE),
                new Card(DIAMONDS, THREE),
                new Card(DIAMONDS, FIVE),
                new Card(DIAMONDS, SEVEN),
                new Card(DIAMONDS, NINE)
        );
        return DeckHand.with(flush);
    }

    private static DeckHand fullHouse() {
        List<Card> fullHouse = List.of(
                new Card(SPADES, NINE),
                new Card(HEARTS, NINE),
                new Card(CLUBS, NINE),
                new Card(DIAMONDS, TEN),
                new Card(CLUBS, TEN)
        );
        return DeckHand.with(fullHouse);
    }

    private static DeckHand fourOfAKind() {
        List<Card> fourOfAKind = List.of(
                new Card(SPADES, ACE),
                new Card(HEARTS, ACE),
                new Card(CLUBS, ACE),
                new Card(DIAMONDS, ACE),
                new Card(SPADES, NINE)
        );
        return DeckHand.with(fourOfAKind);
    }

    private static DeckHand straightFlush() {
        List<Card> straightFlush = List.of(
                new Card(SPADES, FIVE),
                new Card(SPADES, SIX),
                new Card(SPADES, SEVEN),
                new Card(SPADES, EIGHT),
                new Card(SPADES, NINE)
        );
        return DeckHand.with(straightFlush);
    }

    private static DeckHand royalFlush() {
        List<Card> royalFlush = List.of(
                new Card(SPADES, TEN),
                new Card(SPADES, JACK),
                new Card(SPADES, QUEEN),
                new Card(SPADES, KING),
                new Card(SPADES, ACE)
        );
        return DeckHand.with(royalFlush);
    }

}