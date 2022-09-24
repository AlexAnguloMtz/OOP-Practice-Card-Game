package deck.game.card;

import assertions.Assert;

import java.util.*;

public enum Rank {

        TWO,
        THREE,
        FOUR,
        FIVE,
        SIX,
        SEVEN,
        EIGHT,
        NINE,
        TEN,
        JACK,
        QUEEN,
        KING,
        ACE;


    public static Rank lowestOf(Collection<Rank> ranks) {
        Assert.notEmpty(ranks, "Can't find lowest rank in empty collection");
        return Collections.min(ranks);
    }

    public static Rank highestOf(Collection<Rank> ranks) {
        Assert.notEmpty(ranks, "Can't find highest rank in empty collection");
        return Collections.max(ranks);
    }

    public boolean comesExactlyAfter(Rank otherRank) {
        // Edge case, ACE can come before TWO
        if (this.equals(TWO) && otherRank.equals(ACE)) {
            return true;
        }
        final int exactRequiredDifference = 1;
        return compareTo(otherRank) == exactRequiredDifference;
    }

}