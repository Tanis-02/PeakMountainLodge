package resort;

/* Need to be done:
1. Compare dates chosen to dates guests are staying at the resort.
 */

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
import javafx.scene.control.DatePicker;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;

/** Everything in the DiningController corresponds to items on the dining.fxml file. */
public class DiningController {

  /** DatePicker watersideDatePicker sets the reservation for the Waterside restaurant. */
  @FXML private DatePicker watersideDatePicker;

  /** DatePicker underwaterDatePicker sets the reservation for the Underwater restaurant. */
  @FXML private DatePicker underwaterDatePicker;

  /** Combobox watersideGuests get the number of guests for the Waterside restaurant reservation. */
  @FXML private ComboBox<?> watersideGuests;

  /**
   * Combobox underwaterGuests get the number of guests for the Underwater restaurant reservation.
   */
  @FXML private ComboBox<?> underwaterGuests;

  /**
   * The initialize() function is used to initialize the number of guests in the reservation combo
   * boxes.
   */
  public void initialize() {
    List<Integer> numbers = new ArrayList<>();
    for (int i = 1; i <= 5; i++) {
      numbers.add(i);
    }
    ObservableList numberList = FXCollections.observableList(numbers);
    watersideGuests.getItems().clear();
    watersideGuests.setItems(numberList);
    watersideGuests.getSelectionModel().selectFirst();
    underwaterGuests.getItems().clear();
    underwaterGuests.setItems(numberList);
    underwaterGuests.getSelectionModel().selectFirst();
  }

  /**
   * The goToWaterSideConfirmationPage() shows a confirmation message with the date and number of
   * guests going to the Waterside restaurant.
   */
  @FXML
  void goToWaterSideConfirmationPage() {
    if (watersideDatePicker.getValue() == null) {
      Alert error = new Alert(AlertType.ERROR);
      error.setContentText("Please select an appropriate date.");
      error.show();
    } else {
      Alert confirmation = new Alert(AlertType.CONFIRMATION);
      confirmation.setContentText(
          "Your dinner reservation for party of "
              + watersideGuests.getSelectionModel().getSelectedItem().toString()
              + " has been submitted! We here at Waterside are looking forward to your arrival on "
              + watersideDatePicker.getValue().toString()
              + ".");
      confirmation.show();
    }
  }

  /**
   * The goToUnderWaterConfirmationPage() shows a confirmation message with the date and number of
   * guests going to the UnderWater restaurant.
   */
  @FXML
  void goToUnderWaterConfirmationPage() {
    if (underwaterDatePicker.getValue() == null) {
      Alert error = new Alert(AlertType.ERROR);
      error.setContentText("Please select an appropriate date.");
      error.show();
    } else {
      Alert confirmation = new Alert(AlertType.CONFIRMATION);
      confirmation.setContentText(
          "Your dinner reservation for party of "
              + underwaterGuests.getSelectionModel().getSelectedItem().toString()
              + " has been submitted! We here at UnderWater are looking forward to your arrival on "
              + underwaterDatePicker.getValue().toString()
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
        FXMLLoader.load(getClass().getResource("current_guest_options.fxml"));
    Scene currentGuestOptionsScene = new Scene(currentGuestOptionsParent);
    Stage currentGuestOptionsStage = (Stage) ((Node) event.getSource()).getScene().getWindow();
    currentGuestOptionsStage.setScene(currentGuestOptionsScene);
    currentGuestOptionsStage.show();
  }
}
