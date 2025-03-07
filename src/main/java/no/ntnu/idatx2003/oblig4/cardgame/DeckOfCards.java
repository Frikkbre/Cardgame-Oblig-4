package no.ntnu.idatx2003.oblig4.cardgame;

import javax.smartcardio.Card;
import java.util.ArrayList;
import java.util.Collections;

public class DeckOfCards {
  private ArrayList<PlayingCard> deck;
  private ArrayList<PlayingCard> hand;


  DeckOfCards() {
    deck = new ArrayList<>();
    for (char suit : new char[]{'S', 'H', 'D', 'C'}) {
      for (int i = 1; i <= 13; i++) {
        deck.add(new PlayingCard(suit, i));
      }
    }
  }

  public void shuffle(ArrayList<PlayingCard> deck) {
    Collections.shuffle(deck);
  }

  /**
   * Deals n cards from the remaining cards in the deck
   * checks if deck has more than 1 and under 52 cards and throws exception if not
   */
  public void dealHand(int n) {
    hand = new ArrayList<>();
    if(deck.isEmpty() || deck.size() > 52) {
      throw new IllegalArgumentException("Deck must have more than 1 and less than 52 cards");
    } else if (n < 1 || n > deck.size()) {
      throw new IllegalArgumentException("you must deal a hand between 1 and 52 cards");
    }
    hand.clear();
    for(int i = 0; i < n; i++) {
      hand.add(deck.get(i));
      deck.remove(i);
    }
  }



  public ArrayList<PlayingCard> getDeck() {
    return deck;
  }

  public ArrayList<PlayingCard> getHand() {
    return hand;
  }
}
