package no.ntnu.idatx2003.oblig4.cardgame;

import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuBar;
import javafx.scene.control.MenuItem;
import javafx.scene.control.TextField;
import javafx.scene.layout.*;
import javafx.stage.Stage;
import java.util.ArrayList;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundImage;
import javafx.scene.layout.BackgroundPosition;
import javafx.scene.layout.BackgroundRepeat;
import javafx.scene.layout.BackgroundSize;

/**
 * This class is the main class for the CardGame application
 * It is responsible for starting the application and creating the GUI
 */
public class CardGame extends Application {
  private Controller controller;
  private DeckOfCards deckOfCards;
  private TextField displayHand;
  private TextField displayFlush;
  private TextField displayQueenOfSpades;
  private TextField displaySumOfCards;
  private TextField displayHearts;


  public static void main(String[] args) {
    CardGame.launch();
  }

  /**
   * Start the application
   *
   * @param primaryStage
   * @throws Exception
   */
  @Override
  public void start(Stage primaryStage) throws Exception {
    deckOfCards = new DeckOfCards();
    deckOfCards.shuffle(deckOfCards.getDeck());
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
   *
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
   *
   * @return Center pane
   */
  private Pane createCenterPane() {
    Button drawButton = new Button("Draw hand");
    drawButton.setOnAction(event -> controller.drawHand());

    Button resetButton = new Button("Reset");
    resetButton.setOnAction(event -> controller.reset());

    FlowPane buttonPane = new FlowPane();
    buttonPane.getChildren().addAll(drawButton, resetButton);
    buttonPane.setAlignment(Pos.CENTER);

    displayHand = new TextField("Hand is diplayed here: ");
    displayHand.setEditable(false);
    displayHand.setFont(new javafx.scene.text.Font(20));
    displayHand.setMaxWidth(300);

    displayFlush = new TextField("Is flush: ");
    displayFlush.setEditable(false);
    displayFlush.setFont(new javafx.scene.text.Font(10));
    displayFlush.setMaxWidth(300);

    displayQueenOfSpades = new TextField("Has queen of spades: ");
    displayQueenOfSpades.setEditable(false);
    displayQueenOfSpades.setFont(new javafx.scene.text.Font(10));
    displayQueenOfSpades.setMaxWidth(300);

    displaySumOfCards = new TextField("Sum of Cards: ");
    displaySumOfCards.setEditable(false);
    displaySumOfCards.setFont(new javafx.scene.text.Font(10));
    displaySumOfCards.setMaxWidth(300);

    displayHearts = new TextField("Hearts: ");
    displayHearts.setEditable(false);
    displayHearts.setFont(new javafx.scene.text.Font(10));
    displayHearts.setMaxWidth(300);

    VBox centerPane = new VBox();
    centerPane.setAlignment(Pos.CENTER);
    centerPane.getChildren().addAll(displayHand, drawButton, resetButton, displayFlush, displayQueenOfSpades, displaySumOfCards, displayHearts);
    centerPane.setBackground(setBackground());
    return (centerPane);
  }

  /**
   * Update the display with the current state of the game
   * Updates textFields with the current hand, checks if the hand is a flush, contains the queen of spades, sum of cards and displays only the cards with suit heart
   */
  public void update() {
    StringBuilder handText = new StringBuilder("Hand: ");
    if (deckOfCards.getDeck().size() <= 5) {
      handText.append("Not enough cards in deck");
      displayHand.setText(handText.toString());
    } else {
      for (PlayingCard card : deckOfCards.getHand()) {
        handText.append(card.getSuit()).append(card.getFace()).append(" ");
      }
      displayHand.setText(handText.toString());

      boolean isFlush = CheckHand.isFlush(deckOfCards.getHand().toArray(new PlayingCard[0]));
      boolean hasQueenOfSpades = CheckHand.hasQueenOfSpades(deckOfCards.getHand().toArray(new PlayingCard[0]));
      int sumOfCards = CheckHand.sumOfCards(deckOfCards.getHand().toArray(new PlayingCard[0]));
      ArrayList<PlayingCard> hearts = CheckHand.displayHearts(deckOfCards.getHand().toArray(new PlayingCard[0]));
      ArrayList<String> heartsString = new ArrayList<>();
      for (int i = 0; i < hearts.size(); i++) {
        heartsString.add(hearts.get(i).getSuit() + "" + hearts.get(i).getFace());
      }


      StringBuilder flushText = new StringBuilder("Is flush: " + CheckHand.isFlush(deckOfCards.getHand().toArray(new PlayingCard[0])));
      StringBuilder queenOfSpadesText = new StringBuilder("Has queen of spades: " + CheckHand.hasQueenOfSpades(deckOfCards.getHand().toArray(new PlayingCard[0])));
      StringBuilder sumOfCardsText = new StringBuilder("Sum of cards: " + CheckHand.sumOfCards(deckOfCards.getHand().toArray(new PlayingCard[0])));
      StringBuilder heartsText = new StringBuilder("Hearts: " + heartsString);

      displayFlush.setText(flushText.toString());
      displayQueenOfSpades.setText(queenOfSpadesText.toString());
      displaySumOfCards.setText(sumOfCardsText.toString());
      displayHearts.setText(heartsText.toString());
    }
  }

  /**
   * Set the background of the application
   * Uses image /img/Poker-Table.png
   *
   * @return image used as background
   */
  private Background setBackground() {
    return new Background(new BackgroundFill(javafx.scene.paint.Color.DARKGREEN, null, null)); // Default green felt background
  }
}
