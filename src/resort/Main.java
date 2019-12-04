package resort;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

/**
 * The main class of the project. Everything starts here at this point.
 */
public class Main extends Application {

  /**
   * The start() method displays the home page of the program.
   *
   * @param primaryStage home page
   * @throws Exception yes, it does
   */
  @Override
  public void start(Stage primaryStage) throws Exception {
    Parent root = FXMLLoader.load(getClass().getResource("fxml_files/home.fxml"));
    primaryStage.setScene(new Scene(root, 1000, 700));
    primaryStage.show();
  }

  /**
   * The main() method that runs first in all projects.
   *
   * @param args command line arguments
   */
  public static void main(String[] args) {
    launch(args);
  }
}
