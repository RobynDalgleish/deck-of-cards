package com.robyn.project.cards.v2.tarot;

import com.robyn.project.cards.v2.PlayingCard;
import org.junit.Test;

import java.util.HashSet;
import java.util.Stack;

import static com.robyn.project.cards.v2.tarot.MinorArcanaCardTest.assertAllMinorArcanaCardsArePresent;
import static org.junit.Assert.*;

public class TarotDeckTest {

    public static final int DEFAULT_DECK_SIZE = 78;

    @Test
    public void testNewTarotDeckHasCorrectNumberOfCards() {
        assertEquals(DEFAULT_DECK_SIZE, new TarotDeck().getPlayingCards().size());
    }

    @Test
    public void testNewTarotDeckContainsAllTarotCards() {
        Stack<PlayingCard> cardStack = new TarotDeck().getPlayingCards();
        assertAllMinorArcanaCardsArePresent(cardStack);
        assertAllMajorArcanaCardsArePresent(cardStack);
    }

    private void assertAllMajorArcanaCardsArePresent(Stack<PlayingCard> cardStack) {
    }

    @Test
    public void testNewTarotDeckContainsNoDuplicates() {
        Stack<PlayingCard> playingCards = new TarotDeck().getPlayingCards();
        assertEquals(playingCards.size(), new HashSet<>(playingCards).size());
    }

    @Test
    public void testTarotDeckTracksStateWhenCardIsRemoved() {
        TarotDeck TarotDeck = new TarotDeck();
        TarotDeck.getPlayingCards().pop();
        assertEquals(DEFAULT_DECK_SIZE - 1, TarotDeck.getPlayingCards().size());
    }

    @Test
    public void testTarotDeckEquality() {
        TarotDeck TarotDeck = new TarotDeck();
        TarotDeck anotherTarotDeck = new TarotDeck();
        assertEquals(TarotDeck, anotherTarotDeck);
    }

    @Test
    public void testTarotDeckShuffles() {
        int timesShuffledToSameState = 0;
        TarotDeck freshTarotDeck = new TarotDeck();
        TarotDeck TarotDeckToShuffle = new TarotDeck();

        for (int i = 0; i < 100000; i++) {
            TarotDeckToShuffle.shuffle();
            if (freshTarotDeck.equals(TarotDeckToShuffle) && ++timesShuffledToSameState > 1) {
                fail();
            }
        }
        assertNotEquals(freshTarotDeck, TarotDeckToShuffle);
    }
}