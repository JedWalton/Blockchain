import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        final int size = 3;
        int[] amountList = new int[size];
        Scanner scanner = new Scanner(System.in);

        for (int i = 0; i < size; i++) {
            amountList[i] = scanner.nextInt();
        }

        Broker broker = new Broker();

        for (int i = 0; i < size; i++) {
            Option option = new Option(amountList[i]);
            Command command;
            if (amountList[i] > 0) {
                command = new BuyCommand(option);
            } else {
                command = new SellCommand(option);
            }
            broker.setCommand(command);
            broker.executeCommand();
        }
    }
}

class Option {
    private int amount;

    Option(int amount) {
        this.amount = amount;
    }

    void buy() {
        System.out.println(amount + " was bought");
    }

    void sell() {
        System.out.println(amount + " was sold");
    }
}

interface Command {
    void execute();
}

class BuyCommand implements Command {
    private Option option;

    BuyCommand(Option option) {
        this.option = option;
    }

    @Override
    public void execute() {
        option.buy();
    }
}

class SellCommand implements Command {
    private Option option;

    SellCommand(Option option) {
        this.option = option;
    }

    @Override
    public void execute() {
        option.sell();
    }
}

class Broker {
    private Command command;

    void setCommand(Command command) {
        this.command = command;
    }

    void executeCommand() {
        command.execute();
    }
}