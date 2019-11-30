package resort;

public class CustomerDriver {

  private String lastName;
  private String phoneNumber;
  private String roomType;
  private int last4;
  private String dates;

  CustomerDriver(String lastName, String phoneNumber, String roomType, int last4) {
    this.lastName = lastName;
    this.phoneNumber = phoneNumber;
    this.roomType = roomType;
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

  public void setRoomType(String roomType) {
    this.roomType = roomType;
  }

  public String getRoomType() {
    return roomType;
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
