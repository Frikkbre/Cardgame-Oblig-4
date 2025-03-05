package no.ntnu.idatx2003.oblig4.cardgame;

import javax.smartcardio.Card;
import java.util.ArrayList;
import java.util.Collections;

public class DeckOfCards {
  private ArrayList<PlayingCard> deck;
  private ArrayList<PlayingCard> hand;


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
          String SName = i + "S";
          PlayingCard Sname = new PlayingCard('S', i);
          deck.add(Sname);
          break;

        case 1:
          String HName = i + "H";
          PlayingCard Hname = new PlayingCard('H', i);
          deck.add(Hname);
          break;

        case 2:
          String DName = i + "D";
          PlayingCard Dname = new PlayingCard('D', i);
          deck.add(Dname);
          break;

        case 3:
          String CName = i + "C";
          PlayingCard Cname = new PlayingCard('C', i);
          deck.add(Cname);
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
    if(deck.isEmpty() || deck.size() > 52) {
      throw new IllegalArgumentException("Deck must have more than 1 and less than 52 cards");
    } else if (n < 1 || n > deck.size()) {
      throw new IllegalArgumentException("you must deal a hand between 1 and 52 cards");
    }
    for(int i = 0; i < n; i++) {
      hand.add(deck.get(i));
      deck.remove(i);
    }
  }



  public ArrayList<PlayingCard> getDeck() {
    return deck;
  }
}
