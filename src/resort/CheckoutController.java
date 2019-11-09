package resort;

/* Needs to be done:
1. Fix hierarchy in SceneBuilder with ImageView/Image
2. Update items in the database based off payment
3. Create a reservation ID once payment has been submitted
 */

import java.io.IOException;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;

/** Everything in the CheckoutController corresponds to items in the checkout.fxml file. */
public class CheckoutController {

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

  public void initialize() {
    ObservableList<String> option =
        FXCollections.observableArrayList(
            "Visa", "MasterCard", "American Express", "Capital One", "Chase");
    comboboxCardType.setItems(option);
    comboboxCardType.getSelectionModel();
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
