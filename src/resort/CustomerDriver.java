package resort;

public class CustomerDriver {

  private String lastName;
  private String phoneNumber;
  private String emailColumn;
  private int last4;
  private String dates;

  CustomerDriver(String lastName, String phoneNumber, String emailColumn, int last4) {
    this.lastName = lastName;
    this.phoneNumber = phoneNumber;
    this.emailColumn = emailColumn;
    this.last4 = last4;
  }

  public void setLastName(String lastName) {
    this.lastName = lastName;
  }

  public String getLastName() {
    return lastName;
  }

  public void setPhoneNumber(String phoneNumber) {
    this.phoneNumber = phoneNumber;
  }

  public String getPhoneNumber() {
    return phoneNumber;
  }

  public void setEmailColumn(String emailColumn) {
    this.emailColumn = emailColumn;
  }

  public String getEmailColumn() {
    return emailColumn;
  }

  public void setLast4(int last4) {
    this.last4 = last4;
  }

  public int getLast4() {
    return last4;
  }

  public void setDates(String dates) {
    this.dates = dates;
  }

  public String getDates() {
    return dates;
  }
}
