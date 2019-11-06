package resort;

/* Needs to be done:
1. Method written to update last 4 of CCN from CheckoutController
 */

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Calendar;
import java.util.Date;

public class ConnManager {
  private Connection conn;
  private PreparedStatement preparedStatement;
  private ResultSet resultSet;
  private Statement statement;

  ConnManager() throws SQLException {
    conn =
        DriverManager.getConnection(
            "jdbc:h2:C:\\Users\\acava\\OneDrive - Florida Gulf Coast University\\COP 3003\\PeakMountainLodge\\src\\resort\\Database\\productDB");
  }

  // Creates a new customer
  void insertCustomer(String[] insertValues) throws SQLException {
    String insertCustomer =
        "INSERT INTO customers ("
            + "    email,"
            + "    firstName,"
            + "    lastName,"
            + "    phoneNumber,"
            + "    lastFourCC"
            + ")"
            + "VALUES(?,?,?,?,?)";
    preparedStatement = conn.prepareStatement(insertCustomer);
    preparedStatement.setString(1, insertValues[0]);
    preparedStatement.setString(2, insertValues[1]);
    preparedStatement.setString(3, insertValues[2]);
    preparedStatement.setInt(4, Integer.parseInt(insertValues[3]));
    preparedStatement.setInt(5, Integer.parseInt(insertValues[4]));
    preparedStatement.executeUpdate();
  }

  // Creating a new employee
  public void insertEmployee(String[] insertValues) throws SQLException {
    String insertEmployee =
        "INSERT INTO employees ("
            + "    employeeID,"
            + "    firstName,"
            + "    lastName,"
            + "    accessID"
            + ")"
            + "VALUES(?,?,?,?)";
    preparedStatement = conn.prepareStatement(insertEmployee);
    preparedStatement.setInt(1, Integer.parseInt(insertValues[0]));
    preparedStatement.setString(2, insertValues[1]);
    preparedStatement.setString(3, insertValues[2]);
    preparedStatement.setInt(4, Integer.parseInt(insertValues[3]));
    preparedStatement.executeUpdate();
  }

  // Creating access levels
  public void insertAccessID(String[] insertValues) throws SQLException {
    String insertAccessID = "INSERT INTO accessID (" + "    employeeID" + ")" + "VALUES(?)";
    preparedStatement = conn.prepareStatement(insertAccessID);
    preparedStatement.setInt(1, Integer.parseInt(insertValues[0]));
    preparedStatement.executeUpdate();
  }

  // Creating a new reservation
  void setReservation(String start, String end, String[] insertValues) throws SQLException {
    Calendar day1 = Calendar.getInstance();
    Calendar day2 = Calendar.getInstance();

    String[] startStr = start.split("/");
    String[] endStr = end.split("/");

    // Since date object is base off index starting at 0 we need to take 1 off the month
    int startMonth = Integer.parseInt(startStr[1]) - 1;
    int endMonth = Integer.parseInt(endStr[1]) - 1;

    day1.set(Integer.parseInt(startStr[0]), startMonth, Integer.parseInt(startStr[2]));
    day2.set(Integer.parseInt(endStr[0]), endMonth, Integer.parseInt(endStr[2]));
    Date startDate = day1.getTime();
    Date endDate = day2.getTime();
    long startTime = startDate.getTime();
    long endTime = endDate.getTime();
    long diffTime = endTime - startTime;
    long diffDays = diffTime / (1000 * 60 * 60 * 24);

    int nextID = 0;

    try {
      statement = conn.createStatement();
      resultSet = statement.executeQuery("SELECT TOP 1 * FROM RESERVATIONS ORDER BY resID DESC");

      while (resultSet.next()) {
        System.out.printf("resID = %d%n", resultSet.getInt("resID"));
        nextID = resultSet.getInt("resID");
        nextID++;
        System.out.println(nextID);
      }

    } catch (SQLException e) {
      sqlExceptionHandler(e);
    }

    for (int i = 0; i <= diffDays; i++) {
      int newDay = day1.get(Calendar.DATE);
      if (i != 0) {
        newDay = day1.get(Calendar.DATE) + 1;
      }
      // System.out.println(newDay);
      day1.set(Calendar.DATE, newDay);

      // Put back the one we took away as SQL is not index based
      int currentMonth = day1.get(Calendar.MONTH) + 1;
      String dateToAdd =
          day1.get(Calendar.YEAR) + "-" + currentMonth + "-" + day1.get(Calendar.DATE);
      System.out.println(dateToAdd);
      String insertReservation =
          "INSERT INTO RESERVATIONS ("
              + "    resDate,"
              + "    payCollected,"
              + "    total,"
              + "    roomID,"
              + "    resID,"
              + "    customerEmail"
              + ")"
              + "VALUES(?,?,?,?,?,?)";
      preparedStatement = conn.prepareStatement(insertReservation);
      preparedStatement.setDate(1, java.sql.Date.valueOf(dateToAdd));
      preparedStatement.setInt(2, Integer.parseInt(insertValues[0]));
      preparedStatement.setFloat(3, Float.parseFloat(insertValues[1]));
      preparedStatement.setInt(4, Integer.parseInt(insertValues[2]));
      preparedStatement.setInt(5, Integer.parseInt(String.valueOf(nextID)));
      preparedStatement.setString(6, insertValues[3]);
      preparedStatement.executeUpdate();
    }
  }

