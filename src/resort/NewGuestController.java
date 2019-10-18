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

/** Everything in the NewGuestController corresponds to items on the new_guest.fxml file */
public class NewGuestController {

  /**
   * DatePicker checkIn is used to obtain the check in date of the customer and store it to the
   * database
   */
  @FXML private DatePicker checkIn;

  /**
   * DatePicker checkOut is used to obtain the check out date of the customer and store it to the
   * database
   */
  @FXML private DatePicker checkOut;

  /**
   * ChoiceBox numberOfGuests is used to obtain the number of guests the customer has and will show
   * appropriate rooms according to the value entered.
   */
  @FXML private ChoiceBox<?> numberOfGuests;

  @FXML
  void goToAvailableRoomsPage(MouseEvent event) throws IOException {
    ((Node) (event.getSource())).getScene().getWindow().hide();
    Parent root = FXMLLoader.load(getClass().getResource("available_rooms.fxml"));
    Stage rooms = new Stage();
    rooms.setTitle("Please choose a room");
    rooms.setScene(new Scene(root, 800, 700));
    rooms.show();
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
    Parent root = FXMLLoader.load(getClass().getResource("home.fxml"));
    Stage home = new Stage();
    home.setTitle("Welcome");
    home.setScene(new Scene(root, 800, 600));
    home.show();
  }
}
