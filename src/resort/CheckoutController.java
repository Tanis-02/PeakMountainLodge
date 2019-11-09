package resort;

import java.io.IOException;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;

/** Everything in the CheckoutController corresponds to items in the checkout.fxml file. */
public class CheckoutController {

  @FXML
  private ImageView imageviewResort;

  @FXML
  private Label labelThankYou1;

  @FXML
  private Label labelThankYou2;

  @FXML
  private Button buttonToGuestFeedback;

  @FXML
  void goToGuestFeedbackPage(MouseEvent event) throws IOException {
    Parent guestFeedbackParent = FXMLLoader.load(getClass().getResource("guest_feedback.fxml"));
    Scene guestFeedbackScene = new Scene(guestFeedbackParent);
    Stage guestFeedbackStage = (Stage) ((Node) event.getSource()).getScene().getWindow();
    guestFeedbackStage.setScene(guestFeedbackScene);
    guestFeedbackStage.show();
  }

}
