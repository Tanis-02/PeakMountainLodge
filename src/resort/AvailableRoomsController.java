package resort;

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
    ((Node) (event.getSource())).getScene().getWindow().hide();
    Parent root = FXMLLoader.load(getClass().getResource("create_account.fxml"));
    Stage create = new Stage();
    create.setTitle("Create Account");
    create.setScene(new Scene(root, 800, 600));
    create.show();
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
    Parent root = FXMLLoader.load(getClass().getResource("new_guest.fxml"));
    Stage home = new Stage();
    home.setTitle("Check Availability");
    home.setScene(new Scene(root, 800, 600));
    home.show();
  }
}
