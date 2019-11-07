package resort;

/* Needs to be done:
1. Initialize all table views, combo boxes, etc.
2. Logic for error messages and confirmation messages for certain things
3. Make it possible to create new managers/employee log-ins.
 */

import java.io.IOException;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;
import java.util.Date;
import java.util.ArrayList;

/** The ManagerOverviewController corresponds to all items on the manager_overview.fxml file */
public class ManagerOverviewController {

  /** Table view financialReportsTableView is used to see all of the financial reports. */
  @FXML private TableView<?> financialReportsTableView;

  /** ChoiceBox sortBy allows the user to sort by a particular field in the financial reports. */
  @FXML private ChoiceBox<?> sortBy;

  /** DatePicker startDate is used to select a start date for the financial reports table view. */
  @FXML private DatePicker startDate;

  /** DatePicker endDate is used to select an end date for the financial reports table view. */
  @FXML private DatePicker endDate;

  /** ChoiceBox previousReports allows the user to select a year to view those reports. */
  @FXML private ChoiceBox<?> previousReports;

  /** Table view blackOutDatesTableView is used to view all of the rooms and to select a room. */
  @FXML private TableView<?> blackOutDatesTableView;

  /** CheckBox confirmation is used to confirm black out date selection. */
  @FXML private CheckBox confirmation;

  /** DatePicker datePicker is used to select the date for blacking out dates. */
  @FXML private DatePicker datePicker;

  /** Table view promotionsTableView is used to view all of the rooms and to select a room. */
  @FXML private TableView<?> promotionsTableView;

  /**
   * Table view customerInformationTableView is used to view all of the customers and their related
   * information from the database.
   */
  @FXML private TableView<?> customerInformationTableView;

  /** Text field to look up the customer by their name from the database. */
  @FXML private TextField customerName;

  /** Text field to look up the customer by their phone number from the database. */
  @FXML private TextField customerPhone;

  /** Text field to look up the customer by their credit card number from the database. */
  @FXML private TextField creditCardNumber;

  /** Text area to append customer feedback to for managers to view. */
  @FXML private TextArea feedbackLog;

  /**
   * Temp string to gather new feedback from GuestFeedbackController, and an ArrayList to store
   * these strings. At the very least, feedbackList must be static so as to preserve the list of
   * feedback that is added to it across multiple instances of ManagerOverviewController.
   */
  private static String newFeedback;

  private static ArrayList<String> feedbackList = new ArrayList<>();

  /**
   * Currently, the initialize method serves the purpose of populating the textarea in the customer
   * feedback tab each time the user (which in this case will be a manager) logs into the manager
   * overview screen.
   */
  @FXML
  private void initialize() {
    for (int loadFeedback = 0; loadFeedback < feedbackList.size(); loadFeedback++) {
      feedbackLog.appendText(feedbackList.get(loadFeedback) + "\n");
    }
    if (feedbackList.size() == 0) {
      feedbackLog.appendText("No customer feedback to display");
    }
  }

  /**
   * fillFeedbackLog gets called from GuestFeedbackController whenever a guest submits their
   * feedback.
   */
  void fillFeedbackLog(String guestFeedback, String feedbackFamily) {
    Date feedbackDate = new Date();
    newFeedback =
        "On " + feedbackDate + " the " + feedbackFamily + " family said:\n\"" + guestFeedback + "\"\n";
    feedbackList.add(newFeedback);
  }

  /**
   * The goToHomePage() function is used to bring the user to the home page and logs the manager out
   * of the system.
   *
   * @param event MouseEvent upon clicking the back button
   * @throws IOException yes, it does
   */
  @FXML
  void goToHomePage(MouseEvent event) throws IOException {
    Parent homeParent = FXMLLoader.load(getClass().getResource("home.fxml"));
    Scene homeScene = new Scene(homeParent);
    Stage homeStage = (Stage) ((Node) event.getSource()).getScene().getWindow();
    homeStage.setScene(homeScene);
    homeStage.show();
  }
}
