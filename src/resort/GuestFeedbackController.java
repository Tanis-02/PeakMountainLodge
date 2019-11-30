package resort;

import java.io.IOException;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;

public class GuestFeedbackController {

  /**
   * Button that submits the guest's typed feedback when pressed.
   */
  @FXML
  private Button btnSubmitFeedback;

  /**
   * Text area that allows the guest to type in their feedback.
   */
  @FXML
  private TextArea inputFeedback;

  /**
   * Family name to be accepted from the previous scene and used when recording feedback logs. Must
   * be static because passFamilyName is called through another instance of GuestFeedbackController
   * than the instance in use when submitFeedback is called through the click of a button.
   */
  private static String familyName;

  /**
   * The initialize method allows the submit button to be pressed and the text area to type in
   * feedback to be edited again, as both are disabled when the user submits their feedback so as to
   * prevent spam.
   */
  @FXML
  private void initialize() {
    inputFeedback.setEditable(true);
    btnSubmitFeedback.setDisable(false);
  }

  /**
   * passFamilyName takes in the family name variable when a guest logs in so it can send it to
   * ManagerOverviewController to be used in the feedback logs.
   *
   * @param familyName is the last name that the guest used to log in with.
   */
  void passFamilyName(String familyName) {
    GuestFeedbackController.familyName = familyName;
  }

  /**
   * submitFeedback is called whenever a guest clicks the "Submit Feedback" button. It sends the
   * text from the corresponding textBox, in addition to the name of the family currently logged in,
   * to ManagerOverviewController.
   *
   * @throws IOException is potentially thrown when loading the manager_overview.fxml file
   */
  @FXML
  void submitFeedback() throws IOException {
    btnSubmitFeedback.setDisable(true);
    FXMLLoader feedbackLoader = new FXMLLoader(getClass().getResource(
        "fxml_files/manager_overview.fxml"));
    feedbackLoader.load();
    ManagerOverviewController controller = feedbackLoader.getController();
    controller.fillFeedbackLog(inputFeedback.getText(), familyName);
    inputFeedback.clear();
    inputFeedback.appendText("Your feedback has been submitted, thank you very much!");
    inputFeedback.setEditable(false);
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
    Parent currentGuestOptionsParent = FXMLLoader.load(getClass().getResource(
        "fxml_files/checkout.fxml"));
    Scene currentGuestOptionsScene = new Scene(currentGuestOptionsParent);
    Stage currentGuestOptionsStage = (Stage) ((Node) event.getSource()).getScene().getWindow();
    currentGuestOptionsStage.setScene(currentGuestOptionsScene);
    currentGuestOptionsStage.show();
  }
}
