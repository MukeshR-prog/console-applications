class Car extends Vehicle{
    @Override
    double calculateRent(int days){
        return (double)days * rentalPrice;
    }
    public Car(int vehicleNo, String brand, double rentalPrice) {
        super(vehicleNo, brand, rentalPrice);
    }
}
