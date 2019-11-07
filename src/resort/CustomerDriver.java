package resort;

import java.util.Date;

public class CustomerDriver {

  private String name;
  private String phoneNumber;
  private String roomType;
  private String last4CCN;
  private Date reservation;

  public CustomerDriver(
      String name, String phoneNumber, String roomType, String last4CCN, Date reservation) {
    this.name = name;
    this.phoneNumber = phoneNumber;
    this.roomType = roomType;
    this.last4CCN = last4CCN;
    this.reservation = reservation;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public String getPhoneNumber() {
    return phoneNumber;
  }

  public void setPhoneNumber(String phoneNumber) {
    this.phoneNumber = phoneNumber;
  }

  public String getRoomType() {
    return roomType;
  }

  public void setRoomType(String roomType) {
    this.roomType = roomType;
  }

  public String getLast4CCN() {
    return last4CCN;
  }

  public void setLast4CCN(String last4CCN) {
    this.last4CCN = last4CCN;
  }

  public Date getReservation() {
    return reservation;
  }

  public void setReservation(Date reservation) {
    this.reservation = reservation;
  }
}
