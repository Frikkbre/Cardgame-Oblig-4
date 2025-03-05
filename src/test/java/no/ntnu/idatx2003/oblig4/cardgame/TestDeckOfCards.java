package no.ntnu.idatx2003.oblig4.cardgame;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;


/**
 * This class is used to test the DeckOfCards class
 * Tests methods:
 * - shuffle
 * - dealHand
 */
public class TestDeckOfCards {
    private DeckOfCards deck;

    @BeforeEach
    public void setUp() {
        deck = new DeckOfCards();
    }

    @Test
    public void testShuffle() {
        // Arrange
        ArrayList<PlayingCard> deckBeforeShuffle = deck.getDeck();

        DeckOfCards deckAfterShuffle = new DeckOfCards();

        // Act
        deckAfterShuffle.shuffle(deck.getDeck());


        System.out.println(deckBeforeShuffle);
        System.out.println(deckAfterShuffle);
        // Assert
        assertNotEquals(deckBeforeShuffle, deckAfterShuffle);
    }

    @Test
    public void testDealHand() {
        // Arrange
        deck.shuffle(deck.getDeck());
        int deckSizeBeforeDeal = deck.getDeck().size();

        // Act
        deck.dealHand(5);
        int deckSizeAfterDeal = deck.getDeck().size();

        // Assert
        assertEquals(deckSizeBeforeDeal - 5, deckSizeAfterDeal);
    }
}
