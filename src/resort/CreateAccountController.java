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
 * The create account controller gathers the guest's details and plugs them into the customer
 * database.
 */
public class CreateAccountController extends CustomerDriver {

  /**
   * The text field to gather the guest's first name and insert it into the database.
   */
  @FXML
  private TextField firstName;

  /**
   * The text field to gather the guest's last name and insert it into the database.
   */
  @FXML
  private TextField lastName;

  /**
   * The text field to gather the guest's phone number and insert it into the database.
   */
  @FXML
  private TextField phoneNumber;

  /**
   * The text field to gather the guest's email and insert it into the database.
   */
  @FXML
  private TextField email;

  /**
   * The region combo box is used to allow the user to choose from which region they are from.
   */
  @FXML
  private ComboBox<String> region;

  /**
   * The text field to gather the guest's address and insert it into the database.
   */
  @FXML
  private TextField address;

  /**
   * The text field to gather the guest's zip code and insert it into the database.
   */
  @FXML
  private TextField zipCode;

  /**
   * The text field to gather the guest's password and insert it into the database.
   */
  @FXML
  private PasswordField password;

  /**
   * The initialize() method is used to set the values in the region combo box.
   */
  public void initialize() {
    ObservableList<String> option =
        FXCollections.observableArrayList(
            "United States", "Canada", "France", "Germany", "United Kingdom");
    region.setItems(option);
    region.getSelectionModel().selectFirst();
  }

  /**
   * The goToCheckOutPage() method goes to the payment screen and inserts the customer details into
   * the database. If all fields are filled out correctly, that is. All fields must be filled out
   * and in the proper way. The phone number must be in the form of xxxxxxx with no dashes or
   * spaces. The zip code must also be 5 digits in length.
   *
   * @param event mouse click
   * @throws IOException  yes, it does
   * @throws SQLException yes, it does
   */
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
      Parent checkoutParent = FXMLLoader.load(getClass().getResource("fxml_files/payment.fxml"));
      Scene checkoutScene = new Scene(checkoutParent);
      Stage checkoutStage = (Stage) ((Node) event.getSource()).getScene().getWindow();
      checkoutStage.setScene(checkoutScene);
      checkoutStage.show();
      String[] details = new String[5];
      details[0] = email.getText();
      details[1] = firstName.getText();
      details[2] = lastName.getText();
      details[3] = phoneNumber.getText();
      details[4] = "3456";
      ConnManager connManager = new ConnManager();
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
    Parent availableRoomsParent = FXMLLoader.load(getClass().getResource(
        "fxml_files/available_rooms.fxml"));
    Scene availableRoomsScene = new Scene(availableRoomsParent);
    Stage availableRoomsStage = (Stage) ((Node) event.getSource()).getScene().getWindow();
    availableRoomsStage.setScene(availableRoomsScene);
    availableRoomsStage.show();
  }
}
