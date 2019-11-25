package resort;

public class CustomerDriver {

  private String name;
  private String phoneNumber;
  private String roomType;
  private String last4;
  private String checkIn;

  public CustomerDriver(
      String name, String phoneNumber, String roomType, String last4, String checkIn) {
    this.name = name;
    this.phoneNumber = phoneNumber;
    this.roomType = roomType;
    this.last4 = last4;
    this.checkIn = checkIn;
  }

  public void setLastName(String name) {
    this.name = name;
  }

  public String getLastName() {
    return name;
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
}
