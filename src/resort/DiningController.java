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
import javafx.scene.control.DatePicker;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;

/**
 * The dining controller shows the guest the available places to dine at the resort.
 */
public class DiningController {

  /**
   * The Waterside date picker sets the reservation for the Waterside restaurant.
   */
  @FXML
  private DatePicker watersideDatePicker;

  /**
   * The Underwater date picker sets the reservation for the Underwater restaurant.
   */
  @FXML
  private DatePicker underwaterDatePicker;

  /**
   * The Waterside guests combo box gets the number of guests being requested for the Waterside
   * restaurant reservation.
   */
  @FXML
  private ComboBox<Integer> watersideGuests;

  /**
   * The Underwater guests combo box gets the number of guests being requested  for the Underwater
   * restaurant reservation.
   */
  @FXML
  private ComboBox<Integer> underwaterGuests;

  /**
   * The initialize() function is used to initialize the number of guests in the reservation combo
   * boxes.
   */
  public void initialize() {
    List<Integer> numbers = new ArrayList<>();
    for (int i = 1; i <= 5; i++) {
      numbers.add(i);
    }
    ObservableList<Integer> numberList = FXCollections.observableList(numbers);
    watersideGuests.getItems().clear();
    watersideGuests.setItems(numberList);
    watersideGuests.getSelectionModel().selectFirst();
    underwaterGuests.getItems().clear();
    underwaterGuests.setItems(numberList);
    underwaterGuests.getSelectionModel().selectFirst();
  }

  /**
   * The goToWaterSideConfirmationPage() method shows a confirmation message with the date and
   * number of guests going to the Waterside restaurant or an error message if one of the two fields
   * are left empty.
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
   * The goToUnderWaterConfirmationPage() method shows a confirmation message with the date and
   * number of guests going to the UnderWater restaurant or an error message if one of the two
   * fields are left empty.
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
        FXMLLoader.load(getClass().getResource("fxml_files/current_guest_options.fxml"));
    Scene currentGuestOptionsScene = new Scene(currentGuestOptionsParent);
    Stage currentGuestOptionsStage = (Stage) ((Node) event.getSource()).getScene().getWindow();
    currentGuestOptionsStage.setScene(currentGuestOptionsScene);
    currentGuestOptionsStage.show();
  }
}
