package resort;

import java.io.IOException;
import java.sql.SQLException;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.ComboBox;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;

/**
 * Everything in the CreateAccountController corresponds to items on the create_account.fxml file.
 */
public class CreateAccountController {

  /** Text field to insert the user's first name into the database. */
  @FXML private TextField firstName;

  /** Text field to insert the user's last name into the database. */
  @FXML private TextField lastName;

  /** Text field to insert the user's phone number into the database. */
  @FXML private TextField phoneNumber;

  /** Text field to insert the user's email into the database. */
  @FXML private TextField email;

  /** Combo box to allow the user to choose from which region they are from. */
  @FXML private ComboBox<String> region;

  /** Text field to insert the user's address into the database. */
  @FXML private TextField address;

  /** Text field to insert the user's zip code into the database. */
  @FXML private TextField zipCode;

  /** Text field to insert the user's password into the database. */
  @FXML private PasswordField password;

  public void initialize() {
    ObservableList<String> option =
        FXCollections.observableArrayList(
            "United States", "Canada", "France", "Germany", "United Kingdom");
    region.setItems(option);
    region.getSelectionModel().selectFirst();
  }

  @FXML
  void goToCheckoutPage(MouseEvent event) throws IOException, SQLException {
    if (firstName.getText().equalsIgnoreCase("")) {
      Alert error = new Alert(AlertType.ERROR);
      error.setContentText("Please provide a first name.");
      error.show();
    } else if (lastName.getText().equalsIgnoreCase("")) {
      Alert error = new Alert(AlertType.ERROR);
      error.setContentText("Please provide a last name.");
      error.show();
    } else if (phoneNumber.getText().equalsIgnoreCase("")
        || phoneNumber.getLength() < 7
        || phoneNumber.getLength() > 7) {
      Alert error = new Alert(AlertType.ERROR);
      error.setContentText("Phone numbers must in the form of 1234567. No dashes, please.");
      error.show();
    } else if (email.getText().equalsIgnoreCase("")) {
      Alert error = new Alert(AlertType.ERROR);
      error.setContentText("Please provide an email.");
      error.show();
    } else if (address.getText().equalsIgnoreCase("")) {
      Alert error = new Alert(AlertType.ERROR);
      error.setContentText("Please provide an address.");
      error.show();
    } else if (zipCode.getText().equalsIgnoreCase("")
        || zipCode.getLength() > 5
        || zipCode.getLength() < 5) {
      Alert error = new Alert(AlertType.ERROR);
      error.setContentText("Please provide a zip code with 5 numbers.");
      error.show();
    } else if (password.getText().equalsIgnoreCase("")) {
      Alert error = new Alert(AlertType.ERROR);
      error.setContentText("Please enter a password.");
      error.show();
    } else {
      Parent checkoutParent = FXMLLoader.load(getClass().getResource("payment.fxml"));
      Scene checkoutScene = new Scene(checkoutParent);
      Stage checkoutStage = (Stage) ((Node) event.getSource()).getScene().getWindow();
      checkoutStage.setScene(checkoutScene);
      checkoutStage.show();
      String[] details = new String[5];
      ConnManager connManager = new ConnManager();
      details[0] = email.getText();
      details[1] = firstName.getText();
      details[2] = lastName.getText();
      details[3] = phoneNumber.getText();
      details[4] = "1234";
      connManager.insertCustomer(details);
    }
  }

  /**
   * Universal goToPreviousPage() function is used to bring the user to the previous page they were
   * on. It will be used across almost all screens.
   *
   * @throws IOException yes, it does
   */
  @FXML
  void goToPreviousPage(MouseEvent event) throws IOException {
    Parent availableRoomsParent = FXMLLoader.load(getClass().getResource("available_rooms.fxml"));
    Scene availableRoomsScene = new Scene(availableRoomsParent);
    Stage availableRoomsStage = (Stage) ((Node) event.getSource()).getScene().getWindow();
    availableRoomsStage.setScene(availableRoomsScene);
    availableRoomsStage.show();
  }
}
