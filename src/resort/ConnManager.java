package resort;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 * The connManager class is used primarily for database services.
 */
class ConnManager {

  private Connection conn;
  private PreparedStatement preparedStatement;
  private ResultSet resultSet;

  ConnManager() throws SQLException {
    conn = DriverManager.getConnection("jdbc:h2:./src/resort/Database/productDB");
  }

  /**
   * The insertCustomer() method inserts customer details into the database.
   *
   * @param insertValues details of the customer
   * @throws SQLException yes, it does
   */
  void insertCustomer(String[] insertValues) throws SQLException {
    String insertCustomer =
        "INSERT INTO CUSTOMERS ("
            + "EMAIL,"
            + "FIRSTNAME,"
            + "LASTNAME,"
            + "PHONENUMBER,"
            + "LASTFOURCC,"
            + "CHECK_IN,"
            + "CHECK_OUT)"
            + "VALUES(?, ?, ?, ?, ?, ?, ?)";
    preparedStatement = conn.prepareStatement(insertCustomer);
    preparedStatement.setString(1, insertValues[0]);
    preparedStatement.setString(2, insertValues[1]);
    preparedStatement.setString(3, insertValues[2]);
    preparedStatement.setString(4, insertValues[3]);
    preparedStatement.setString(5, insertValues[4]);
    preparedStatement.setString(6, "12-25-2019");
    preparedStatement.setString(7, "12-31-2019");
    preparedStatement.executeUpdate();
  }

  /**
   * The selectAllCustomers() method retrieves all the customers in the database and their
   * associated details.
   *
   * @return ConnManager.this
   */
  ConnManager selectAllCustomers() {
    try {
      Statement statement = conn.createStatement();
      resultSet = statement.executeQuery("SELECT * FROM customers;");
      while (resultSet.next()) {
        System.out.println();
      }
    } catch (SQLException e) {
      sqlExceptionHandler(e);
    }
    return ConnManager.this;
  }

  void insertActivities(String date, int numberOfGuests) throws SQLException {
    String setActivities = "INSERT INTO RESERVATIONS (ACTIVITIES, ACTIVITIES_DATE) VALUES (?, ?)";
    preparedStatement = conn.prepareStatement(setActivities);
    preparedStatement.setDate(2, java.sql.Date.valueOf(date));
    preparedStatement.setInt(1, numberOfGuests);
  }

  /**
   * The verifyGuestLogin() method compares the last name and phone number of the guest and compares
   * it to the values in the database. If they match correctly, the guest is logged in. If not, the
   * user is shown an error message.
   *
   * @param lastName    customer last name
   * @param phoneNumber customer phone number
   * @return true if a correct match, false if not a correct match
   * @throws SQLException yes, it does
   */
  boolean verifyGuestLogin(String lastName, String phoneNumber) throws SQLException {
    String getPhoneNumber = "SELECT PHONENUMBER FROM CUSTOMERS WHERE LASTNAME = ?";
    preparedStatement = conn.prepareStatement(getPhoneNumber);
    preparedStatement.setString(1, lastName);
    resultSet = preparedStatement.executeQuery();
    while (resultSet.next()) {
      if (resultSet.getString(1) != null && resultSet.getString(1).equals(phoneNumber)) {
        return true;
      }
    }
    return false;
  }

  /**
   * The verifyManagerLogin() method compares the last name and employee ID of the employee and
   * compares it to the values in the database. If they match correctly, the employee is logged in.
   * If not, the user is shown an error message.
   *
   * @param userName   employee username
   * @param employeeID employee ID
   * @return true if a correct match, false if not a correct match
   * @throws SQLException yes, it does
   */
  boolean verifyManagerLogin(String userName, String employeeID) throws SQLException {
    String getPhoneNumber = "SELECT EMPLOYEEID FROM EMPLOYEES WHERE LASTNAME = ?";
    preparedStatement = conn.prepareStatement(getPhoneNumber);
    preparedStatement.setString(1, userName);
    resultSet = preparedStatement.executeQuery();
    while (resultSet.next()) {
      if (resultSet.getString("EMPLOYEEID") != null && resultSet.getString("EMPLOYEEID")
          .equals(employeeID)) {
        return true;
      }
    }
    return false;
  }

  /**
   * This method is used for exception handling for SQL errors.
   *
   * @param error error message
   */
  private void sqlExceptionHandler(SQLException error) {
    System.out.println("Standard Failure: " + error.getMessage());
  }
}
