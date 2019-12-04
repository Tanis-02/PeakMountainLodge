package resort;

/**
 * The manager driver class is used to setup the table view for the financial reports.
 */
public class ManagerDriver {

  /**
   * Field member "roomRates" is the rates of the rooms.
   */
  private int roomRates;

  /**
   * Field member "dining" is the revenue from dining.
   */
  private int dining;

  /**
   * Field member "activities" is the revenue of the activities.
   */
  private int activities;

  /**
   * Field member "expenses" is the amount of money spent by the resort.
   */
  private int expenses;

  /**
   * Field member "revenue" is the total of all fields minus expenses.
   */
  private int revenue;

  /**
   * The overloaded ManagerDriver class constructor.
   *
   * @param roomRates  room rates
   * @param dining     dining revenue
   * @param activities activities revenue
   * @param expenses   expenses by the resort
   * @param revenue    total revenue
   */
  ManagerDriver(int roomRates, int dining, int activities, int expenses, int revenue) {
    this.roomRates = roomRates;
    this.dining = dining;
    this.activities = activities;
    this.expenses = expenses;
    this.revenue = revenue;
  }

  /**
   * The getRoomRates() method is used to get the room rates.
   *
   * @return room rates of the resort
   */
  public int getRoomRates() {
    return roomRates;
  }

  /**
   * The getDining() method gets the revenue of the dining for the resort.
   *
   * @return dining revenue
   */
  public int getDining() {
    return dining;
  }

  /**
   * The getActivities() method gets the revenue of the activities for the resort.
   *
   * @return activities revenue
   */
  public int getActivities() {
    return activities;
  }

  /**
   * The getExpenses() method gets the amount of money the resort has paid out.
   *
   * @return expenses of the resort
   */
  public int getExpenses() {
    return expenses;
  }

  /**
   * The getRevenue() method returns the revenue of all other fields minus expenses.
   *
   * @return total revenue
   */
  public int getRevenue() {
    return revenue;
  }
}
