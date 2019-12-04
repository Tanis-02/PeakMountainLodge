package resort;

import java.io.IOException;
import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.temporal.TemporalAdjusters;
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
 * The new guest controller displays the date pickers and number of guests for their reservation.
 */
public class NewGuestController {

  /**
   * The following are variables to determine if the chosen dates fall on a holiday. The first is
   * the year selected.
   */
  int yearSelected;

  /**
   * The second is if the date falls in November.
   */
  LocalDate novYearSelected;

  /**
   * The third is if the date falls on Thanksgiving.
   */
  LocalDate thanksgiving;

  /**
   * The fourth is if the date falls between Thanksgiving and Christmas.
   */
  LocalDate midHolidays;

  /**
   * The final one is if the date falls on New Years.
   */
  LocalDate newYears;

  /**
   * The check in date picker is used to obtain the check in date of the customer and store it to
   * the database.
   */
  @FXML
  private DatePicker checkIn;

  /**
   * The check out date picker is used to obtain the check out date of the customer and store it to
   * the database.
   */
  @FXML
  private DatePicker checkOut;

  /**
   * The number of guests choice box is used to obtain the number of guests the customer has and
   * will show appropriate rooms according to the value entered.
   */
  @FXML
  private ChoiceBox<Integer> numberOfGuests;

  /**
   * The initialize() function is used to initialize the value in the combo box for the number of
   * guests going on the trip.
   */
  public void initialize() {
    List<Integer> numbers = new ArrayList<>();
    for (int i = 1; i <= 10; i++) {
      numbers.add(i);
    }
    ObservableList<Integer> numberList = FXCollections.observableList(numbers);
    numberOfGuests.getItems().clear();
    numberOfGuests.setItems(numberList);
    numberOfGuests.getSelectionModel().selectFirst();
  }

  /**
   * Once a customer chooses their dates and number of guests, they will be shown the available
   * rooms that meet their criteria. The check out date must be after the check in date and both
   * dates must be selected or an error message will be displayed.
   *
   * @param event goes to the available rooms page
   * @throws IOException yes, it does
   */
  @FXML
  public void goToAvailableRoomsPage(MouseEvent event) throws IOException {
    if (checkIn.getValue() == null || checkOut.getValue() == null) {
      Alert error = new Alert(AlertType.ERROR);
      error.setContentText("Both dates must be selected. Please try again.");
      error.show();
    } else if (checkIn.getValue().isAfter(checkOut.getValue())) {
      Alert error2 = new Alert(AlertType.ERROR);
      error2.setContentText("Check in date must be before check out date.");
      error2.show();
    } else {
      yearSelected = checkIn.getValue().getYear();
      novYearSelected = LocalDate.of(yearSelected, 11, 15);
      thanksgiving = novYearSelected
          .with(TemporalAdjusters.dayOfWeekInMonth(4, DayOfWeek.THURSDAY));
      midHolidays = LocalDate.of(yearSelected, 12, 27);
      newYears = LocalDate.of(yearSelected, 1, 1);
      if (thanksgiving.minusDays(2).isBefore(checkOut.getValue()) &&
          thanksgiving.plusDays(2).isAfter(checkIn.getValue())) {
        FXMLLoader roomsLoader = new FXMLLoader(
            getClass().getResource("fxml_files/available_rooms.fxml"));
        roomsLoader.load();
        roomsLoader.getController();
        AvailableRoomsController.holidayPrices();
      } else if (midHolidays.minusDays(6).isBefore(checkOut.getValue()) &&
          midHolidays.plusDays(6).isAfter(checkIn.getValue())) {
        FXMLLoader roomsLoader = new FXMLLoader(
            getClass().getResource("fxml_files/available_rooms.fxml"));
        roomsLoader.load();
        roomsLoader.getController();
        AvailableRoomsController.holidayPrices();
      } else if (newYears.minusDays(2).isBefore(checkOut.getValue()) &&
          newYears.plusDays(2).isAfter(checkIn.getValue())) {
        FXMLLoader roomsLoader = new FXMLLoader(
            getClass().getResource("fxml_files/available_rooms.fxml"));
        roomsLoader.load();
        roomsLoader.getController();
        AvailableRoomsController.holidayPrices();
      } else {
        FXMLLoader roomsLoader = new FXMLLoader(
            getClass().getResource("fxml_files/available_rooms.fxml"));
        roomsLoader.load();
        roomsLoader.getController();
        AvailableRoomsController.normalPrices();
      }
      Parent availableRoomsParent = FXMLLoader
          .load(getClass().getResource("fxml_files/available_rooms.fxml"));
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
    Parent homeParent = FXMLLoader.load(getClass().getResource("fxml_files/home.fxml"));
    Scene homeScene = new Scene(homeParent);
    Stage homeStage = (Stage) ((Node) event.getSource()).getScene().getWindow();
    homeStage.setScene(homeScene);
    homeStage.show();
  }
}
