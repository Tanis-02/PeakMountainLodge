package resort;

/* Needs to be done:
1. Update pricing based on the dates selected.
2. Show different available rooms based on the number of guests.
3. Show no rooms available for black out dates and no availability (booked up).
 */

import java.io.IOException;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;

/**
 * Everything in the AvailableRoomsController corresponds to items in the available_rooms.fxml file.
 */
public class AvailableRoomsController {

  /**
   * Once a customer selects a room, they are then asked to create an account before checking out.
   *
   * @param event goes to the create account page
   * @throws IOException yes, it does
   */
  @FXML
  void goToCreateAccountPage(MouseEvent event) throws IOException {
    Parent createAccountParent = FXMLLoader.load(getClass().getResource("create_account.fxml"));
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
    Parent newGuestParent = FXMLLoader.load(getClass().getResource("new_guest.fxml"));
    Scene newGuestScene = new Scene(newGuestParent);
    Stage newGuestStage = (Stage) ((Node) event.getSource()).getScene().getWindow();
    newGuestStage.setScene(newGuestScene);
    newGuestStage.show();
  }
}
