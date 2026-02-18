import java.util.ArrayList;
import java.util.List;

public class Taxi {
    private int taxiId;
    private char currentSpot;
    private int freeTime;
    private int totalEarnings;
    private List<Booking> bookings;

    Taxi(int taxiId) {
        this.taxiId = taxiId;
        this.currentSpot = 'A';
        this.freeTime = 0;
        this.totalEarnings = 0;
        this.bookings = new ArrayList<>();
    }

    public boolean isFree(char pickUp,int pickupTime) {
        int travelTime = Math.abs(pickUp - currentSpot);
        if(travelTime + freeTime <= pickupTime) {
            return true;
        }
        return false;
    }
    public void assignBookings(Booking booking) {
        bookings.add(booking);

    }
    public int getTaxiId(){
        return taxiId;
    }
    public char getCurrentSpot() {
        return currentSpot;
    }
    public int getFreeTime() {
        return freeTime;
    }
    public int getTotalEarnings() {
        return totalEarnings;
    }
    public List<Booking> getBookings() {
        return bookings;
    }

    public void setFreeTime(int freeTime) {
        this.freeTime = freeTime;
    }

    public void setTotalEarnings(int earnings) {
        this.totalEarnings += earnings;
    }

    public void setCurrentSpot(char currentSpot) {
        this.currentSpot = currentSpot;
    }


}
