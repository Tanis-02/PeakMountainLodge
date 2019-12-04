package resort;

/**
 * The employee driver class is used to create new employees in the manager view screen.
 */
public class EmployeeDriver {

  /**
   * Field member "employeeID" is the ID of the employee.
   */
  private String employeeID;

  /**
   * Field member "employeeFirst" is the first name of the employee.
   */
  private String employeeFirst;

  /**
   * Field member "employeeLast" is the last name of the employee.
   */
  private String employeeLast;

  /**
   * Field member "accessID" is the accessID of the employee.
   */
  private String accessID;

  /**
   * The getEmployeeID() method returns the employee's ID from the database.
   *
   * @return employee ID
   */
  public String getEmployeeID() {
    return employeeID;
  }

  /**
   * The getEmployeeFirst() method returns the employee's first name from the database.
   *
   * @return employee first name
   */
  public String getEmployeeFirst() {
    return employeeFirst;
  }

  /**
   * The getEmployeeLast() method returns the employee's last name from the database.
   *
   * @return employee last name
   */
  public String getEmployeeLast() {
    return employeeLast;
  }

  /**
   * The getAccessID() method returns the employee's accessID from the database.
   *
   * @return employee accessID
   */
  public String getAccessID() {
    return accessID;
  }

  /**
   * The EmployeeDriver constructor.
   *
   * @param employeeID    employee ID
   * @param employeeFirst employee first name
   * @param employeeLast  employee last name
   * @param accessID      employee accessID
   */
  EmployeeDriver(String employeeID, String employeeFirst, String employeeLast, String accessID) {
    this.employeeID = employeeID;
    this.employeeFirst = employeeFirst;
    this.employeeLast = employeeLast;
    this.accessID = accessID;
  }
}
