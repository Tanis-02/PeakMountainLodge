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
    Parent newGuestParent = FXMLLoader.load(getClass().getResource("new_guest.fxml"));
    Scene newGuestScene = new Scene(newGuestParent);
    Stage newGuestStage = (Stage) ((Node) event.getSource()).getScene().getWindow();
    newGuestStage.setScene(newGuestScene);
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
    Parent currentGuestParent = FXMLLoader.load(getClass().getResource("current_guest.fxml"));
    Scene currentGuestScene = new Scene(currentGuestParent);
    Stage newGuestStage = (Stage) ((Node) event.getSource()).getScene().getWindow();
    newGuestStage.setScene(currentGuestScene);
    newGuestStage.show();
  }

  /**
   * The goToManagerLoginPage() function will bring the user to the manager login page.
   *
   * @param event ActionEvent upon clicking the manager label
   * @throws IOException yes, it does
   */
  @FXML
  void goToManagerLoginPage(MouseEvent event) throws IOException {
    Parent managerLoginParent = FXMLLoader.load(getClass().getResource("manager_login.fxml"));
    Scene managerLoginScene = new Scene(managerLoginParent);
    Stage managerLoginStage = (Stage) ((Node) event.getSource()).getScene().getWindow();
    managerLoginStage.setScene(managerLoginScene);
    managerLoginStage.show();
  }
}
