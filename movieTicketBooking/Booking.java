import java.util.*;

class Booking {
    private Show show;
    private List<Seat> seats;
    private BookingStatus status;

    public Booking(Show show, List<Seat> seats) {
        this.show = show;
        this.seats = seats;
        this.status = BookingStatus.CREATED;
    }

    public void confirm() {
        status = BookingStatus.CONFIRMED;
    }

    public void cancel() {
        status = BookingStatus.CANCELLED;
    }

    public List<Seat> getSeats() {
        return seats;
    }

    public BookingStatus getStatus() {
        return status;
    }

    public Show getShow() {
        return show;
    }

    public String toString() {
    StringBuilder sb = new StringBuilder();
    for (Seat s : seats) {
        sb.append("(").append(s.getRow()).append(",").append(s.getCol()).append(") ");
    }
    return sb.toString();
}
}