package deck.game.hand;

import deck.game.hand.impl.HandRanking;

public class HandComparison {

    private final DeckHand winner;
    private final DeckHand loser;

    private HandComparison(DeckHand winner, DeckHand loser) {
        this.winner = winner;
        this.loser = loser;
    }

    public static HandComparison of(DeckHand firstHand, DeckHand secondHand) {
        final DeckHand winner = winner(firstHand, secondHand);
        final DeckHand loser = loser(firstHand, secondHand);
        return new HandComparison(winner, loser);
    }

    private static DeckHand winner(DeckHand firstHand, DeckHand secondHand) {
        return DeckHand.winner(firstHand, secondHand);
    }

    private static DeckHand loser(DeckHand firstHand, DeckHand secondHand) {
        return DeckHand.loser(firstHand, secondHand);
    }

    public HandRanking winnerRanking() {
        return winner.ranking();
    }

    public HandRanking loserRanking() {
        return loser.ranking();
    }

}