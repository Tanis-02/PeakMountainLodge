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
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;

/**
 * Everything in the SpecialRequestsController corresponds to items in the special_request.fxml
 * file.
 */
public class SpecialRequestsController {

  /** ComboBox typeOfBedding is the type of bedding that the customer can request. */
  @FXML private ComboBox<String> typeOfBedding;

  /** ComboBox quantityOfBedding is how much of the type of bedding the customer can request. */
  @FXML private ComboBox<Integer> quantityOfBedding;

  /** ComboBox typeOfToiletry is the type of toiletry that the customer can request. */
  @FXML private ComboBox<String> typeOfToiletry;

  /** ComboBox quantityOfToiletry is how much of the type of toiletry the customer can request. */
  @FXML private ComboBox<Integer> quantityOfToiletry;

  /** TextField message will be used to get the message the guest writes for special requests. */
  @FXML private TextField message;

  /**
   * The initialize() function initializes the combo boxes with the values for the quantities of
   * items being requested. Will be added to later to include the actual items being requested.
   */
  public void initialize() {
    ObservableList<String> toiletries =
        FXCollections.observableArrayList(
            "Shampoo", "Conditioner", "Body Wash", "Lotion", "Hand Towel", "Bath Towel");
    ObservableList<String> bedding =
        FXCollections.observableArrayList(
            "Feather Pillow", "Regular Pillow", "Down Comforter", "Sheets");
    typeOfToiletry.getItems().clear();
    typeOfToiletry.setItems(toiletries);
    typeOfToiletry.getSelectionModel().selectFirst();
    typeOfBedding.getItems().clear();
    typeOfBedding.setItems(bedding);
    typeOfBedding.getSelectionModel().selectFirst();
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
   * The goToToiletryConfirmationPage() displays a confirmation of the special request item and
   * quantity for toiletry items.
   */
  @FXML
  void goToBeddingConfirmationPage() {
    if (quantityOfBedding.getSelectionModel().getSelectedItem().toString().equals("1")) {
      Alert confirmation = new Alert(AlertType.CONFIRMATION);
      confirmation.setContentText(
          "Your request of "
              + quantityOfBedding.getSelectionModel().getSelectedItem().toString()
              + " "
              + typeOfBedding.getSelectionModel().getSelectedItem()
              + " has been received. We will see you soon!");
      confirmation.show();
    } else {
      Alert confirmation = new Alert(AlertType.CONFIRMATION);
      confirmation.setContentText(
          "Your request of "
              + quantityOfBedding.getSelectionModel().getSelectedItem().toString()
              + " "
              + typeOfBedding.getSelectionModel().getSelectedItem()
              + "s has been received. We will see you soon!");
      confirmation.show();
    }
  }

  /**
   * The goToToiletryConfirmationPage() displays a confirmation of the special request item and
   * quantity for toiletry items.
   */
  @FXML
  void goToToiletryConfirmationPage() {
    if (quantityOfToiletry.getSelectionModel().getSelectedItem().toString().equalsIgnoreCase("1")) {
      Alert confirmation = new Alert(AlertType.CONFIRMATION);
      confirmation.setContentText(
          "Your request of "
              + quantityOfToiletry.getSelectionModel().getSelectedItem().toString()
              + " "
              + typeOfToiletry.getSelectionModel().getSelectedItem()
              + " has been received. We will see you soon!");
      confirmation.show();
    } else {
      Alert confirmation = new Alert(AlertType.CONFIRMATION);
      confirmation.setContentText(
          "Your request of "
              + quantityOfToiletry.getSelectionModel().getSelectedItem().toString()
              + " "
              + typeOfToiletry.getSelectionModel().getSelectedItem()
              + "s has been received. We will see you soon!");
      confirmation.show();
    }
  }

  /**
   * The sendMessage() function will display a confirmation of receipt of the guest's message. The
   * message will be relayed back to the customer to show correctness.
   */
  @FXML
  void sendMessage() {
    if (message.getText().equals("")) {
      Alert error = new Alert(AlertType.ERROR);
      error.setContentText("Please enter a message.");
      error.show();
    } else {
      String messageSent = message.getText();
      Alert confirmation = new Alert(AlertType.CONFIRMATION);
      confirmation.setContentText(
          "Your message of \"" + messageSent + "\" has been sent! We will contact you shortly.");
      confirmation.show();
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
    Parent currentGuestOptionsParent =
        FXMLLoader.load(getClass().getResource("current_guest_options.fxml"));
    Scene currentGuestOptionsScene = new Scene(currentGuestOptionsParent);
    Stage currentGuestOptionsStage = (Stage) ((Node) event.getSource()).getScene().getWindow();
    currentGuestOptionsStage.setScene(currentGuestOptionsScene);
    currentGuestOptionsStage.show();
  }
}
