package resort;

import java.io.IOException;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;

/**
 * The available rooms controller is shown to the user and displays the available rooms for the
 * dates selected and the prices for those rooms.
 */
public class AvailableRoomsController {

  /**
   * The label that shows the price for the large room.
   */
  @FXML
  private Label largeRoom;

  /**
   * The label that shows the price for the small room.
   */
  @FXML
  private Label smallRoom;

  /**
   * Determines if the date the guest picked is during a holiday time period. If so, the price for
   * the room will change accordingly.
   */
  private static boolean holiday;

  /**
   * Sets the holiday boolean equal to true to display holiday pricing for the rooms.
   */
  static void holidayPrices() {
    holiday = true;
  }

  /**
   * Sets the holiday boolean equal to false to display normal pricing for the rooms.
   */
  static void normalPrices() {
    holiday = false;
  }

  /**
   * The initialize() method is used to the labels on the screen to display holiday rates or normal
   * rates for the rooms.
   */
  @FXML
  public void initialize() {
    if (holiday) {
      largeRoom.setText("$599");
      smallRoom.setText("$519");
    } else {
      largeRoom.setText("$499");
      smallRoom.setText("$419");
    }
  }

  /**
   * Once a customer selects a room, they are then asked to create an account before checking out.
   *
   * @param event goes to the create account page
   * @throws IOException yes, it does
   */
  @FXML
  void goToCreateAccountPage(MouseEvent event) throws IOException {
    Parent createAccountParent = FXMLLoader
        .load(getClass().getResource("fxml_files/create_account.fxml"));
    Scene createAccountScene = new Scene(createAccountParent);
    Stage createAccountStage = (Stage) ((Node) event.getSource()).getScene().getWindow();
    createAccountStage.setScene(createAccountScene);
    createAccountStage.show();
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
    Parent newGuestParent = FXMLLoader.load(getClass().getResource("fxml_files/new_guest.fxml"));
    Scene newGuestScene = new Scene(newGuestParent);
    Stage newGuestStage = (Stage) ((Node) event.getSource()).getScene().getWindow();
    newGuestStage.setScene(newGuestScene);
    newGuestStage.show();
  }
}
