public class Main {
    public static void main(String[] args) {
        // write your code
        IPhone154 iPhone = new IPhone154();
        IPhone154.PrototypeIPhone154 proto = new IPhone154.PrototypeIPhone154();
        proto.printMinCost();
    }
}

// An internal staff of the testing platform. Do not change it
class IPhone154 {
    static double minCost = initCost();

    static class PrototypeIPhone154 {
        void printMinCost() {
            System.out.println("The min cost of IPhone154 should be: " + minCost + "$");
        }
    }

    private static double initCost() {
        java.util.Scanner scanner = new java.util.Scanner(System.in);
        return scanner.nextDouble();
    }
}