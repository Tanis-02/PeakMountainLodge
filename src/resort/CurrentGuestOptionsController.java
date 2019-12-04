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
 * The current guest options controller shows the available options to the guest logged in.
 */
public class CurrentGuestOptionsController {

  /**
   * Field member familyName is the name that the user entered in the last name field, and will be
   * greeted by on the scene. It must be static so that it retains its value when the user backs out
   * of further scenes, until a new user logs in.
   */
  private static String familyName;

  /**
   * The label that will be used for greeting the guest once they log in.
   */
  @FXML
  private Label greetGuest;

  /**
   * The setFamilyName() method is used to display the family's name on the screen once they log in.
   * Right now, it's initialized to "Guest".
   *
   * @param lastName is assigned to familyName and is used to greet the user by name in this scene
   */
  void setFamilyName(String lastName) throws IOException {
    setNameStatic(lastName);
    greetGuest.setText("Hello, " + familyName + " Family");
    FXMLLoader passFamilyLoader = new FXMLLoader(getClass().getResource(
        "fxml_files/guest_feedback.fxml"));
    passFamilyLoader.load();
    GuestFeedbackController passFamilyController = passFamilyLoader.getController();
    passFamilyController.passFamilyName(familyName);
  }

  /**
   * The setNameStatic() method is used to set the family name to static.
   *
   * @param name last name of the guest
   */
  private static void setNameStatic(String name) {
    familyName = name;
  }

  /**
   * The initialize() method is used to initialize the name of the family on the screen when the
   * user opens this scene from anywhere other than the current guest page.
   */
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
    Parent activitiesParent = FXMLLoader.load(getClass().getResource("fxml_files/activities.fxml"));
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
    Parent diningParent = FXMLLoader.load(getClass().getResource("fxml_files/dining.fxml"));
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
    Parent specialRequestsParent = FXMLLoader.load(getClass().getResource(
        "fxml_files/special_requests.fxml"));
    Scene specialRequestsScene = new Scene(specialRequestsParent);
    Stage specialRequestsStage = (Stage) ((Node) event.getSource()).getScene().getWindow();
    specialRequestsStage.setScene(specialRequestsScene);
    specialRequestsStage.show();
  }

  /**
   * The goToFeedbackPage() will open the page where current guests can submit feedback.
   *
   * @param event goes to the guest feedback page
   * @throws IOException because it accepts input, which in this case is in the form of an event
   */
  @FXML
  void goToCheckoutPage(MouseEvent event) throws IOException {
    Parent guestFeedbackParent = FXMLLoader
        .load(getClass().getResource("fxml_files/checkout.fxml"));
    Scene guestFeedbackScene = new Scene(guestFeedbackParent);
    Stage guestFeedbackStage = (Stage) ((Node) event.getSource()).getScene().getWindow();
    guestFeedbackStage.setScene(guestFeedbackScene);
    guestFeedbackStage.show();
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
    Parent currentGuestParent = FXMLLoader.load(getClass().getResource(
        "fxml_files/current_guest.fxml"));
    Scene currentGuestScene = new Scene(currentGuestParent);
    Stage currentGuestStage = (Stage) ((Node) event.getSource()).getScene().getWindow();
    currentGuestStage.setScene(currentGuestScene);
    currentGuestStage.show();
  }
}
