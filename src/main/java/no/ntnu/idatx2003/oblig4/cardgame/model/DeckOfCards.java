package no.ntnu.idatx2003.oblig4.cardgame.model;

import java.util.ArrayList;
import java.util.Random;

public class DeckOfCards {
  private ArrayList<PlayingCard> deck;
  private ArrayList<PlayingCard> hand;


  public DeckOfCards() {
    deck = new ArrayList<>();
    for (char suit : new char[]{'S', 'H', 'D', 'C'}) {
      for (int i = 1; i <= 13; i++) {
        deck.add(new PlayingCard(suit, i));
      }
      shuffle(deck);
    }
  }

  public void reset() {
    deck.clear();
    hand.clear();
    deck = new ArrayList<>();
    for (char suit : new char[]{'S', 'H', 'D', 'C'}) {
      for (int i = 1; i <= 13; i++) {
        deck.add(new PlayingCard(suit, i));
      }
    }
    shuffle(deck);
  }

  public void shuffle(ArrayList<PlayingCard> deck) {
    Random random = new Random();
    ArrayList<PlayingCard> shuffled = new ArrayList<>();
    for(int i = 0; i < deck.size(); i++) {
      int randomIndex = random.nextInt(deck.size());
      shuffled.add(deck.get(randomIndex));
      deck.remove(randomIndex);
    }
    deck.addAll(shuffled);
  }
  /**
   * Deals n cards from the remaining cards in the deck
   * checks if deck has more than 1 and under 52 cards and throws exception if not
   */
  public void dealHand(int n) {
    hand = new ArrayList<>();
    try {
      if (deck.isEmpty() || deck.size() > 52) {
        throw new IllegalArgumentException("Deck must have more than 1 and less than 52 cards");
      } else if (n < 5 || n > deck.size()) {
        throw new IllegalArgumentException("You must deal a hand between 1 and 52 cards");
      } else if (deck.size() <= 5) {
        throw new IllegalArgumentException("Not enough cards in deck to deal a hand");
      }
      hand.clear();
      for (int i = 0; i < n; i++) {
        hand.add(deck.get(i));
        deck.remove(i);
      }
    } catch (IllegalArgumentException e) {
      System.out.println(e.getMessage());
    }
  }



  public ArrayList<PlayingCard> getDeck() {
    return deck;
  }

  public ArrayList<PlayingCard> getHand() {
    return hand;
  }
}
