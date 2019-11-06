package resort;

/* Needs to be done:
1. Initialize all table views, combo boxes, etc.
2. Logic for error messages and confirmation messages for certain things
3. Make it possible to create new managers/employee log-ins.
 */

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.CheckBox;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;

/** The ManagerOverviewController corresponds to all items on the manager_overview.fxml file */
public class ManagerOverviewController {

  /** Table view financialReportsTableView is used to see all of the financial reports. */
  @FXML private TableView<ManagerDriver> financialReportsTableView;

  /** ChoiceBox sortBy allows the user to sort by a particular field in the financial reports. */
  @FXML private ChoiceBox<String> sortBy;

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

  @FXML private TableColumn<Integer, ManagerDriver> ratesColumn;

  @FXML private TableColumn<Integer, ManagerDriver> diningColumn;

  @FXML private TableColumn<Integer, ManagerDriver> activitiesColumn;

  @FXML private TableColumn<Integer, ManagerDriver> expensesColumn;

  @FXML private TableColumn<Integer, ManagerDriver> revenueColumn;

  @FXML private TableColumn<?, ?> dateColumn;

  @FXML private TableColumn<?, ?> costColumn;

  @FXML private TableColumn<?, ?> roomNumberColumn;

  @FXML private TableColumn<?, ?> blackOutDateColumn;

  @FXML private TableColumn<?, ?> blackOutCostColumn;

  @FXML private TableColumn<?, ?> blackOutRoomTypeColumn;

  @FXML private TableColumn<?, ?> nameColumn;

  @FXML private TableColumn<?, ?> phoneNumberColumn;

  @FXML private TableColumn<?, ?> roomTypeColumn;

  @FXML private TableColumn<?, ?> last4CCNColumn;

  @FXML private TableColumn<?, ?> checkInColumn;

  public void initialize() {
    ObservableList<ManagerDriver> manager = FXCollections.observableArrayList();
    ObservableList<String> sort =
        FXCollections.observableArrayList(
            "Room Rates", "Dining", "Activities", "Expenses", "Total Revenue");
    ratesColumn.setCellValueFactory(new PropertyValueFactory<>("rates"));
    diningColumn.setCellValueFactory(new PropertyValueFactory<>("dining"));
    activitiesColumn.setCellValueFactory(new PropertyValueFactory<>("activities"));
    expensesColumn.setCellValueFactory(new PropertyValueFactory<>("expenses"));
    revenueColumn.setCellValueFactory(new PropertyValueFactory<>("revenue"));
    Random random = new Random();
    for (int i = 0; i <= 20; i++) {
      manager.add(
          new ManagerDriver(
              random.nextInt(500000),
              random.nextInt(500000),
              random.nextInt(500000),
              random.nextInt(500000),
              random.nextInt(500000)));
      financialReportsTableView.setItems(manager);
    }
    sortBy.getItems().clear();
    sortBy.setItems(sort);
    sortBy.getSelectionModel().selectFirst();
    List<Integer> numbers = new ArrayList<>();
    for (int i = 2018; i >= 2005; i--) {
      numbers.add(i);
    }
    ObservableList numberList = FXCollections.observableList(numbers);
    previousReports.getItems().clear();
    previousReports.setItems(numberList);
    previousReports.getSelectionModel().selectFirst();
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
