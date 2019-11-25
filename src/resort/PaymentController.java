package resort;

/* Needs to be done:
1. Check functionality
2. Store the last 4 of the CCN into the database.
 */

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
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;

/** Everything in the PaymentController corresponds to items in the payment.fxml file. */
public class PaymentController {

  @FXML private ComboBox<String> cardType;

  @FXML private TextField CCN;

  @FXML private TextField expirationDate;

  @FXML private TextField CVCode;

  @FXML private TextField nameOnCard;

  public PaymentController() {}

  public void initialize() {
    ObservableList<String> creditCards =
        FXCollections.observableArrayList(
            "Visa", "MasterCard", "American Express", "Capital One", "Chase");
    cardType.setItems(creditCards);
    cardType.getSelectionModel().selectFirst();
  }

  @FXML
  void goToHomePage(MouseEvent event) throws IOException, SQLException {
    if (CCN.getText().equalsIgnoreCase("") || CCN.getLength() < 16 || CCN.getLength() > 16) {
      Alert error = new Alert(AlertType.ERROR);
      error.setContentText("Credit card number must have 16 numbers.");
      error.show();
    } else if (expirationDate.getText().equalsIgnoreCase("")
        || expirationDate.getLength() < 5
        || expirationDate.getLength() > 5) {
      Alert error = new Alert(AlertType.ERROR);
      error.setContentText("Expiration date must be in the form of xx/xx");
      error.show();
    } else if (CVCode.getText().equalsIgnoreCase("")
        || CVCode.getLength() < 3
        || CVCode.getLength() > 3) {
      Alert error = new Alert(AlertType.ERROR);
      error.setContentText("CVC must contain 3 digits");
      error.show();
    } else if (nameOnCard.getText().equalsIgnoreCase("")) {
      Alert error = new Alert(AlertType.ERROR);
      error.setContentText("Please provide a name.");
      error.show();
    } else {
      Alert confirmation = new Alert(AlertType.CONFIRMATION);
      confirmation.setContentText(
          "Welcome to your exclusive vacation! Thank you " + nameOnCard.getText() + ".");
      confirmation.show();
      Parent homeParent = FXMLLoader.load(getClass().getResource("fxml_files/home.fxml"));
      Scene homeScene = new Scene(homeParent);
      Stage homeStage = (Stage) ((Node) event.getSource()).getScene().getWindow();
      homeStage.setScene(homeScene);
      homeStage.show();
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
    Parent createAccountParent = FXMLLoader.load(getClass().getResource(
        "fxml_files/create_account.fxml"));
    Scene createAccountScene = new Scene(createAccountParent);
    Stage createAccountStage = (Stage) ((Node) event.getSource()).getScene().getWindow();
    createAccountStage.setScene(createAccountScene);
    createAccountStage.show();
  }
}
