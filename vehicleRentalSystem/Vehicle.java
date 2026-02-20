abstract class Vehicle {
    private int vehicleNo;
    private String brand;
    protected double rentalPrice;
    private boolean isAvailable = true;
    private Customer currentCustomer;

    abstract double calculateRent(int day);


    public Vehicle(int vehicleNo, String brand, double rentalPrice) {
        this.vehicleNo = vehicleNo;
        this.brand = brand;
        this.rentalPrice = rentalPrice;
    }

    public void rent(Customer customer){
        this.currentCustomer = customer;
        isAvailable = false;
    }
    public void returnVehicle(){
        this.currentCustomer = null;
        isAvailable = true;
    }

    public int getVehicleNo() {
        return vehicleNo;
    }
    public String getBrand() {
        return brand;
    }
    public double getRentalPrice() {
        return rentalPrice;
    }
    public boolean isAvailable() {
        return isAvailable;
    }
    public Customer getCustomer(){
        return currentCustomer;
    }

}