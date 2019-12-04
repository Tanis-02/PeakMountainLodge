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

/**
 * The checkout controller is where the customer goes to checkout and leave guest feedback for the
 * resort.
 */
public class CheckoutController {

  /**
   * Directs the customer to the feedback page to allow the customer their chance to leave any
   * feedback about the resort.
   *
   * @param event upon clicking the feedback button
   * @throws IOException yes, it does
   */
  @FXML
  void goToGuestFeedbackPage(MouseEvent event) throws IOException {
    Parent guestFeedbackParent =
        FXMLLoader.load(getClass().getResource("fxml_files/guest_feedback.fxml"));
    Scene guestFeedbackScene = new Scene(guestFeedbackParent);
    Stage guestFeedbackStage = (Stage) ((Node) event.getSource()).getScene().getWindow();
    guestFeedbackStage.setScene(guestFeedbackScene);
    guestFeedbackStage.show();
  }

  /**
   * Directs the customer to the home page once they have checked out.
   *
   * @param event upon clicking the checkout button
   * @throws IOException yes, it does
   */
  @FXML
  void goToHomePage(MouseEvent event) throws IOException {
    Alert confirmation = new Alert(AlertType.CONFIRMATION);
    confirmation.setContentText(
        "You have been successfully checked out. We hope you enjoyed your stay!");
    confirmation.show();
    Parent homeParent = FXMLLoader.load(getClass().getResource("fxml_files/home.fxml"));
    Scene homeScene = new Scene(homeParent);
    Stage homeStage = (Stage) ((Node) event.getSource()).getScene().getWindow();
    homeStage.setScene(homeScene);
    homeStage.show();
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
    Parent currentGuestOptionsParent =
        FXMLLoader.load(getClass().getResource("fxml_files/current_guest_options.fxml"));
    Scene currentGuestOptionsScene = new Scene(currentGuestOptionsParent);
    Stage currentGuestOptionsStage = (Stage) ((Node) event.getSource()).getScene().getWindow();
    currentGuestOptionsStage.setScene(currentGuestOptionsScene);
    currentGuestOptionsStage.show();
  }
}
