package no.ntnu.idatx2003.oblig4.cardgame;

import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.FlowPane;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;
import javafx.stage.Stage;

import javax.smartcardio.Card;
import java.util.ArrayList;

/**
 * This class is the main class for the CardGame application
 * It is responsible for starting the application and creating the GUI
 */
public class CardGame extends Application {
  private Controller controller;
  private DeckOfCards deckOfCards;
  private TextField displayHand;
  private TextField displayChecks;


  public static void main(String[] args) {
    CardGame.launch();
  }

  /**
   * Start the application
   * @param primaryStage
   * @throws Exception
   */
  @Override
  public void start(Stage primaryStage) throws Exception {
    deckOfCards = new DeckOfCards();
    CheckHand checkHand = new CheckHand();
    controller = new Controller(this, deckOfCards, checkHand);

    BorderPane borderPane = new BorderPane();
    borderPane.setCenter(createCenterPane());
    borderPane.setTop(createMenuBar());

    Scene scene = new Scene(borderPane);

    primaryStage.setScene(scene);
    primaryStage.setTitle("Card Game");
    primaryStage.setMinHeight(540);
    primaryStage.setMinWidth(960);
    primaryStage.show();
  }

  /**
   * Create the menu bar at the top of the BorderPane
   * Only has exit menu item
   * @return
   */
  private Node createMenuBar() {
    MenuItem closeMenuItem = new MenuItem("Close");
    closeMenuItem.setOnAction(event ->
        controller.exit());

    Menu fileMenu = new Menu("File");
    fileMenu.getItems().addAll(closeMenuItem);

    MenuBar menuBar = new MenuBar();
    menuBar.getMenus().addAll(fileMenu);
    return menuBar;
  }

  /**
   * Create the center pane of the BorderPane
   * This is where the main content of the application will be displayed
   * @return Center pane
   */
  private Pane createCenterPane() { //TODO - display data in seperate textFields
    Button drawButton = new Button("Draw hand");
    drawButton.setOnAction(event -> controller.drawHand());

    FlowPane buttonPane = new FlowPane();
    buttonPane.getChildren().addAll(drawButton);
    buttonPane.setAlignment(Pos.CENTER);

    displayHand = new TextField("Hand is diplayed here: ");
    displayHand.setEditable(false);
    displayHand.setFont(new javafx.scene.text.Font(20));
    displayHand.setMaxWidth(300);

    displayChecks = new TextField("Checks are displayed here: ");
    displayChecks.setEditable(false);
    displayChecks.setFont(new javafx.scene.text.Font(10));
    displayChecks.setMaxWidth(300);

    VBox centerPane = new VBox();
    centerPane.setAlignment(Pos.CENTER);
    centerPane.getChildren().addAll(displayHand, drawButton, displayChecks);
    return(centerPane);
  }

  /**
   * Update the display with the current state of the game
   * Updates textFields with the current hand, checks if the hand is a flush, contains the queen of spades, sum of cards and displays only the cards with suit heart
   */
  public void update() { //TODO - display data in seperate textFields
    // Update the displayHand text with the current hand
    StringBuilder handText = new StringBuilder("Hand: ");
    for (PlayingCard card : deckOfCards.getHand()) {
      handText.append(card.getSuit()).append(card.getFace()).append(" ");
    }
    displayHand.setText(handText.toString());

    // Perform other updates as needed
    boolean isFlush = CheckHand.isFlush(deckOfCards.getHand().toArray(new PlayingCard[0]));
    boolean hasQueenOfSpades = CheckHand.hasQueenOfSpades(deckOfCards.getHand().toArray(new PlayingCard[0]));
    int sumOfCards = CheckHand.sumOfCards(deckOfCards.getHand().toArray(new PlayingCard[0]));
    ArrayList<PlayingCard> hearts = CheckHand.displayHearts(deckOfCards.getHand().toArray(new PlayingCard[0]));

    // Print or update UI with these values TODO - add to UI  in seperate textFields
    System.out.println("Is Flush: " + isFlush);
    System.out.println("Has Queen of Spades: " + hasQueenOfSpades);
    System.out.println("Sum of Cards: " + sumOfCards);
    System.out.println("Hearts: " + hearts);
  }
}
