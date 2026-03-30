import java.util.*;

class BookingService {

    public synchronized Booking bookSeats(User user, Show show, List<int[]> positions) {

        List<Seat> selectedSeats = new ArrayList<>();

        // Check availability
        for (int[] pos : positions) {
            Seat seat = show.getSeat(pos[0], pos[1]);

            if (seat.getStatus() != SeatStatus.AVAILABLE) {
                throw new RuntimeException("Seat already booked!");
            }
            selectedSeats.add(seat);
        }

        // Reserve & Book
        for (Seat seat : selectedSeats) {
            seat.reserve();
        }

        for (Seat seat : selectedSeats) {
            seat.book();
        }

        Booking booking = new Booking(show, selectedSeats);
        booking.confirm();

        user.addBooking(booking);

        return booking;
    }

    public synchronized void cancelBooking(User user, Booking booking) {
        if (booking.getStatus() != BookingStatus.CONFIRMED) {
            throw new RuntimeException("Booking is not active.");
        }

        for (Seat seat : booking.getSeats()) {
            seat.release();
        }

        booking.cancel();
        user.removeBooking(booking);
    }
}