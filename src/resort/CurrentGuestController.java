package resort;

import java.io.IOException;
import java.sql.SQLException;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;

/**
 * Everything in the CurrentGuestController corresponds to items on the current_guest.fxml file
 */
public class CurrentGuestController {

  /**
   * Text field to get the user's last name to compare against the database records.
   */
  @FXML
  private TextField lastName;

  /**
   * Text field to get the user's phone number to compare against the database records.
   */
  @FXML
  private TextField phoneNumber;

  /**
   * Label to prompt the user to try again in the event an invalid login attempt is made.
   */
  @FXML
  private Label badGuestInput;

  /**
   * The goToCurrentGuestOptionsPage() function is used to check the conditions of the lastName and
   * phoneNumber text fields to the values stored in the database. If either the phone number or
   * last name don't match a record in the database, it will display an error message. If both the
   * last name and phone are successful, it will open to the current_guest_options page. Guest and
   * 1234567890 are placeholders for valid name and number combinations pulled from a database.
   */
  @FXML
  void goToCurrentGuestOptionsPage(MouseEvent event) throws IOException, SQLException {
    ConnManager connManager = new ConnManager();
    if (!lastName.getText().equals("")
        && !phoneNumber.getText().equals("")
        && connManager.verifyGuestLogin(lastName.getText(), phoneNumber.getText())) {
      FXMLLoader greetLoader = new FXMLLoader(getClass().getResource(
          "fxml_files/current_guest_options.fxml"));
      Parent currentGuestOptionsParent = greetLoader.load();
      CurrentGuestOptionsController controller = greetLoader.getController();
      controller.setFamilyName(lastName.getText());
      Scene currentGuestOptionsScene = new Scene(currentGuestOptionsParent);
      Stage currentGuestOptionsStage = (Stage) ((Node) event.getSource()).getScene().getWindow();
      currentGuestOptionsStage.setScene(currentGuestOptionsScene);
      currentGuestOptionsStage.show();
    } else {
      badGuestInput.setText("Bad Login Attempt - Try Again");
    }
  }

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
}
