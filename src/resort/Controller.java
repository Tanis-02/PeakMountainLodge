package resort;

import java.io.IOException;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;

public class Controller {

  @FXML private Button bookButton;

  @FXML private Label currentGuest;

  @FXML private Button backButton;

  @FXML
  void backOnePage(MouseEvent event) throws IOException {
    ((Node) (event.getSource())).getScene().getWindow().hide();
    Parent root = FXMLLoader.load(getClass().getResource("home.fxml"));
    Stage home = new Stage();
    home.setTitle("Welcome");
    home.setScene(new Scene(root, 1200, 800));
    home.show();
  }

  @FXML
  void checkDates(MouseEvent event) throws IOException {
    ((Node) (event.getSource())).getScene().getWindow().hide();
    Parent root = FXMLLoader.load(getClass().getResource("new_guest.fxml"));
    Stage newGuestStage = new Stage();
    newGuestStage.setTitle("Check Availability");
    newGuestStage.setScene(new Scene(root, 1200, 800));
    newGuestStage.show();
  }

  @FXML
  void logIn(MouseEvent event) throws IOException {
    ((Node) (event.getSource())).getScene().getWindow().hide();
    Parent root = FXMLLoader.load(getClass().getResource("current_guest.fxml"));
    Stage logInStage = new Stage();
    logInStage.setTitle("Please Log In");
    logInStage.setScene(new Scene(root, 1200, 800));
    logInStage.show();
  }
}
