package resort;

public class EmployeeDriver {
  private String employeeID;
  private String employeeFirst;
  private String employeeLast;
  private String accessID;

  public String getEmployeeID() {
    return employeeID;
  }

  public void setEmployeeID(String employeeID) {
    this.employeeID = employeeID;
  }

  public String getEmployeeFirst() {
    return employeeFirst;
  }

  public void setEmployeeFirst(String employeeFirst) {
    this.employeeFirst = employeeFirst;
  }

  public String getEmployeeLast() {
    return employeeLast;
  }

  public void setEmployeeLast(String employeeLast) {
    this.employeeLast = employeeLast;
  }

  public String getAccessID() {
    return accessID;
  }

  public void setAccessID(String accessID) {
    this.accessID = accessID;
  }

  EmployeeDriver(String employeeID, String employeeFirst, String employeeLast, String accessID) {
    this.employeeID = employeeID;
    this.employeeFirst = employeeFirst;
    this.employeeLast = employeeLast;
    this.accessID = accessID;
  }

}
