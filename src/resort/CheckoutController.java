package resort;

import java.io.IOException;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;

/** Everything in the CheckoutController corresponds to items in the checkout.fxml file. */
public class CheckoutController {

  @FXML
  void goToGuestFeedbackPage(MouseEvent event) throws IOException {
    Parent guestFeedbackParent = FXMLLoader.load(getClass().getResource("guest_feedback.fxml"));
    Scene guestFeedbackScene = new Scene(guestFeedbackParent);
    Stage guestFeedbackStage = (Stage) ((Node) event.getSource()).getScene().getWindow();
    guestFeedbackStage.setScene(guestFeedbackScene);
    guestFeedbackStage.show();
  }
}
