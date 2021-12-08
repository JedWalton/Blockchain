class Vehicle {

    private String name;

    // create constructor

    class Engine {

        // add field horsePower
        // create constructor

        void start() {
            System.out.println("RRRrrrrrrr....");
        }

        // create method printHorsePower()
    }
}

// this code should work
class EnjoyVehicle {

    public static void main(String[] args) {

        Vehicle vehicle = new Vehicle("Dixi");
        Vehicle.Engine engine = vehicle.new Engine(15);
        engine.printHorsePower();
    }
}