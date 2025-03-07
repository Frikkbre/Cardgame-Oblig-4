package no.ntnu.idatx2003.oblig4.cardgame;

import javafx.application.Application;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuBar;
import javafx.scene.control.MenuItem;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.Pane;

import javax.smartcardio.Card;

public class CardGame extends Application {


  public static void main(String[] args) {
    CardGame.launch();
  }


  @Override
  public void start(javafx.stage.Stage primaryStage) throws Exception {
    Pane centerPane = new Pane();
    BorderPane borderPane = new BorderPane();
    borderPane.setCenter(createCenterPane());
    borderPane.setTop(createMenuBar());

    Scene scene = new Scene(borderPane);

    primaryStage.setScene(scene);
    primaryStage.setTitle("JavaFxDemo");
    primaryStage.show();
  }

  private Node createMenuBar() {
    MenuItem closeMenuItem = new MenuItem("Close");
    //closeMenuItem.setOnAction(event ->
        //controller.exit());

    Menu fileMenu = new Menu("File");
    fileMenu.getItems().addAll(closeMenuItem);

    MenuBar menuBar = new MenuBar();
    menuBar.getMenus().addAll(fileMenu);
    return menuBar;
  }

  private Pane createCenterPane() {
    Pane centerPane = new Pane();
    Button button = new Button();
    return(centerPane);
  }


  public void startGame() {
    DeckOfCards deck = new DeckOfCards();
    deck.shuffle(deck.getDeck());
    deck.dealHand(5);
  }
}
