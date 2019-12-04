package resort;

import java.io.IOException;
import java.sql.SQLException;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;

/**
 * The manager login screen allows the manager to login to the manager view screen.
 */
public class ManagerLoginController {

  /**
   * The text field to get the user's ID to compare against the database records.
   */
  @FXML
  private TextField managerID;

  /**
   * The text field to get the user's password to compare against the database records.
   */
  @FXML
  private PasswordField managerPassword;

  /**
   * The label to prompt the user to try again in the event an invalid login attempt is made.
   */
  @FXML
  private Label badManagerInput2;

  /**
   * Universal goToPreviousPage() function is used to bring the user to the previous page they were
   * on. It will be used across almost all screens.
   *
   * @param event MouseEvent upon clicking the back button
   * @throws IOException yes, it does
   */
  @FXML
  void goToPreviousPage(MouseEvent event) throws IOException {
    Parent homeParent = FXMLLoader.load(getClass().getResource("fxml_files/home.fxml"));
    Scene homeScene = new Scene(homeParent);
    Stage homeStage = (Stage) ((Node) event.getSource()).getScene().getWindow();
    homeStage.setScene(homeScene);
    homeStage.show();
  }

  /**
   * The goToManagerOverview() function is used to check the conditions of the managerID and
   * managerPassword text fields to the values stored in the database. If either the ID or password
   * don't match a record in the database, it will display an error message. If both the ID and
   * password are successful, it will open to the manager overview page. Cavallaro and 512560 are
   * placeholders for valid manager ID and password combinations pulled from a database.
   */
  @FXML
  void goToManagerOverview(MouseEvent event) throws IOException, SQLException {
    ConnManager connManager = new ConnManager();
    if (!managerID.getText().equals("")
        && !managerPassword.getText().equals("")
        && connManager.verifyManagerLogin(managerID.getText(), managerPassword.getText())) {
      Parent managerOverviewParent =
          FXMLLoader.load(getClass().getResource("fxml_files/manager_overview.fxml"));
      Scene managerOverviewScene = new Scene(managerOverviewParent);
      Stage managerOverviewStage = (Stage) ((Node) event.getSource()).getScene().getWindow();
      managerOverviewStage.setScene(managerOverviewScene);
      managerOverviewStage.show();
    } else {
      badManagerInput2.setText("Bad Login Attempt - Try Again");
    }
  }
}
