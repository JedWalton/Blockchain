import java.util.Scanner;

class SimpleCalculator {
    // Implement your methods here
    Scanner scanner = new Scanner(System.in);
    long a1 = scanner.nextLong();
    long b1 = scanner.nextLong();

    public static void subtractTwoNumbers(long a1, long b1) {
        System.out.println(a1 - b1);
    }

    public static void sumTwoNumbers(long a1, long b1) {
        System.out.println(a1 + b1);
    }

    public static void divideTwoNumbers(long a1, long b1) {
        if (b1 == 0) {
            System.out.println("Division by 0!");
        } else {
            //System.out.println("Division by 0!");
            System.out.println(a1 / b1);
        }
    }

    public static void multiplyTwoNumbers(long a1, long b1) {
        System.out.println(a1 * b1);
    }
}