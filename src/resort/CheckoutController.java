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

/** Everything in the CheckoutController corresponds to items in the checkout.fxml file. */
public class CheckoutController {

  /**
   * Directs the customer to the feedback page.
   *
   * @param event upon clicking the feedback button
   * @throws IOException yes, it does
   */
  @FXML
  void goToGuestFeedbackPage(MouseEvent event) throws IOException {
    Parent guestFeedbackParent = FXMLLoader.load(getClass().getResource("guest_feedback.fxml"));
    Scene guestFeedbackScene = new Scene(guestFeedbackParent);
    Stage guestFeedbackStage = (Stage) ((Node) event.getSource()).getScene().getWindow();
    guestFeedbackStage.setScene(guestFeedbackScene);
    guestFeedbackStage.show();
  }

  /**
   * Directs the customer to the home page.
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
    Parent homeParent = FXMLLoader.load(getClass().getResource("home.fxml"));
    Scene homeScene = new Scene(homeParent);
    Stage homeStage = (Stage) ((Node) event.getSource()).getScene().getWindow();
    homeStage.setScene(homeScene);
    homeStage.show();
  }

  /**
   * Directs the customer to the previous page.
   *
   * @param event upon clicking the back button
   * @throws IOException yes, it does
   */
  @FXML
  void goToPreviousPage(MouseEvent event) throws IOException {
    Parent currentGuestOptionsParent =
        FXMLLoader.load(getClass().getResource("current_guest_options.fxml"));
    Scene currentGuestOptionsScene = new Scene(currentGuestOptionsParent);
    Stage currentGuestOptionsStage = (Stage) ((Node) event.getSource()).getScene().getWindow();
    currentGuestOptionsStage.setScene(currentGuestOptionsScene);
    currentGuestOptionsStage.show();
  }
}
