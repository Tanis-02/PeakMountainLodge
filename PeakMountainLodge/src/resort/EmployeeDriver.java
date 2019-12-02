package resort;

public class EmployeeDriver {
  private int employeeID;
  private String employeeFirst;
  private String employeeLast;

  public int getEmployeeID() {
    return employeeID;
  }

  public void setEmployeeID(int employeeID) {
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

  EmployeeDriver(int employeeID, String employeeFirst, String employeeLast) {
    this.employeeID = employeeID;
    this.employeeFirst = employeeFirst;
    this.employeeLast = employeeLast;
  }

}
