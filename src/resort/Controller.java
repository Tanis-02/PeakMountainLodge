package resort;

import java.io.IOException;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.TabPane;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;

public class Controller {

  /** Text field on the current guest page for the user to enter their last name */
  @FXML private TextField lastName;

  /** Text field on the current guest page for the user to enter their phone number */
  @FXML private TextField phoneNumber;

  /** Function that the log in button calls on the current guest page */
  @FXML
  void logInButton() {}

  // Tab Pane for the manager overview screen
  @FXML private TabPane overviewTabs;

  @FXML
  void goToPreviousPage(MouseEvent event) throws IOException {
    ((Node) (event.getSource())).getScene().getWindow().hide();
    Parent root = FXMLLoader.load(getClass().getResource("home.fxml"));
    Stage home = new Stage();
    home.setTitle("Welcome");
    home.setScene(new Scene(root, 800, 600));
    home.show();
  }

  @FXML
  void goToNewGuestPage(MouseEvent event) throws IOException {
    ((Node) (event.getSource())).getScene().getWindow().hide();
    Parent root = FXMLLoader.load(getClass().getResource("new_guest.fxml"));
    Stage newGuestStage = new Stage();
    newGuestStage.setTitle("Check Availability");
    newGuestStage.setScene(new Scene(root, 800, 600));
    newGuestStage.show();
  }

  @FXML
  void goToCurrentGuestPage(MouseEvent event) throws IOException {
    ((Node) (event.getSource())).getScene().getWindow().hide();
    Parent root = FXMLLoader.load(getClass().getResource("current_guest.fxml"));
    Stage logInStage = new Stage();
    logInStage.setTitle("Please Log In");
    logInStage.setScene(new Scene(root, 800, 600));
    logInStage.show();
  }

  @FXML
  void goToManagerLoginPage(MouseEvent event) throws IOException {
    ((Node) (event.getSource())).getScene().getWindow().hide();
    Parent root = FXMLLoader.load(getClass().getResource("manager_login.fxml"));
    Stage logInStage = new Stage();
    logInStage.setTitle("Please input manager credentials");
    logInStage.setScene(new Scene(root, 800, 600));
    logInStage.show();
  }

  // links Manager login page to the Manager Overview page
  @FXML
  void goToManagerOverview(MouseEvent mouseEvent) throws IOException {
    ((Node) (mouseEvent.getSource())).getScene().getWindow().hide();
    Parent root = FXMLLoader.load(getClass().getResource("manager_overview.fxml"));
    Stage logInStage = new Stage();
    logInStage.setTitle("Choose to View");
    logInStage.setScene(new Scene(root, 800, 600));
    logInStage.show();
  }
} // end of controller
