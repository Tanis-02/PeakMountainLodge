package resort;

import java.io.IOException;
import java.sql.SQLException;
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
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.DatePicker;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;

/**
 * The activities controller is used by the guest to book activities during their resort stay.
 * Currently, the only available activities are water rentals and snorkeling.
 */
public class ActivitiesController {

  /**
   * The number of guests rental choice box is used to select how many guests are registering for a
   * water rental.
   */
  @FXML
  private ChoiceBox<Integer> numberOfGuestsRental;

  /**
   * The rental date picker is used to select a date during the guest's stay to reserve a water
   * rental.
   */
  @FXML
  private DatePicker rentalDatePicker;

  /**
   * The snorkeling date picker is used to select a date during the guest's stay to reserve a
   * snorkeling tour.
   */
  @FXML
  private DatePicker snorkelingDatePicker;

  /**
   * The number of guests snorkeling choice box is used to to select how many guests are registering
   * for the snorkeling tour.
   */
  @FXML
  private ChoiceBox<Integer> numberOfGuestsSnorkeling;

  /**
   * The initialize() method is used to initialize the number of guests in the rental and snorkeling
   * choice boxes.
   */
  public void initialize() {
    List<Integer> numbers = new ArrayList<>();
    for (int i = 1; i <= 5; i++) {
      numbers.add(i);
    }
    ObservableList<Integer> numberList = FXCollections.observableList(numbers);
    numberOfGuestsRental.getItems().clear();
    numberOfGuestsRental.setItems(numberList);
    numberOfGuestsRental.getSelectionModel().selectFirst();
    numberOfGuestsSnorkeling.getItems().clear();
    numberOfGuestsSnorkeling.setItems(numberList);
    numberOfGuestsSnorkeling.getSelectionModel().selectFirst();
  }

  /**
   * The goToRentalConfirmationPage() method will go to the confirmation page to confirm the guest's
   * activity.The date picker and choice box must have been selected or an error message will be
   * shown to the user. If both are selected, the user will be shown a confirmation message
   * displaying the date, activity, and number of guests.
   */
  @FXML
  void goToRentalConfirmationPage() throws SQLException {
    if (rentalDatePicker.getValue() == null) {
      Alert error = new Alert(AlertType.ERROR);
      error.setContentText("Please choose an appropriate date.");
      error.show();
    } else {
      Alert confirmation = new Alert(AlertType.CONFIRMATION);
      confirmation.setContentText(
          "Your party of "
              + numberOfGuestsRental.getSelectionModel().getSelectedItem().toString()
              + " has been confirmed. We look forward to seeing you on "
              + rentalDatePicker.getValue().toString()
              + ".");
      confirmation.show();
      ConnManager connManager = new ConnManager();
      connManager.insertActivities(
          rentalDatePicker.getValue().toString(), numberOfGuestsRental.getValue());
    }
  }

  /**
   * The goToSnorkelingPage() method will go to the confirmation page to confirm the guest's
   * activity.The date picker and choice box must have been selected or an error message will be
   * shown to the user. If both are selected, the user will be shown a confirmation message
   * displaying the date, activity, and number of guests.
   */
  @FXML
  void goToSnorkelingConfirmationPage() {
    if (snorkelingDatePicker.getValue() == null) {
      Alert error = new Alert(AlertType.ERROR);
      error.setContentText("Please choose an appropriate date.");
      error.show();
    } else {
      Alert confirmation = new Alert(AlertType.CONFIRMATION);
      confirmation.setContentText(
          "Your party of "
              + numberOfGuestsSnorkeling.getSelectionModel().getSelectedItem().toString()
              + " has been confirmed. We look forward to seeing you on "
              + snorkelingDatePicker.getValue().toString()
              + ".");
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
        FXMLLoader.load(getClass().getResource("fxml_files/current_guest_options.fxml"));
    Scene currentGuestOptionsScene = new Scene(currentGuestOptionsParent);
    Stage currentGuestOptionsStage = (Stage) ((Node) event.getSource()).getScene().getWindow();
    currentGuestOptionsStage.setScene(currentGuestOptionsScene);
    currentGuestOptionsStage.show();
  }
}
