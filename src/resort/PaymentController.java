package resort;

import java.io.IOException;
import java.util.Optional;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.ButtonType;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;

/**
 * The payment controller is used to gather the payment information from the guest and confirm their
 * visit.
 */
public class PaymentController {

  /**
   * The card type combo box is used to display the accepted credit cards.
   */
  @FXML
  private ComboBox<String> cardType;

  /**
   * The CCN text field is used to gather the credit card number of the guest. It must be 16 digits
   * in length.
   */
  @FXML
  private TextField CCN;

  /**
   * The expiration date text field is used to gather the expiration date of the credit card. It
   * must be in the following format: xx/xx.
   */
  @FXML
  private TextField expirationDate;

  /**
   * The CVC text field is used to gather the CVC number of the credit card. It must be 3 digits in
   * length.
   */
  @FXML
  private TextField CVCode;

  /**
   * The name on card text field gathers the name of the credit card owner.
   */
  @FXML
  private TextField nameOnCard;

  /**
   * The initialize() method is used to set the values for the card type combo box.
   */
  public void initialize() {
    ObservableList<String> creditCards =
        FXCollections.observableArrayList(
            "Visa", "MasterCard", "American Express", "Capital One", "Chase");
    cardType.setItems(creditCards);
    cardType.getSelectionModel().selectFirst();
  }

  /**
   * The goToHomePage() directs the customer to the home page after confirmation of their
   * reservation. All fields must be filled out properly and confirmed before submission.
   *
   * @param event mouse click event
   * @throws IOException yes, it does
   */
  @FXML
  void goToHomePage(MouseEvent event) throws IOException {
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
      Optional<ButtonType> result = confirmation.showAndWait();
      ButtonType button = result.orElse(ButtonType.CANCEL);
      if (button == ButtonType.OK) {
        confirmation.setContentText(
            "Welcome to your exclusive vacation! Thank you " + nameOnCard.getText() + ".");
        confirmation.show();
        Parent homeParent = FXMLLoader.load(getClass().getResource("fxml_files/home.fxml"));
        Scene homeScene = new Scene(homeParent);
        Stage homeStage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        homeStage.setScene(homeScene);
        homeStage.show();
      } else {
        confirmation.setContentText("Canceling reservation.");
        confirmation.show();
      }
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
