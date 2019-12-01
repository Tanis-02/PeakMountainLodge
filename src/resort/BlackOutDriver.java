package resort;

import java.util.Date;

public class BlackOutDriver {

    private Date blackOutDate;
    private double blackOutCost;
    private int blackOutRoomNum;

    public BlackOutDriver(Date blackOutDate, double blackOutCost, int blackOutRoomNum) {
        this.blackOutDate = blackOutDate;
        this.blackOutCost = blackOutCost;
        this.blackOutRoomNum = blackOutRoomNum;
    }

    public Date getBlackOutDate() {
        return blackOutDate;
    }

    public void setBlackOutDate(Date blackOutDate) {
        this.blackOutDate = blackOutDate;
    }

    public double getBlackOutCost() {
        return blackOutCost;
    }

    public void setBlackOutCost(double blackOutCost) {
        this.blackOutCost = blackOutCost;
    }

    public int getBlackOutRoomNum() {
        return blackOutRoomNum;
    }

    public void setBlackOutRoomNum(int blackOutRoomNum) {
        this.blackOutRoomNum = blackOutRoomNum;
    }
}
