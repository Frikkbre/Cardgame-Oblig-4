package no.ntnu.idatx2003.oblig4.cardgame;
import javafx.application.Platform;
import javafx.event.ActionEvent;

import javax.smartcardio.Card;

/**
 * This class is the controller for the CardGame application
 * Works as a event handler for the buttons in the CardGame class
 */
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

    /**
     * Is triggered when the user presses the "Draw hand" button
     * Deals a hand of five cards
     * Also calls the update method in the CardGame class
     */
    public void drawHand() {
        try{
            deckOfCards.dealHand(5); //Hardcoded to draw 5 cards
            cardGame.update();
        } catch (IllegalArgumentException e) {
            System.out.println("Error: " + e.getMessage());
        }
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