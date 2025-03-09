package no.ntnu.idatx2003.oblig4.cardgame;

import no.ntnu.idatx2003.oblig4.cardgame.model.CheckHand;
import no.ntnu.idatx2003.oblig4.cardgame.model.DeckOfCards;
import no.ntnu.idatx2003.oblig4.cardgame.model.PlayingCard;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

public class TestPlayingCard {
  /**
   * Test getSuit method
   */
  @Test
  public void testGetSuit() {
    // Arrange
    PlayingCard card = new PlayingCard('H', 1);

    // Act
    char result = card.getSuit();

    // Assert
    assertEquals('H', result);
  }

  /**
   * Test getFace method
   */
  @Test
  public void testGetFace() {
    // Arrange
    PlayingCard card = new PlayingCard('H', 1);

    // Act
    int result = card.getFace();

    // Assert
    assertEquals(1, result);
  }

  /**
   * Test equals method
   */
  @Test
  public void testEquals() {
    // Arrange
    PlayingCard card1 = new PlayingCard('H', 1);
    PlayingCard card2 = new PlayingCard('H', 1);

    // Act
    boolean result = card1.equals(card2);

    // Assert
    assertTrue(result);
  }
}
