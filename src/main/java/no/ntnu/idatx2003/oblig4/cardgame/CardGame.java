package no.ntnu.idatx2003.oblig4.cardgame;

import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuBar;
import javafx.scene.control.MenuItem;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.FlowPane;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;

import javax.smartcardio.Card;

public class CardGame extends Application {
  private Controller controller;
  private Text displayHand;


  public static void main(String[] args) {
    CardGame.launch();
  }


  @Override
  public void start(javafx.stage.Stage primaryStage) throws Exception {
    controller = new Controller();

    Pane centerPane = new Pane();
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

  private Pane createCenterPane() {
    Button drawButton = new Button("Draw hand");
    drawButton.setOnAction(event -> controller.drawhand());

    Button checkHandButton = new Button("Check hand");
    checkHandButton.setOnAction(event -> {
      controller.checkHand();
    });

    FlowPane buttonPane = new FlowPane();
    buttonPane.getChildren().addAll(drawButton);
    buttonPane.setAlignment(Pos.CENTER);

    displayHand = new Text("Display hand here:");

    VBox centerPane = new VBox();
    centerPane.setAlignment(Pos.CENTER);
    centerPane.getChildren().addAll(displayHand, drawButton);
    return(centerPane);
  }


  public void startGame() {
    DeckOfCards deck = new DeckOfCards();
    deck.shuffle(deck.getDeck());
    deck.dealHand(5);
  }
}
