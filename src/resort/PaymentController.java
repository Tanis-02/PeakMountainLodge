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
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;

/** Everything in the PaymentController corresponds to items in the payment.fxml file. */
public class PaymentController {

  @FXML
  private Label labelPayment;

  @FXML
  private Label labelPaymentDetails;

  @FXML
  private ComboBox<String> comboboxCardType;

  @FXML
  private Label labelCreditCardNumber;

  @FXML
  private TextField txtfieldCardNumber;

  @FXML
  private Label labelExpirationDate;

  @FXML
  private TextField txtfieldExpirationDate;

  @FXML
  private Label labelCVCode;

  @FXML
  private TextField txtfieldCVCode;

  @FXML
  private Label labelNameOnCard;

  @FXML
  private TextField txtfieldNameOnCard;

  public void initialize() {
    ObservableList<String> option =
        FXCollections.observableArrayList(
            "Visa", "MasterCard", "American Express", "Capital One", "Chase");
    comboboxCardType.setItems(option);
    comboboxCardType.getSelectionModel();
  }

  @FXML
  void goToCheckoutPage(MouseEvent event) throws IOException, SQLException {
    if (txtfieldCardNumber.getText().equalsIgnoreCase("")
        || txtfieldExpirationDate.getText().equalsIgnoreCase("")
        || txtfieldCVCode.getText().equalsIgnoreCase("")
        || txtfieldNameOnCard.getText().equalsIgnoreCase("")
        || comboboxCardType.getSelectionModel().getSelectedItem().equalsIgnoreCase("Card Type")) {
      Alert error = new Alert(AlertType.ERROR);
      error.setContentText("Please fill out all fields and choose an appropriate region.");
      error.show();
    } else {
      Parent checkoutParent = FXMLLoader.load(getClass().getResource("special_requests.fxml"));
      Scene checkoutScene = new Scene(checkoutParent);
      Stage checkoutStage = (Stage) ((Node) event.getSource()).getScene().getWindow();
      checkoutStage.setScene(checkoutScene);
      checkoutStage.show();
      String[] details = new String[5];
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
    Parent createAccountParent = FXMLLoader.load(getClass().getResource("create_account.fxml"));
    Scene createAccountScene = new Scene(createAccountParent);
    Stage createAccountStage = (Stage) ((Node) event.getSource()).getScene().getWindow();
    createAccountStage.setScene(createAccountScene);
    createAccountStage.show();
  }

}