package no.ntnu.idatx2003.oblig4.cardgame;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

/**
 * Tests the CheckHand class
 * Tests both negative and positive tests
 * Using AAA prinsiple
 * Using maven surefire plugin
 */
public class TestCheckHand {
    private PlayingCard[] hand;
    private CheckHand checkHand;

    @BeforeEach
    public void setUp() {
        checkHand = new CheckHand();
    }

    @Test
    public void testIsFlush() {
        // Arrange
        hand = new PlayingCard[]{
            new PlayingCard('H', 1),
            new PlayingCard('H', 2),
            new PlayingCard('H', 3),
            new PlayingCard('H', 4),
            new PlayingCard('H', 5)
        };

        // Act
        boolean result = checkHand.isFlush(hand);

        // Assert
        assertTrue(result);
    }

    @Test
    public void testIsFlushNegative() {
        // Arrange
        hand = new PlayingCard[]{
            new PlayingCard('H', 1),
            new PlayingCard('H', 2),
            new PlayingCard('H', 3),
            new PlayingCard('H', 4),
            new PlayingCard('S', 5)
        };

        // Act
        boolean result = checkHand.isFlush(hand);

        // Assert
        assertFalse(result);
    }

    @Test
    public void testHasQueenOfSpades() {
        // Arrange
        hand = new PlayingCard[]{
            new PlayingCard('H', 1),
            new PlayingCard('H', 2),
            new PlayingCard('H', 3),
            new PlayingCard('H', 4),
            new PlayingCard('S', 12)
        };

        // Act
        boolean result = checkHand.hasQueenOfSpades(hand);

        // Assert
        assertTrue(result);
    }

    @Test
    public void testHasQueenOfSpadesNegative() {
        // Arrange
        hand = new PlayingCard[]{
            new PlayingCard('H', 1),
            new PlayingCard('H', 2),
            new PlayingCard('H', 3),
            new PlayingCard('H', 4),
            new PlayingCard('S', 11)
        };

        // Act
        boolean result = checkHand.hasQueenOfSpades(hand);

        // Assert
        assertFalse(result);
    }

    @Test
    public void testSumOfCards() {
        // Arrange
        hand = new PlayingCard[]{
            new PlayingCard('H', 1),
            new PlayingCard('H', 2),
            new PlayingCard('H', 3),
            new PlayingCard('H', 4),
            new PlayingCard('S', 12)
        };

        // Act
        int result = checkHand.sumOfCards(hand);

        // Assert
        assertEquals(22, result);
    }

    @Test
    public void testDisplayHearts() {
        // Arrange
        hand = new PlayingCard[]{
            new PlayingCard('H', 1),
            new PlayingCard('H', 2),
            new PlayingCard('H', 3),
            new PlayingCard('H', 4),
            new PlayingCard('S', 12)
        };

        // Act
        ArrayList<PlayingCard> result = checkHand.displayHearts(hand);

        // Assert
        assertEquals(4, result.size());
    }
}

