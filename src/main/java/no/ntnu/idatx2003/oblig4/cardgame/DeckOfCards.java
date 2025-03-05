package no.ntnu.idatx2003.oblig4.cardgame;

import javax.smartcardio.Card;
import java.util.ArrayList;
import java.util.Collections;

public class DeckOfCards {
  private ArrayList<String> deck;
  private ArrayList<String> hand;


  DeckOfCards() {
    int suitCounter = 0;
    deck = new ArrayList<>();
    for(int i = 1; i <= 14; i++) {
      if(i == 14){
        suitCounter++;
        if(suitCounter == 4){
          break;
        }
        i = 1;

      }

      switch(suitCounter) {
        case 0:
          deck.add(i + "S");
          break;

        case 1:
          deck.add(i + "H");
          break;

        case 2:
          deck.add(i + "D");
          break;

        case 3:
          deck.add(i + "C");
          break;
      }
    }
  }

  public void shuffle(ArrayList<String> deck) {
    Collections.shuffle(deck);
  }

  /**
   * Deals n cards from the remaining cards in the deck
   * checks if deck has more than 1 and under 52 cards and throws exception if not
   * @return
   */
  public void dealHand(int n) {
    hand = new ArrayList<>();
    if(deck.size() < 1 || deck.size() > 52) {
      throw new IllegalArgumentException("Deck must have more than 1 and less than 52 cards");
    } else if (n < 1 || n > deck.size()) {
      throw new IllegalArgumentException("you must deal a hand between 1 and 52 cards");
    } else if (n > deck.size()) {
      throw new IllegalArgumentException("Not enough cards in deck to deal a hand of " + n + " cards");
    }
    for(int i = 0; i < n; i++) {
      hand.add(deck.get(i));
      deck.remove(i);
    }
  }



  public ArrayList<String> getDeck() {
    return deck;
  }
}
