import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Customer c1 = new Customer(1, 'A', 'B', 9);
        Customer c2 = new Customer(2, 'B', 'D', 9);
        Customer c3 = new Customer(3, 'B', 'C', 10);
        Customer c4 = new Customer(4, 'C', 'D', 10);

        BookingSystem bs = new BookingSystem(4);
        bs.BookTaxi(c1);
        bs.BookTaxi(c2);
        bs.BookTaxi(c3);
        bs.BookTaxi(c4);
        bs.displayTaxi();
        scanner.close();
    }
}