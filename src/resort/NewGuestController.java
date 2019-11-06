package resort;

/* Needs to be done:
1. Create logic to compare value of reservations vs today. Date must be in future or today, not in the past.
2. Push dates to database for the reservation (save for future screens)
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

/** Everything in the NewGuestController corresponds to items on the new_guest.fxml file */
public class NewGuestController {

  /**
   * DatePicker checkIn is used to obtain the check in date of the customer and store it to the
   * database.
   */
  @FXML private DatePicker checkIn;

  /**
   * DatePicker checkOut is used to obtain the check out date of the customer and store it to the
   * database.
   */
  @FXML private DatePicker checkOut;

  /**
   * ChoiceBox numberOfGuests is used to obtain the number of guests the customer has and will show
   * appropriate rooms according to the value entered.
   */
  @FXML private ChoiceBox<?> numberOfGuests;

  /**
   * The initialize() function is used to initialize the value in the combo box for the number of
   * guests going on the trip.
   */
  public void initialize() {
    List<Integer> numbers = new ArrayList<>();
    for (int i = 1; i <= 10; i++) {
      numbers.add(i);
    }
    ObservableList numberList = FXCollections.observableList(numbers);
    numberOfGuests.getItems().clear();
    numberOfGuests.setItems(numberList);
    numberOfGuests.getSelectionModel().selectFirst();
  }

  /**
   * Once a customer chooses their dates and number of guests, they will be shown the available
   * rooms that meet their criteria.
   *
   * @param event goes to the available rooms page
   * @throws IOException yes, it does
   */
  @FXML
  void goToAvailableRoomsPage(MouseEvent event) throws IOException, SQLException {
    if (checkIn.getValue() == null || checkOut.getValue() == null) {
      Alert error = new Alert(AlertType.ERROR);
      error.setContentText("Both dates must be selected. Please try again.");
      error.show();
    } else if (checkIn.getValue().isAfter(checkOut.getValue())) {
      Alert error2 = new Alert(AlertType.ERROR);
      error2.setContentText("Check in date must be before check out date.");
      error2.show();
    } else {
      Parent availableRoomsParent = FXMLLoader.load(getClass().getResource("available_rooms.fxml"));
      Scene availableRoomsScene = new Scene(availableRoomsParent);
      Stage availableRoomsStage = (Stage) ((Node) event.getSource()).getScene().getWindow();
      availableRoomsStage.setScene(availableRoomsScene);
      availableRoomsStage.show();
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
    Parent homeParent = FXMLLoader.load(getClass().getResource("home.fxml"));
    Scene homeScene = new Scene(homeParent);
    Stage homeStage = (Stage) ((Node) event.getSource()).getScene().getWindow();
    homeStage.setScene(homeScene);
    homeStage.show();
  }
}
