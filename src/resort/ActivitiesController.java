package resort;

/* Needs to be done:
1. Compare dates chosen to dates guests are staying at the resort.
2. Compare number of guests signing up for activity to number of guests in party.
 */

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
 * Everything in ActivitiesController corresponds to items in the activities.fxml file.
 */
public class ActivitiesController {

  /**
   * ChoiceBox numberOfGuestsRental is used to put how many people are registering for the rental.
   */
  @FXML
  private ChoiceBox<Integer> numberOfGuestsRental;

  /**
   * DatePicker rentalDatePicker is used to select a date during their stay to use the rental.
   */
  @FXML
  private DatePicker rentalDatePicker;

  /**
   * DatePicker snorkelingDatePicker is used to select a date during their stay to go snorkeling.
   */
  @FXML
  private DatePicker snorkelingDatePicker;

  /**
   * ChoiceBox numberOfGuestsSnorkeling is used to to put how many people are registering for the
   * snorkeling tour.
   */
  @FXML
  private ChoiceBox<Integer> numberOfGuestsSnorkeling;

  /**
   * The initialize() function is used to initialize the number of guests in the rental and
   * snorkeling combo boxes.
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
   * activity. It must have both the date and number of guests selected and the date must be within
   * their stay which is checked with the database.
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
   * The goToSnorkelingConfirmationPage() method will go to the confirmation page to confirm the
   * guest's activity. It must have both the date and number of guests selected and the date must be
   * within their stay which is checked with the database.
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
