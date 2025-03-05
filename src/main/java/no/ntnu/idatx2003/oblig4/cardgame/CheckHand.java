package no.ntnu.idatx2003.oblig4.cardgame;

import java.util.ArrayList;

/**
 * This class is used to check the hand of a player
 * Checks hand for:
 * - 5 card flush (all cards have the same suit) using stream
 * - queen of spades
 * - sum of cards (ace = 1)
 * - display only the cards with suit heart
 */
public class CheckHand {

  /**
   * Checks if the hand is a flush
   * @param hand the hand to check
   * @return true if the hand is a flush, false otherwise
   */
  public static boolean isFlush(PlayingCard[] hand) {
    return hand.length == 5 && hand[0].getSuit() == hand[1].getSuit() && hand[1].getSuit() == hand[2].getSuit() && hand[2].getSuit() == hand[3].getSuit() && hand[3].getSuit() == hand[4].getSuit();
  }

  /**
   * Checks if the hand contains the queen of spades
   * @param hand the hand to check
   * @return true if the hand contains the queen of spades, false otherwise
   */
  public static boolean hasQueenOfSpades(PlayingCard[] hand) {
    for (PlayingCard card : hand) {
      if (card.getFace() == 12 && card.getSuit() == 'S') {
        return true;
      }
    }
    return false;
  }

  /**
   * Calculates the sum of the cards in the hand
   * @param hand the hand to calculate the sum of
   * @return the sum of the cards in the hand
   */
  public static int sumOfCards(PlayingCard[] hand) {
    int sum = 0;
    for (PlayingCard card : hand) {
      sum += card.getFace();
    }
    return sum;
  }

  /**
   * Displays only the cards with suit heart
   * @param hand the hand to display
   */
  public static ArrayList<PlayingCard> displayHearts(PlayingCard[] hand) {
    ArrayList<PlayingCard> hearts = new ArrayList<PlayingCard>();
    for (PlayingCard card : hand) {
      if (card.getSuit() == 'H') {
        hearts.add(card);
      }
    }
    return hearts;
  }
}
