package resort;

/* Need to be done:
1. Compare dates chosen to dates guests are staying at the resort.
 */

import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
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

 /* Date a, b;   // assume these are set to something
  Date d;      // the date in question

return a.compareTo(d) * d.compareTo(b) > 0;
  If you want the range to be inclusive

return a.compareTo(d) * d.compareTo(b) >= 0;*/

 /* SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
  Date date1 = sdf.parse("2009-12-31");
  Date date2 = sdf.parse("2010-01-31");

        System.out.println("date1 : " + sdf.format(date1));
        System.out.println("date2 : " + sdf.format(date2));

        if (date1.compareTo(date2) > 0) {
    System.out.println("Date1 is after Date2");
  } else if (date1.compareTo(date2) < 0) {
    System.out.println("Date1 is before Date2");
  } else if (date1.compareTo(date2) == 0) {
    System.out.println("Date1 is equal to Date2");
  } else {
    System.out.println("How to get here?");
  }

}*/



  /**
   public class DisplayDate {
   public static void main(String args[]) {
   // Instantiate a objects
   Date date1 = new Date();
   Date date2 = new Date();

   if(date1.compareTo(date2)>0){
   System.out.println("Date1 is after Date2");
   }else if(date1.compareTo(date2)<0){
   System.out.println("Date1 is before Date2");
   }else{
   System.out.println("Date1 is equal to Date2");
   }

   }
   }
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
        FXMLLoader.load(getClass().getResource("fxml_files/current_guest_options.fxml"));
    Scene currentGuestOptionsScene = new Scene(currentGuestOptionsParent);
    Stage currentGuestOptionsStage = (Stage) ((Node) event.getSource()).getScene().getWindow();
    currentGuestOptionsStage.setScene(currentGuestOptionsScene);
    currentGuestOptionsStage.show();
  }
}
