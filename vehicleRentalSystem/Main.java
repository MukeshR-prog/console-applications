import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        RentalService service = new RentalService();

        service.addVehicle(new Car(101, "Tata", 1000));
        service.addVehicle(new Bike(102, "Yamaha", 500));
        service.addVehicle(new Truck(103, "Ashok Leyland", 2000));

        service.addCustomer(new Customer(1, "Mukesh"));
        service.addCustomer(new Customer(2, "Arun"));

        boolean running = true;

        while (running) {

            System.out.println("\n===== Vehicle Rental System =====");
            System.out.println("1. View All Vehicles");
            System.out.println("2. Rent Vehicle");
            System.out.println("3. Return Vehicle");
            System.out.println("4. Exit");
            System.out.print("Enter your choice: ");

            int choice = scanner.nextInt();

            switch (choice) {

                case 1:
                    service.showAll();
                    break;

                case 2:
                    System.out.print("Enter Vehicle Number: ");
                    int vehicleNo = scanner.nextInt();

                    System.out.print("Enter Customer ID: ");
                    int customerId = scanner.nextInt();

                    System.out.print("Enter Rental Days: ");
                    int days = scanner.nextInt();

                    service.rentVehicle(vehicleNo, customerId, days);
                    break;

                case 3:
                    System.out.print("Enter Vehicle Number: ");
                    int returnVehicleNo = scanner.nextInt();
                    
                    service.returnVehicle(service.findVehicle(returnVehicleNo));

                    break;

                case 4:
                    running = false;
                    System.out.println("Thank you for using Rental System!");
                    break;

                default:
                    System.out.println("Invalid choice. Try again.");
            }
        }

        scanner.close();
    }
}
