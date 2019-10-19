package resort;

import java.io.IOException;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.CheckBox;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;

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

  /**
   * The goToHomePage() function is used to bring the user to the home page and logs the manager out
   * of the system.
   *
   * @param event MouseEvent upon clicking the back button
   * @throws IOException yes, it does
   */
  @FXML
  void goToHomePage(MouseEvent event) throws IOException {
    ((Node) (event.getSource())).getScene().getWindow().hide();
    Parent root = FXMLLoader.load(getClass().getResource("home.fxml"));
    Stage home = new Stage();
    home.setTitle("Welcome");
    home.setScene(new Scene(root, 800, 600));
    home.show();
  }
}
