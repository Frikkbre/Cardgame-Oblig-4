package no.ntnu.idatx2003.oblig4.cardgame;
import javafx.application.Platform;
import javafx.event.ActionEvent;

import javax.smartcardio.Card;

public class Controller {

    private CardGame cardGame;
    private DeckOfCards deckOfCards;
    private CheckHand checkHand;

    public Controller(CardGame cardGame, DeckOfCards deckOfCards, CheckHand checkHand) {
        this.cardGame = cardGame;
        this.deckOfCards = deckOfCards;
        this.checkHand = checkHand;
    }

    public Controller() {
    }


    public void drawHand() {
        deckOfCards.dealHand(5); //Hardcoded to draw 5 cards
        cardGame.update();
        System.out.println("Hand: " + deckOfCards.getHand().getFirst().getSuit());
    }

    /**
     * Is triggered when the user presses the "Check hand" button
     */
    public void checkHand(){ //TODO - Redundant method??
        checkHand.checkAll(deckOfCards);
        cardGame.update();
    }


    /**
     * Used to exit the program from the top menu
     */
    public void exit() { //TODO - Fix this method
        System.exit(0);
    }
}