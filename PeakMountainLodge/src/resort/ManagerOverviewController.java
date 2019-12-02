package resort;

/* Needs to be done:
1. Initialize all table views, combo boxes, etc.
2. Logic for error messages and confirmation messages for certain things
3. Make it possible to create new managers/employee log-ins.
 */

import java.io.IOException;
import java.sql.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Random;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;

/**
 * The ManagerOverviewController corresponds to all items on the manager_overview.fxml file
 */
public class ManagerOverviewController {

  /**
   * Table view financialReportsTableView is used to see all of the financial reports.
   */
  @FXML
  private TableView<ManagerDriver> financialReportsTableView;

  /**
   * ChoiceBox sortBy allows the user to sort by a particular field in the financial reports.
   */
  @FXML
  private ChoiceBox<String> sortBy;

  /**
   * DatePicker startDate is used to select a start date for the financial reports table view.
   */
  @FXML
  private DatePicker startDate;

  /**
   * DatePicker endDate is used to select an end date for the financial reports table view.
   */
  @FXML
  private DatePicker endDate;

  /**
   * ChoiceBox previousReports allows the user to select a year to view those reports.
   */
  @FXML
  private ChoiceBox<?> previousReports;

  /**
   * Table view blackOutDatesTableView is used to view all of the rooms and to select a room.
   */
  @FXML
  private TableView<BlackOutDriver> blackOutDatesTableView;

  /**
   * CheckBox confirmation is used to confirm black out date selection.
   */
  @FXML
  private CheckBox confirmation;

  /**
   * DatePicker datePicker is used to select the date for blacking out dates.
   */
  @FXML
  private DatePicker datePicker;

  /**
   * Table view promotionsTableView is used to view all of the rooms and to select a room.
   */
  @FXML
  private TableView<?> promotionsTableView;

  /**
   * Table view customerInformationTableView is used to view all of the customers and their related
   * information from the database.
   */
  @FXML
  private TableView<CustomerDriver> customerInformationTableView;

  /**
   * Text field to look up the customer by their name from the database.
   */
  @FXML
  private TextField customerName;

  /**
   * Text field to look up the customer by their phone number from the database.
   */
  @FXML
  private TextField customerPhone;

  /**
   * Text field to look up the customer by their credit card number from the database.
   */
  @FXML
  private TextField creditCardNumber;

  @FXML
  private TableColumn<Integer, ManagerDriver> ratesColumn;

  @FXML
  private TableColumn<Integer, ManagerDriver> diningColumn;

  @FXML
  private TableColumn<Integer, ManagerDriver> activitiesColumn;

  @FXML
  private TableColumn<Integer, ManagerDriver> expensesColumn;

  @FXML
  private TableColumn<Integer, ManagerDriver> revenueColumn;

  @FXML
  private TableColumn<?, ?> dateColumn;

  @FXML
  private TableColumn<?, ?> costColumn;

  @FXML
  private TableColumn<?, ?> roomNumberColumn;

  @FXML
  private TableColumn<BlackOutDriver, Date> blackOutDateColumn;

  @FXML
  private TableColumn<BlackOutDriver, Double> blackOutCostColumn;

  @FXML
  private TableColumn<BlackOutDriver, Integer> blackOutRoomNum;

  @FXML
  private Button blackOutBtn;

  @FXML
  private ChoiceBox<?> costBlPicker;

  @FXML
  private TextField roomNumBlTx;

  @FXML
  private TableColumn<CustomerDriver, String> nameColumn;

  @FXML
  private TableColumn<CustomerDriver, String> phoneNumberColumn;

  @FXML
  private TableColumn<CustomerDriver, String> emailColumn;

  @FXML
  private TableColumn<CustomerDriver, Integer> last4Column;

  @FXML
  private TableColumn<CustomerDriver, ?> checkInColumn;

  @FXML
  private Button searchCustomerBtn;

  /**
   * Text area to append customer feedback to for managers to view.
   */
  @FXML
  private TextArea feedbackLog;

  @FXML
  private TableView<EmployeeDriver> employeeTableView;

  @FXML
  private TableColumn<EmployeeDriver, String> employeeID;

  @FXML
  private TableColumn<EmployeeDriver, String> firstNameEmpl;

  @FXML
  private TableColumn<EmployeeDriver, String> lastNameEmpl;

  @FXML
  private TableColumn<EmployeeDriver, String> accessIDCol;

  @FXML
  private TextField employeeIDTx;

