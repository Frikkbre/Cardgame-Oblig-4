package no.ntnu.idatx2003.oblig4.cardgame;

import javax.smartcardio.Card;
import java.util.ArrayList;
import java.util.Collections;

public class DeckOfCards {
  private ArrayList<String> deck;


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

  public ArrayList<String> getDeck() {
    return deck;
  }
}
