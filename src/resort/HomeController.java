package resort;

import java.io.IOException;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;

/** Everything in the HomeController corresponds to items in the home.fxml file */
public class HomeController {

  /**
   * The goToNewGuestPage() function will bring the user to the new guest page.
   *
   * @param event MouseEvent upon clicking the book now button
   * @throws IOException yes, it does
   */
  @FXML
  void goToNewGuestPage(MouseEvent event) throws IOException {
    ((Node) (event.getSource())).getScene().getWindow().hide();
    Parent root = FXMLLoader.load(getClass().getResource("new_guest.fxml"));
    Stage newGuestStage = new Stage();
    newGuestStage.setTitle("Check Availability");
    newGuestStage.setScene(new Scene(root, 800, 600));
    newGuestStage.show();
  }

  /**
   * The goToCurrentGuestPage() function will bring the user to the current guest page.
   *
   * @param event MouseEvent upon clicking the current guest label
   * @throws IOException yes, it does
   */
  @FXML
  void goToCurrentGuestPage(MouseEvent event) throws IOException {
    ((Node) (event.getSource())).getScene().getWindow().hide();
    Parent root = FXMLLoader.load(getClass().getResource("current_guest.fxml"));
    Stage logInStage = new Stage();
    logInStage.setTitle("Please Log In");
    logInStage.setScene(new Scene(root, 800, 600));
    logInStage.show();
  }

  /**
   * The goToManagerLoginPage() function will bring the user to the manager login page.
   *
   * @param event MouseEvent upon clicking the manager label
   * @throws IOException yes, it does
   */
  @FXML
  void goToManagerLoginPage(MouseEvent event) throws IOException {
    ((Node) (event.getSource())).getScene().getWindow().hide();
    Parent root = FXMLLoader.load(getClass().getResource("manager_login.fxml"));
    Stage logInStage = new Stage();
    logInStage.setTitle("Please input manager credentials");
    logInStage.setScene(new Scene(root, 800, 600));
    logInStage.show();
  }
}
