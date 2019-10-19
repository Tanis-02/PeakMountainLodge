package resort;

import java.io.IOException;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;

/** Everything in the CurrentGuestController corresponds to items on the current_guest.fxml file */
public class CurrentGuestController {

  /** Text field to get the user's last name to compare against the database records. */
  @FXML private TextField lastName;

  /** Text field to get the user's phone number to compare against the database records. */
  @FXML private TextField phoneNumber;

  /** Label to prompt the user to try again in the event an invalid login attempt is made. */
  @FXML private Label badGuestInput;

  /**
   * The goToCurrentGuestOptionsPage() function is used to check the conditions of the lastName and
   * phoneNumber text fields to the values stored in the database. If either the phone number or
   * last name don't match a record in the database, it will display an error message. If both the
   * last name and phone are successful, it will open to the current_guest_options page. Guest and
   * 1234567890 are placeholders for valid name and number combinations pulled from a database.
   */
  @FXML
  void goToCurrentGuestOptionsPage(MouseEvent event) throws IOException {
    if (lastName.getText().equalsIgnoreCase("Guest")
        && phoneNumber.getText().equals("1234567890")) {
      ((Node) (event.getSource())).getScene().getWindow().hide();
      FXMLLoader greetLoader = new FXMLLoader(getClass().getResource("current_guest_options.fxml"));
      Parent root = greetLoader.load();
      CurrentGuestOptionsController controller = greetLoader.getController();
      controller.setFamilyName(lastName.getText());
      Stage options = new Stage();
      options.setTitle("Please choose an option");
      options.setScene(new Scene(root, 800, 600));
      options.show();
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
    ((Node) (event.getSource())).getScene().getWindow().hide();
    Parent root = FXMLLoader.load(getClass().getResource("home.fxml"));
    Stage home = new Stage();
    home.setTitle("Welcome");
    home.setScene(new Scene(root, 800, 600));
    home.show();
  }
}
