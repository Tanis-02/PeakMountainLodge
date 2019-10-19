package resort;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
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
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;

/**
 * Everything in the SpecialRequestsController corresponds to items in the special_request.fxml
 * file.
 */
public class SpecialRequestsController {

  /** ComboBox typeOfBedding is the type of bedding that the customer can request. */
  @FXML private ComboBox<?> typeOfBedding;

  /** ComboBox quantityOfBedding is how much of the type of bedding the customer can request. */
  @FXML private ComboBox<?> quantityOfBedding;

  /** ComboBox typeOfToiletry is the type of toiletry that the customer can request. */
  @FXML private ComboBox<?> typeOfToiletry;

  /** ComboBox quantityOfToiletry is how much of the type of toiletry the customer can request. */
  @FXML private ComboBox<?> quantityOfToiletry;

  /**
   * The initialize() function initializes the combo boxes with the values for the quantities of
   * items being requested. Will be added to later to include the actual items being requested.
   */
  public void initialize() {
    List<Integer> numbers = new ArrayList<>();
    for (int i = 1; i <= 5; i++) {
      numbers.add(i);
    }
    ObservableList numberList = FXCollections.observableList(numbers);
    quantityOfBedding.getItems().clear();
    quantityOfBedding.setItems(numberList);
    quantityOfBedding.getSelectionModel().selectFirst();
    quantityOfToiletry.getItems().clear();
    quantityOfToiletry.setItems(numberList);
    quantityOfToiletry.getSelectionModel().selectFirst();
  }

  /**
   * The goToConfirmationPage() right now just displays an alert rather than an actual scene. Will
   * be updated later with actual scene.
   *
   * @param event opens the confirmation alert to confirm to the customer the action they made
   */
  @FXML
  void goToConfirmationPage(MouseEvent event) {
    Alert confirmation = new Alert(AlertType.CONFIRMATION);
    confirmation.setContentText("Your special request has been submitted!");
    confirmation.show();
  }

  /**
   * The sendMessage() function right now just displays an alert rather than an actual scene. Will
   * be updated later with actual scene.
   *
   * @param event opens the confirmation alert to confirm to the customer the action they made
   */
  @FXML
  void sendMessage(MouseEvent event) {
    Alert confirmation = new Alert(AlertType.CONFIRMATION);
    confirmation.setContentText("Your message has been sent! We will contact you shortly.");
    confirmation.show();
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
    Parent root = FXMLLoader.load(getClass().getResource("current_guest_options.fxml"));
    Stage home = new Stage();
    home.setTitle("Please choose an option");
    home.setScene(new Scene(root, 800, 600));
    home.show();
  }
}
