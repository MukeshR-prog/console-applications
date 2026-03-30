import java.util.*;

public class Main {

    static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {

        // Setup Data
        City city = new City("Chennai");

        Theatre t1 = new Theatre("PVR");
        Theatre t2 = new Theatre("INOX");

        Screen s1 = new Screen("Screen1", 5, 5);
        Screen s2 = new Screen("Screen2", 5, 5);

        t1.addScreen(s1);
        t2.addScreen(s2);

        city.addTheatre(t1);
        city.addTheatre(t2);

        Movie m1 = new Movie("Inception");
        Movie m2 = new Movie("Interstellar");

        Show show1 = new Show(m1, s1, "6 PM");
        Show show2 = new Show(m2, s2, "9 PM");

        List<Show> shows = Arrays.asList(show1, show2);

        User user = new User("Mukesh");
        BookingService service = new BookingService();

        // MENU LOOP
        while (true) {

            System.out.println("\n===== MOVIE BOOKING SYSTEM =====");
            System.out.println("1. Book Ticket");
            System.out.println("2. View My Bookings");
            System.out.println("3. Cancel Booking");
            System.out.println("4. Exit");

            if (!sc.hasNextInt()) {
                System.out.println("Invalid choice!");
                sc.next();
                continue;
            }

            int choice = sc.nextInt();

            switch (choice) {

                case 1:
                    bookTicket(user, service, shows);
                    break;

                case 2:
                    viewBookings(user);
                    break;

                case 3:
                    cancelBooking(user, service);
                    break;

                case 4:
                    System.out.println("Exiting...");
                    return;

                default:
                    System.out.println("Invalid choice!");
            }
        }
    }

    // 🔹 Book Ticket
    private static void bookTicket(User user, BookingService service, List<Show> shows) {

        System.out.println("\nSelect Show:");

        for (int i = 0; i < shows.size(); i++) {
            System.out.println(i + " -> " + shows.get(i).getMovie().getTitle() +
                    " at " + shows.get(i).getTime());
        }

        if (!sc.hasNextInt()) {
            System.out.println("Invalid show selection.");
            sc.next();
            return;
        }

        int sChoice = sc.nextInt();

        if (sChoice < 0 || sChoice >= shows.size()) {
            System.out.println("Invalid show selection.");
            return;
        }

        Show selectedShow = shows.get(sChoice);

        System.out.println("\nSeat Layout:");
        selectedShow.displaySeats();

        System.out.println("\nEnter number of seats:");

        if (!sc.hasNextInt()) {
            System.out.println("Invalid number of seats.");
            sc.next();
            return;
        }

        int n = sc.nextInt();

        if (n <= 0) {
            System.out.println("Number of seats must be greater than 0.");
            return;
        }

        List<int[]> seatList = new ArrayList<>();
        Set<String> seenSeats = new HashSet<>();

        for (int i = 0; i < n; i++) {
            System.out.println("Enter row and col:");

            if (!sc.hasNextInt()) {
                System.out.println("Invalid row input.");
                sc.next();
                return;
            }
            int r = sc.nextInt();

            if (!sc.hasNextInt()) {
                System.out.println("Invalid col input.");
                sc.next();
                return;
            }
            int c = sc.nextInt();

            if (!selectedShow.isValidSeat(r, c)) {
                System.out.println("Invalid seat position: (" + r + "," + c + ")");
                return;
            }

            String seatKey = r + "-" + c;
            if (!seenSeats.add(seatKey)) {
                System.out.println("Duplicate seat entered: (" + r + "," + c + ")");
                return;
            }

            seatList.add(new int[]{r, c});
        }

        try {
            service.bookSeats(user, selectedShow, seatList);
            System.out.println("Booking Successful!");
        } catch (Exception e) {
            System.out.println("Booking Failed: " + e.getMessage());
        }
    }

    // 🔹 View Bookings
    private static void viewBookings(User user) {

        List<Booking> bookings = user.getBookings();

        if (bookings.isEmpty()) {
            System.out.println("\nNo bookings found.");
            return;
        }

        System.out.println("\nYour Bookings:");

        for (int i = 0; i < bookings.size(); i++) {
            Booking b = bookings.get(i);

            System.out.print(i + " -> Seats: ");

            for (Seat s : b.getSeats()) {
                System.out.print("(" + s.getRow() + "," + s.getCol() + ") ");
            }

            System.out.println();
        }
    }

    // 🔹 Cancel Booking
    private static void cancelBooking(User user, BookingService service) {

        List<Booking> bookings = user.getBookings();

        if (bookings.isEmpty()) {
            System.out.println("\nNo bookings to cancel.");
            return;
        }

        viewBookings(user);

        System.out.println("\nEnter booking index to cancel:");

        if (!sc.hasNextInt()) {
            System.out.println("Invalid index!");
            sc.next();
            return;
        }

        int index = sc.nextInt();

        if (index < 0 || index >= bookings.size()) {
            System.out.println("Invalid index!");
            return;
        }

        Booking booking = bookings.get(index);
        try {
            service.cancelBooking(user, booking);
            System.out.println("Booking Cancelled!");
        } catch (Exception e) {
            System.out.println("Cancel Failed: " + e.getMessage());
        }
    }
}