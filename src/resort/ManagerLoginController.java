package resort;

import java.io.IOException;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;

/** Everything in the ManagerLoginController corresponds to items on the manager_login.fxml file */
public class ManagerLoginController {

  /** Text field managerID to get the user's ID to compare against the database records */
  @FXML private TextField managerID;

  /**
   * Text field managerPassword to get the user's password to compare against the database records
   */
  @FXML private PasswordField managerPassword;

  /**
   * Universal goToPreviousPage() function is used to bring the user to the previous page they were
   * on. It will be used across almost all screens.
   *
   * @param event MouseEvent upon clicking the back button
   * @throws IOException yes, it does
   */
  @FXML
  void goToPreviousPage(MouseEvent event) throws IOException {
    ((Node) (event.getSource())).getScene().getWindow().hide();
    Parent root = FXMLLoader.load(getClass().getResource("home.fxml"));
    Stage home = new Stage();
    home.setTitle("Welcome");
    home.setScene(new Scene(root, 800, 600));
    home.show();
  }

  /**
   * The goToManagerOverview() function is used to check the conditions of the managerID and
   * managerPassword text fields to the values stored in the database. If either the ID or password
   * don't match a record in the database, it will display an error message. If both the ID and
   * password are successful, it will open to the manager overview page.
   */
  @FXML
  void goToManagerOverview(MouseEvent mouseEvent) throws IOException {
    ((Node) (mouseEvent.getSource())).getScene().getWindow().hide();
    Parent root = FXMLLoader.load(getClass().getResource("manager_overview.fxml"));
    Stage logInStage = new Stage();
    logInStage.setTitle("Choose to View");
    logInStage.setScene(new Scene(root, 800, 600));
    logInStage.show();
  }
}
