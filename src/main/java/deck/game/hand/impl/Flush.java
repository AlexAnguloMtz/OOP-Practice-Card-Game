package deck.game.hand.impl;

import deck.game.hand.DeckHand;


interface Flush {

    public static final int AMOUNT_OF_SUITS_IN_A_FLUSH = 1;

    /**
     * A flush happens when all the five cards have the same suit
     *
     * @return true if this hand has a flush, false otherwise
     */
    default boolean isFlush(DeckHand hand) {
        return hand.amountOfUniqueSuits() == AMOUNT_OF_SUITS_IN_A_FLUSH;
    }

}