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
 * Everything in the CurrentGuestOptionsController corresponds to items on the
 * current_guest_options.fxml file
 */
public class CurrentGuestOptionsController {

  /**
   * Field member familyName is used to display the family's name on the screen once they log in.
   * Right now, it's initialized to "Guest".
   */
  private String familyName = "Guest";

  /** Label that will be used for greeting the guest once they log in. */
  @FXML private Label greetGuest;

  /**
   * The setFamilyName() function is used to display the family's name on the screen once they log
   * in. Right now, it's initialized to "Guest".
   *
   * @param lastName is assigned to familyName and is used to greet the user by name in this scene
   */
  void setFamilyName(String lastName) {
    familyName = "Guest";
    greetGuest.setText("Hello, " + familyName + " Family");
  }

  /** The initialize() method is used to initialize the name of the family on the screen. */
  @FXML
  private void initialize() {
    greetGuest.setText("Hello, " + familyName + " Family");
  }

  /**
   * The goToActivitiesPage() will open the activities page.
   *
   * @param event goes to activities page
   * @throws IOException yes, it does
   */
  @FXML
  void goToActivitiesPage(MouseEvent event) throws IOException {
    ((Node) (event.getSource())).getScene().getWindow().hide();
    Parent root = FXMLLoader.load(getClass().getResource("activities.fxml"));
    Stage activities = new Stage();
    activities.setTitle("Please choose an activity");
    activities.setScene(new Scene(root, 800, 700));
    activities.show();
  }

  /**
   * The goToDiningPage() will open the dining page.
   *
   * @param event goes to the dining page
   * @throws IOException yes, it does
   */
  @FXML
  void goToDiningPage(MouseEvent event) throws IOException {
    ((Node) (event.getSource())).getScene().getWindow().hide();
    Parent root = FXMLLoader.load(getClass().getResource("dining.fxml"));
    Stage dining = new Stage();
    dining.setTitle("Choose a restaurant");
    dining.setScene(new Scene(root, 800, 700));
    dining.show();
  }

  /**
   * The goToSpecialRequestsPage() will open the special requests page.
   *
   * @param event goes to the special requests page
   * @throws IOException yes, it does
   */
  @FXML
  void goToSpecialRequestsPage(MouseEvent event) throws IOException {
    ((Node) (event.getSource())).getScene().getWindow().hide();
    Parent root = FXMLLoader.load(getClass().getResource("special_requests.fxml"));
    Stage requests = new Stage();
    requests.setTitle("Please choose one of the following");
    requests.setScene(new Scene(root, 800, 700));
    requests.show();
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
    Parent root = FXMLLoader.load(getClass().getResource("current_guest.fxml"));
    Stage home = new Stage();
    home.setTitle("Please Log In");
    home.setScene(new Scene(root, 800, 600));
    home.show();
  }
}
