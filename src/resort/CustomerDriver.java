package resort;

/**
 * The customer driver class is used to gather the data to populate the manager view customer
 * information table view.
 */
public class CustomerDriver {

  /**
   * Field member "lastName" is the last name of the guest.
   */
  private String lastName;

  /**
   * Field member "phoneNumber" is the phone number of the guest.
   */
  private String phoneNumber;

  /**
   * Field member "emailColumn" is the email of the guest.
   */
  private String emailColumn;

  /**
   * Field member "last4" is the last four digits of the guest's credit card.
   */
  private String last4;

  /**
   * Field member "checkIn" is the date of the guest is set to check in.
   */
  public String checkIn;

  /**
   * Field member "checkOut" is the date the guest is set to check out.
   */
  public String checkOut;

  /**
   * The overloaded constructor for the CustomerDriver class.
   *
   * @param lastName    guest last name
   * @param phoneNumber guest phone number
   * @param emailColumn guest email
   * @param last4       last four of credit card number
   * @param checkIn     guest check in date
   * @param checkOut    guest check out date
   */
  CustomerDriver(String lastName, String phoneNumber, String emailColumn, String last4,
      String checkIn, String checkOut) {
    this.lastName = lastName;
    this.phoneNumber = phoneNumber;
    this.emailColumn = emailColumn;
    this.last4 = last4;
    this.checkIn = checkIn;
    this.checkOut = checkOut;
  }

  /**
   * The default constructor for the CustomerDriver class.
   */
  CustomerDriver() {
  }

  /**
   * The getLastName() method gets the guest's last name from the database.
   *
   * @return guest's last name
   */
  public String getLastName() {
    return lastName;
  }

  /**
   * The getLastName() method gets the guest's phone number from the database.
   *
   * @return guest's phone number
   */
  public String getPhoneNumber() {
    return phoneNumber;
  }

  /**
   * The getEmail() method gets the guest's email from the database.
   *
   * @return guest's email
   */
  public String getEmailColumn() {
    return emailColumn;
  }

  /**
   * The getLastName() method gets the guest's last four digits of the credit card from the
   * database.
   *
   * @return guest's last four digits of their credit card
   */
  public String getLast4() {
    return last4;
  }

  /**
   * The getCheckIn() method gets the guest's check in date from the database.
   *
   * @return guest's check in date
   */
  public String getCheckIn() {
    return checkIn;
  }

  /**
   * The getCheckOut() method gets the guest's check out date from the database.
   *
   * @return guest's check out date
   */
  public String getCheckOut() {
    return checkOut;
  }
}
