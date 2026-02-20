import java.util.ArrayList;
import java.util.List;

public class RentalService  {
    private List<Vehicle> vehicles = new ArrayList<>();
    private List<Customer> customers = new ArrayList<>();

    public void addVehicle(Vehicle vehicle){
        vehicles.add(vehicle);
    }
    public void addCustomer(Customer customer){
        customers.add(customer);
    }

    public void showAll(){
        for(Vehicle vehi : vehicles){
            System.out.println("Vehicle no. : "+vehi.getVehicleNo()+ "\n brand : "+vehi.getBrand()+"\n Available status : "+vehi.isAvailable()+"\n");
        }
    }

    public Vehicle findVehicle(int vehicleId){
        for(Vehicle v: vehicles){
            if(v.getVehicleNo() == vehicleId) return v;
        }
        return null;
    }

    public Customer findCustomer(int customerId){
        for(Customer c : customers){
            if(c.getCustomerId() == customerId) return c;
        }
        return null;
    }

    public void rentVehicle(int vehicleNo , int customerId ,int days){
        Vehicle vehicle = findVehicle(vehicleNo);
        Customer customer = findCustomer(customerId);

        if(vehicle == null || customer == null){
            System.err.println("Vehicle or customer not found");
            return;
        }
        if(!vehicle.isAvailable()){
            System.out.println("Vehicle is already rented choose other vehicle");
            return;
        }
        double cost = vehicle.calculateRent(days);
        vehicle.rent(customer);

        System.out.println("Vehicle rented successfully and cost : "+cost);
    }
    public void returnVehicle(Vehicle vehicle){
        vehicle.returnVehicle();
        System.out.println("Vehicle returned successfully");
    }
}
