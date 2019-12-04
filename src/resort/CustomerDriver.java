package resort;

public class CustomerDriver {

  private String lastName;
  private String phoneNumber;
  private String emailColumn;
  private String last4;
  public String checkIn;
  public String checkOut;

  CustomerDriver(String lastName, String phoneNumber, String emailColumn, String last4) {
    this.lastName = lastName;
    this.phoneNumber = phoneNumber;
    this.emailColumn = emailColumn;
    this.last4 = last4;
  }

  CustomerDriver(String lastName, String phoneNumber, String emailColumn, String last4,
      String checkIn, String checkOut) {
    this.lastName = lastName;
    this.phoneNumber = phoneNumber;
    this.emailColumn = emailColumn;
    this.last4 = last4;
    this.checkIn = checkIn;
    this.checkOut = checkOut;
  }

  CustomerDriver() {
  }

  CustomerDriver(String checkIn,
      String checkOut) {
    this.checkIn = checkIn;
    this.checkOut = checkOut;
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

  public void setLast4(String last4) {
    this.last4 = last4;
  }

  public String getLast4() {
    return last4;
  }

  public void setCheckIn(String checkIn) {
    this.checkIn = checkIn;
  }

  public String getCheckIn() {
    return checkIn;
  }

  public void setCheckOut(String checkOut) {
    this.checkOut = checkOut;
  }

  public String getCheckOut() {
    return checkOut;
  }
}
