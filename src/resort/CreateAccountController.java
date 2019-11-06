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
import javafx.scene.control.CheckBox;
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

  /** Check box to receive the user's permission to send a confirmation email to them. */
  @FXML private CheckBox confirmation;

  /** Check box to receive the user's permission to send promotional emails to them. */
  @FXML private CheckBox promotions;

  public void initialize() {
    ObservableList<String> option =
        FXCollections.observableArrayList(
            "United States", "Canada", "France", "Germany", "United Kingdom");
    region.setItems(option);
    region.getSelectionModel();
  }

  @FXML
  void goToCheckoutPage(MouseEvent event) throws IOException, SQLException {
    if (firstName.getText().equalsIgnoreCase("")
        || lastName.getText().equalsIgnoreCase("")
        || phoneNumber.getText().equalsIgnoreCase("")
        || email.getText().equalsIgnoreCase("")
        || address.getText().equalsIgnoreCase("")
        || zipCode.getText().equalsIgnoreCase("")
        || password.getText().equalsIgnoreCase("")
        || region.getSelectionModel().getSelectedItem().equalsIgnoreCase("Country/Region")) {
      Alert error = new Alert(AlertType.ERROR);
      error.setContentText("Please fill out all fields and choose an appropriate region.");
      error.show();
    } else {
      Parent checkoutParent = FXMLLoader.load(getClass().getResource("checkout.fxml"));
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
