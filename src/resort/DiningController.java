package resort;

import java.io.IOException;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;

/** Everything in the DiningController corresponds to items on the dining.fxml file. */
public class DiningController {

  /**
   * The goToConfirmationPage() right now just displays an alert rather than an actual scene. Will
   * be updated later with actual scene.
   *
   * @param event opens the confirmation alert to confirm to the customer the action they made
   */
  @FXML
  void goToConfirmationPage(MouseEvent event) {
    Alert confirmation = new Alert(AlertType.CONFIRMATION);
    confirmation.setContentText("Your dinner reservation has been submitted!");
    confirmation.show();
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
    Parent root = FXMLLoader.load(getClass().getResource("current_guest_options.fxml"));
    Stage home = new Stage();
    home.setTitle("Please choose an option");
    home.setScene(new Scene(root, 800, 600));
    home.show();
  }
}
