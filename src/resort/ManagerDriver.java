package resort;

public class ManagerDriver {
  private int roomRates;
  private int dining;
  private int activities;
  private int expenses;
  private int revenue;

  public ManagerDriver(int roomRates, int dining, int activities, int expenses, int revenue) {
    this.roomRates = roomRates;
    this.dining = dining;
    this.activities = activities;
    this.expenses = expenses;
    this.revenue = revenue;
  }

  public int getRoomRates() {
    return roomRates;
  }

  public void setRoomRates(int roomRates) {
    this.roomRates = roomRates;
  }

  public int getDining() {
    return dining;
  }

  public void setDining(int dining) {
    this.dining = dining;
  }

  public int getActivities() {
    return activities;
  }

  public void setActivities(int activities) {
    this.activities = activities;
  }

  public int getExpenses() {
    return expenses;
  }

  public void setExpenses(int expenses) {
    this.expenses = expenses;
  }

  public int getRevenue() {
    return revenue;
  }

  public void setRevenue(int revenue) {
    this.revenue = revenue;
  }
}
