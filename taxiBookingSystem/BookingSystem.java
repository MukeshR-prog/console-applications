import java.util.ArrayList;
import java.util.List;

public class BookingSystem {
    List<Taxi> taxis;
    int bookingIdCounter = 1;
    BookingSystem(int taxiCount) {
        taxis = new ArrayList<>();
        for(int i=1; i<=taxiCount; i++) {
            taxis.add(new Taxi(i));
        }
    }

    public int calculateCharges(char pickup, char drop){
        int distance = Math.abs(pickup-drop)*15;
        int charges = 100;
        charges += (distance - 5) * 10;
        return charges;
    }

    Taxi findTaxi(char pickup , int pickupTime) {
        List<Taxi> availableTaxis = new ArrayList<>();
        for(Taxi taxi : taxis) {
            if(taxi.isFree(pickup, pickupTime)) {
                availableTaxis.add(taxi);
            }
        }
        if(availableTaxis.size() == 0) {
            return null;
        }
        List <Taxi> closestTaxis = new ArrayList<>();
        int minDistance = Integer.MAX_VALUE;
        for(Taxi taxi : availableTaxis) {
            int distance = Math.abs(taxi.getCurrentSpot() - pickup);
            minDistance = Math.min(minDistance, distance);
        }
        for(Taxi taxi : availableTaxis) {
            int distance = Math.abs(taxi.getCurrentSpot() - pickup);
            if(distance == minDistance) {
                closestTaxis.add(taxi);
            }
        }
        Taxi selectedTaxi = closestTaxis.get(0);
        for(Taxi taxi : closestTaxis) {
            if(taxi.getTotalEarnings() < selectedTaxi.getTotalEarnings()) {
                selectedTaxi = taxi;
            }
        }
        return selectedTaxi;
    }

    public void BookTaxi(Customer customer) {
        Taxi selected = findTaxi(customer.getPickup(), customer.getPickupTime());
        if(selected == null) {
            System.out.println("No taxi available for booking");
            return;
        }
        int travelTime = Math.abs(customer.getPickup() - customer.getDrop());
        int dropTime = customer.getPickupTime() + travelTime;
        int charges = calculateCharges(customer.getPickup(), customer.getDrop()); 
        Booking booking = new Booking(bookingIdCounter++, dropTime, charges, customer);
        selected.assignBookings(booking);
        selected.setFreeTime(dropTime);
        selected.setTotalEarnings(charges);
        selected.setCurrentSpot(customer.getDrop());
        System.out.println("Taxi - "+ selected.getTaxiId()+ " is assigned");
    }

    public void displayTaxi(){
        for(Taxi t : taxis){
            System.out.println("Taxi "+t.getTaxiId()+" earnings = "+t.getTotalEarnings());
        }
    }
}
