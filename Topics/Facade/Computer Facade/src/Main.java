class ComputerFacadeTestDrive {
    public static void main(String[] args) {
        Processor processor = new Processor("Processor");
        Monitor monitor = new Monitor("Monitor");
        Keyboard keyboard = new Keyboard("Keyboard");

        ComputerFacade computerFacade = new ComputerFacade(processor, monitor, keyboard);

        computerFacade.turnOnComputer();
        computerFacade.turnOffComputer();
    }
}

class ComputerFacade {
    private final Processor processor;
    private final Monitor monitor;
    private final Keyboard keyboard;

    public ComputerFacade(Processor processor, Monitor monitor, Keyboard keyboard) {
        this.processor = processor;
        this.monitor = monitor;
        this.keyboard = keyboard;
    }

    public void turnOnComputer() {
        this.processor.on();
        this.monitor.on();
        this.keyboard.on();
    }

    public void turnOffComputer() {
        this.keyboard.off();
        this.monitor.off();
        this.processor.off();
    }
}

abstract class Component {
    String description;
    Component(String description) {
        this.description = description;
    }

    public void on() {
        System.out.println(this.description + " on");
    }

    public void off() {
        System.out.println(this.description + " off");
    }
}

class Processor extends Component {
    Processor(String description) {
        super(description);
    }
}

class Monitor extends Component {
    Monitor(String description) {
        super(description);
    }
}

class Keyboard extends Component {
    Keyboard(String description) {
        super(description);
    }

    public void on() {
        super.on();
        turnOnBacklight();
    }

    public void off() {
        super.off();
        turnOffBacklight();
    }

    private void turnOnBacklight() {
        System.out.println("Backlight is turned on");
    }

    private void turnOffBacklight() {
        System.out.println("Backlight is turned off");
    }
}