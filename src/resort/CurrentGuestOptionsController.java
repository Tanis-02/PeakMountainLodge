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
    Parent activitiesParent = FXMLLoader.load(getClass().getResource("activities.fxml"));
    Scene activitiesScene = new Scene(activitiesParent);
    Stage activitiesStage = (Stage) ((Node) event.getSource()).getScene().getWindow();
    activitiesStage.setScene(activitiesScene);
    activitiesStage.show();
  }

  /**
   * The goToDiningPage() will open the dining page.
   *
   * @param event goes to the dining page
   * @throws IOException yes, it does
   */
  @FXML
  void goToDiningPage(MouseEvent event) throws IOException {
    Parent diningParent = FXMLLoader.load(getClass().getResource("dining.fxml"));
    Scene diningScene = new Scene(diningParent);
    Stage diningStage = (Stage) ((Node) event.getSource()).getScene().getWindow();
    diningStage.setScene(diningScene);
    diningStage.show();
  }

  /**
   * The goToSpecialRequestsPage() will open the special requests page.
   *
   * @param event goes to the special requests page
   * @throws IOException yes, it does
   */
  @FXML
  void goToSpecialRequestsPage(MouseEvent event) throws IOException {
    Parent specialRequestsParent = FXMLLoader.load(getClass().getResource("special_requests.fxml"));
    Scene specialRequestsScene = new Scene(specialRequestsParent);
    Stage specialRequestsStage = (Stage) ((Node) event.getSource()).getScene().getWindow();
    specialRequestsStage.setScene(specialRequestsScene);
    specialRequestsStage.show();
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
    Parent currentGuestParent = FXMLLoader.load(getClass().getResource("current_guest.fxml"));
    Scene currentGuestScene = new Scene(currentGuestParent);
    Stage currentGuestStage = (Stage) ((Node) event.getSource()).getScene().getWindow();
    currentGuestStage.setScene(currentGuestScene);
    currentGuestStage.show();
  }
}