  @FXML
  private TextField employeeFTX;

  @FXML
  private TextField employeeLTx;

  @FXML
  private ChoiceBox<String> accessIDBox;

  @FXML
  private Button newEmployeeBtn;

  private static ArrayList<String> feedbackList = new ArrayList<>();

  private ObservableList<BlackOutDriver> blackOut;

  private ObservableList<CustomerDriver> CustomerInfo;

  private ObservableList<EmployeeDriver> Employee;

  /**
   * Currently, the initialize method serves the purpose of populating the textarea in the customer
   * feedback tab each time the user (which in this case will be a manager) logs into the manager
   * overview screen.
   */
  public void initialize() throws SQLException {
    feedbackLog.setEditable(false);
    for (String s : feedbackList) {
      feedbackLog.appendText(s + "\n");
    }
    if (feedbackList.size() == 0) {
      feedbackLog.appendText("No customer feedback to display");
    }
    ConnManager connManager = new ConnManager();
    connManager.selectAllCustomers();
    ObservableList<ManagerDriver> financial = FXCollections.observableArrayList();
    ObservableList<ConnManager> customer = FXCollections.observableArrayList();
    customer.add(connManager.selectAllCustomers());
    System.out.println(customer.toString());

    ObservableList<String> sort =
        FXCollections.observableArrayList(
            "Room Rates", "Dining", "Activities", "Expenses", "Total Revenue");
    ratesColumn.setCellValueFactory(new PropertyValueFactory<>("roomRates"));
    diningColumn.setCellValueFactory(new PropertyValueFactory<>("dining"));
    activitiesColumn.setCellValueFactory(new PropertyValueFactory<>("activities"));
    expensesColumn.setCellValueFactory(new PropertyValueFactory<>("expenses"));
    revenueColumn.setCellValueFactory(new PropertyValueFactory<>("revenue"));
    Random random = new Random();
    for (int i = 0; i <= 20; i++) {
      financial.add(
          new ManagerDriver(
              random.nextInt(500000),
              random.nextInt(500000),
              random.nextInt(500000),
              random.nextInt(500000),
              random.nextInt(500000)));
      financialReportsTableView.setItems(financial);
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

    /*
    for the black out tab
     */

    blackOut = FXCollections.observableArrayList();

    blackOutDateColumn.setCellValueFactory(new PropertyValueFactory("blackOutDate"));
    blackOutCostColumn.setCellValueFactory(new PropertyValueFactory("blackOutCost"));
    blackOutRoomNum.setCellValueFactory(new PropertyValueFactory("blackOutRoomNum"));

    addBlackout();
    blackOutDatesTableView.setItems(blackOut);


    /*
    for the customer info tab
     */

    nameColumn.setCellValueFactory(new PropertyValueFactory("lastName"));
    phoneNumberColumn.setCellValueFactory(new PropertyValueFactory("phoneNumber"));
    emailColumn.setCellValueFactory(new PropertyValueFactory("emailColumn"));
    last4Column.setCellValueFactory(new PropertyValueFactory("last4"));
    //checkInColumn.setCellValueFactory(new PropertyValueFactory("dates"));
    addCustomer();
    customerInformationTableView.setItems(CustomerInfo);

     /*
    for the employee tab
     */
    ObservableList<String> accessNum = FXCollections.observableArrayList("1", "2","3");
    accessIDBox.getItems().clear();
    accessIDBox.setItems(accessNum);
    accessIDBox.getSelectionModel().selectFirst();

    employeeID.setCellValueFactory(new PropertyValueFactory("employeeID"));
    firstNameEmpl.setCellValueFactory(new PropertyValueFactory("employeeFirst"));
    lastNameEmpl.setCellValueFactory(new PropertyValueFactory("employeeLast"));
    accessIDCol.setCellValueFactory(new PropertyValueFactory("accessID"));

    addEmployee();
    employeeTableView.setItems(Employee);
  }

  public void addBlackout() {
    Date d1 = new Date(119,11,20);
    Date d2 = new Date(119,11,20);
    Date d3 = new Date(119,11,20);
    Date d4 = new Date(119,11,20);
    Date d5 = new Date(119,11,21);
    Date d6 = new Date(119,11,21);
    Date d7 = new Date(119,11,21);
    Date d8 = new Date(119,11,25);
    Date d9 = new Date(119,11,25);
    Date d10 = new Date(119,11,25);
    Date d11 = new Date(119,11,25);
    Date d12 = new Date(119,11,25);
    Date d13 = new Date(119,11,29);
    Date d14 = new Date(119,11,29);
    Date d15 = new Date(119,11,29);
    Date d16 = new Date(119,11,29);
    Date d17 = new Date(119,11,29);



    blackOut.add(new BlackOutDriver(d1,499.00,110));
    blackOut.add(new BlackOutDriver(d2,419.00,114));
    blackOut.add(new BlackOutDriver(d3,419.00,116));
    blackOut.add(new BlackOutDriver(d4,419.00,214));
    blackOut.add(new BlackOutDriver(d5,499.00,210));
    blackOut.add(new BlackOutDriver(d6,499.00,310));
    blackOut.add(new BlackOutDriver(d7,419.00,314));
    blackOut.add(new BlackOutDriver(d8,419.00,316));
    blackOut.add(new BlackOutDriver(d10,419.00,318));
    blackOut.add(new BlackOutDriver(d11,499.00,210));
    blackOut.add(new BlackOutDriver(d12,499.00,310));
    blackOut.add(new BlackOutDriver(d13,419.00,314));
    blackOut.add(new BlackOutDriver(d14,419.00,316));
    blackOut.add(new BlackOutDriver(d15,419.00,214));
    blackOut.add(new BlackOutDriver(d16,419.00,218));
    blackOut.add(new BlackOutDriver(d17,419.00,216));
  }

  public void addCustomer() throws SQLException {
    Connection con = DriverManager.getConnection("jdbc:h2:./src/resort/Database/productDB");
    CustomerInfo = FXCollections.observableArrayList();
    ResultSet rs = con.createStatement().executeQuery("SELECT * FROM CUSTOMERS");
    while (rs.next()){
      CustomerInfo.add(new CustomerDriver(rs.getString(3),rs.getString(4),rs.getString(1),rs.getInt(5)));
    }
    con.close();
  }

  public void addEmployee() throws SQLException {
    Connection conn = DriverManager.getConnection("jdbc:h2:./src/resort/Database/productDB");
    Employee = FXCollections.observableArrayList();
    ResultSet rs = conn.createStatement().executeQuery("SELECT * FROM EMPLOYEES");
    while (rs.next()){
      Employee.add(new EmployeeDriver(rs.getString(1),rs.getString(2),rs.getString(3), rs.getString(4)));
    }
    conn.close();
  }

  @FXML
  void createEmployee(MouseEvent event) throws SQLException {
    String id = employeeIDTx.getText();
    String firstName = employeeFTX.getText();
    String lastName = employeeLTx.getText();
    String access = accessIDBox.getValue();

    Connection connect = DriverManager.getConnection("jdbc:h2:./src/resort/Database/productDB");
    Statement state = connect.createStatement();
    state.executeUpdate("INSERT INTO EMPLOYEES(EMPLOYEEID,FIRSTNAME,LASTNAME,ACCESSID) VALUES ('"+id+"', '"+firstName+"', '"+lastName+"','"+access+"')");
    connect.close();

    refreshTable();
  }

  void refreshTable() throws SQLException {
    Employee.clear();
    Employee = FXCollections.observableArrayList();
    Connection conn = DriverManager.getConnection("jdbc:h2:./src/resort/Database/productDB");
    ResultSet rs = conn.createStatement().executeQuery("SELECT * FROM EMPLOYEES");
    while (rs.next()){
      Employee.add(new EmployeeDriver(rs.getString(1),rs.getString(2),rs.getString(3), rs.getString(4)));
    }
    conn.close();

    employeeTableView.setItems(Employee);
  }

  @FXML
  private void searchCustomer(ActionEvent event) throws SQLException {
    //ConnManager connManager = new ConnManager();
    //connManager.searchCustomerManageroverview();
  }

  void fillFeedbackLog(String guestFeedback, String feedbackFamily) {
    Date feedbackDate = new Date();
    String newFeedback =
        "On "
            + feedbackDate
            + " the "
            + feedbackFamily
            + " family said:\n\""
            + guestFeedback
            + "\"\n";
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
    Parent homeParent = FXMLLoader.load(getClass().getResource("fxml_files/home.fxml"));
    Scene homeScene = new Scene(homeParent);
    Stage homeStage = (Stage) ((Node) event.getSource()).getScene().getWindow();
    homeStage.setScene(homeScene);
    homeStage.show();
  }
}
