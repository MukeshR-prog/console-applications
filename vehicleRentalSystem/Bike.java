class Bike extends Vehicle{
    @Override
    double calculateRent(int days){
        return (double)days * rentalPrice * 0.9;
    }
    public Bike(int vehicleNo, String brand, double rentalPrice) {
        super(vehicleNo, brand, rentalPrice);
    }
}