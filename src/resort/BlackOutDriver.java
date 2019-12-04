package resort;

import java.util.Date;

/**
 * The blackout driver class is a class used to generate the values in the blackout tab for the
 * manager view.
 */
public class BlackOutDriver {

  /**
   * Blackout date is the date of the blackout in the manager view.
   */
  private Date blackOutDate;

  /**
   * Blackout cost is the cost of the room that is being blacked out in the manager view.
   */
  private double blackOutCost;

  /**
   * Blackout room number is the room that is being blacked out on the blackout date.
   */
  private int blackOutRoomNum;

  /**
   * The blackout driver constructor that takes 3 parameters.
   *
   * @param blackOutDate    date of the blackout
   * @param blackOutCost    cost of the room being blacked out
   * @param blackOutRoomNum room number of the blacked out room
   */
  public BlackOutDriver(Date blackOutDate, double blackOutCost, int blackOutRoomNum) {
    this.blackOutDate = blackOutDate;
    this.blackOutCost = blackOutCost;
    this.blackOutRoomNum = blackOutRoomNum;
  }

  /**
   * The getBlackOutDate() method gets the blackout date of the room being blacked out.
   *
   * @return the blackout date of the room being blacked out
   */
  public Date getBlackOutDate() {
    return blackOutDate;
  }

  /**
   * The setBlackOutDate() method sets the date of the room being blacked out.
   *
   * @param blackOutDate date of the room being blacked out
   */
  public void setBlackOutDate(Date blackOutDate) {
    this.blackOutDate = blackOutDate;
  }

  /**
   * The getBlackOutCost() method gets the cost of the room being blacked out.
   *
   * @return the cost of the room being blacked out
   */
  public double getBlackOutCost() {
    return blackOutCost;
  }

  /**
   * The setBlackOutCost() method sets the cost of the room being blacked out.
   *
   * @param blackOutCost cost of the room being blacked out
   */
  public void setBlackOutCost(double blackOutCost) {
    this.blackOutCost = blackOutCost;
  }

  /**
   * The getBlackOutRoomNum() method gets the blacked out room number.
   *
   * @return the room number of the room being blacked out
   */
  public int getBlackOutRoomNum() {
    return blackOutRoomNum;
  }

  /**
   * The setBlackOutRoomNum() method sets the room number of the room being blacked out.
   *
   * @param blackOutRoomNum room number of the room being blacked out
   */
  public void setBlackOutRoomNum(int blackOutRoomNum) {
    this.blackOutRoomNum = blackOutRoomNum;
  }
}