  // Creating a table not really useful for this
  public void createTable(String SQL_CREATE) throws SQLException {
    System.out.println(SQL_CREATE);
    preparedStatement = conn.prepareStatement(SQL_CREATE);
    try {
      preparedStatement.execute();
    } catch (SQLException e) {
      System.err.format("SQL State: %s\n%s", e.getSQLState(), e.getMessage());
    } catch (Exception e) {
      e.printStackTrace();
    }
  }

  // Selecting all Customers
  void selectAllCustomers() {
    try {
      statement = conn.createStatement();
      resultSet = statement.executeQuery("SELECT * FROM customers;");
      while (resultSet.next()) {
        System.out.printf("email = %s%n", resultSet.getString("email"));
        System.out.printf("FirstName = %s%n", resultSet.getString("firstName"));
        System.out.printf("LastName = %s%n", resultSet.getString("lastName"));
        System.out.printf("PhoneNumber = %d%n", resultSet.getInt("phoneNumber"));
        System.out.printf("Last 4 = %s%n", resultSet.getString("lastFourCC"));
        System.out.println("\n");
      }
    } catch (SQLException e) {
      sqlExceptionHandler(e);
    }
  }

  public void selectAllEmployees() {
    try {
      statement = conn.createStatement();
      resultSet = statement.executeQuery("SELECT * FROM EMPLOYEES");
      while (resultSet.next()) {
        System.out.printf("employeeID = %s%n", resultSet.getString("employeeID"));
        System.out.printf("FirstName = %s%n", resultSet.getString("firstName"));
        System.out.printf("LastName = %s%n", resultSet.getString("lastName"));
        System.out.printf("accessID = %s%n", resultSet.getInt("accessID"));
        System.out.println("\n");
      }
    } catch (SQLException e) {
      sqlExceptionHandler(e);
    }
  }

  // Selecting all Reservations
  public void selectAllReservations(String reservationDate) {
    try {
      statement = conn.createStatement();
      resultSet = statement.executeQuery("SELECT * FROM RESERVATIONS;");
      while (resultSet.next()) {
        System.out.printf("resDate = %s%n", resultSet.getDate("resDate"));
        System.out.printf("payCollected = %s%n", resultSet.getInt("payCollected"));
        System.out.printf("total = %s%n", resultSet.getFloat("total"));
        System.out.printf("roomID = %d%n", resultSet.getInt("roomID"));
        System.out.printf("resID = %s%n", resultSet.getString("resID"));
        System.out.printf("customerEmail = %s%n", resultSet.getString("customerEmail"));
        System.out.println("\n");
      }
    } catch (SQLException e) {
      sqlExceptionHandler(e);
    }
  }

  private void sqlExceptionHandler(SQLException error) {
    System.out.println("Standard Failure: " + error.getMessage());
  }
}
