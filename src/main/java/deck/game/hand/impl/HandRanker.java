package deck.game.hand.impl;

import deck.game.hand.DeckHand;

import java.util.List;
import java.util.NoSuchElementException;

public final class HandRanker {

    private static final List<HandRanking> RANKINGS = List.of(
            new RoyalFlush(),
            new StraightFlush(),
            new FourOfAKind(),
            new FullHouse(),
            new FlushImpl(),
            new StraightImpl(),
            new ThreeOfAKind(),
            new TwoPair(),
            new OnePair(),
            new HighCard()
    );

    public static HandRanking rank(DeckHand hand) {
        return RANKINGS.stream()
                .filter(ranking -> ranking.evaluate(hand))
                .findFirst()
                .orElseThrow(() -> new NoSuchElementException("Could not rank this hand"));
    }

}