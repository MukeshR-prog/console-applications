class Truck extends Vehicle{
    @Override
    double calculateRent(int days){
        return (double)days * rentalPrice * 1.2;
    }
    public Truck(int vehicleNo, String brand, double rentalPrice) {
        super(vehicleNo, brand, rentalPrice);
    }
}