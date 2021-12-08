class EnjoyVehicle {

    public static void startVehicle() {
        // start your vehicle
        Vehicle car = new Vehicle();
        Vehicle.Engine motor = car.new Engine();
        motor.start();
    }
}