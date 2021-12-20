import java.util.Scanner;

/* Product - Motor */
abstract class Motor {

    String name;
    String model;
    long power;

    public Motor(String name, String model, long power) {
        this.name = name;
        this.model = model;
        this.power = power;
    }

    @Override
    public String toString() {
        return "motor={model:" + model + ",power:" + power + "}";
    }
}

class PneumaticMotor extends Motor {
    public PneumaticMotor(String name, String model, long power) {
        super(name, model, power);
    }
}

class HydraulicMotor extends Motor {
    public HydraulicMotor(String name, String model, long power) {
        super(name, model, power);
    }
}

class ElectricMotor extends Motor {
    public ElectricMotor(String name, String model, long power) {
        super(name, model, power);
    }
}

class WarpDrive extends Motor {
    public WarpDrive(String name, String model, long power) {
        super(name, model, power);
    }
}

class MotorFactory {

    /**
     * It returns an initialized motor according to the specified type by the first character:
     * 'P' or 'p' - pneumatic, 'H' or 'h' - hydraulic, 'E' or 'e' - electric, 'W' or 'w' - warp.
     */
    public static Motor make(char type, String model, long power) {
        // write your code here ...
        if (type == 'P' || type == 'p') {
            return new PneumaticMotor("Pneumatic", model, power);
        } else if (type == 'H' || type == 'h') {
            return new HydraulicMotor("Hydraulic", model, power);
        } else if (type == 'E' || type == 'e') {
            return new ElectricMotor("Electric", model, power);
        } else if (type == 'W' || type == 'w') {
            return new WarpDrive("Warp", model, power);
        }
        return null;
    }
}

public class Main {
    public static void main(String[] args) {
        final Scanner scanner = new Scanner(System.in);
        final char type = scanner.next().charAt(0);     
        final String model = scanner.next();
        final long power = scanner.nextLong();
        // write your code here ...
        Motor motor = MotorFactory.make(type, model, power);
        scanner.close();
        assert motor != null;
        System.out.println(motor.name + " " + motor);
    }
}