package resort;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class Main extends Application {

  @Override
  public void start(Stage primaryStage) throws Exception {
    ConnManager connManager = new ConnManager();
    connManager.selectAllCustomers();
    Parent root = FXMLLoader.load(getClass().getResource("fxml_files/home.fxml"));
    primaryStage.setScene(new Scene(root, 1000, 700));
    primaryStage.show();
  }

  public static void main(String[] args) {
    launch(args);
  }
}
