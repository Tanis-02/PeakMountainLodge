package resort;

import java.io.IOException;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.DatePicker;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;

/** Everything in ActivitiesController corresponds to items in the activities.fxml file */
public class ActivitiesController {

  /**
   * ChoiceBox numberOfGuestsRental is used to put how many people are registering for the rental
   */
  @FXML private ChoiceBox<?> numberOfGuestsRental;

  /** DatePicker rentalDatePicker is used to select a date during their stay to use the rental */
  @FXML private DatePicker rentalDatePicker;

  /** DatePicker snorkelingDatePicker is used to select a date during their stay to go snorkeling */
  @FXML private DatePicker snorkelingDatePicker;

  /**
   * ChoiceBox numberOfGuestsSnorkeling is used to to put how many people are registering for the
   * snorkeling tour
   */
  @FXML private ChoiceBox<?> numberOfGuestsSnorkeling;

  /**
   * The goToConfirmationPage() method will go to the confirmation page to confirm their activity.
   * It must have both the date and number of guests selected and the date must be within their stay
   * which is checked with the database.
   *
   * @param event will open the confirmation page
   */
  @FXML
  void goToConfirmationPage(MouseEvent event) {}

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
