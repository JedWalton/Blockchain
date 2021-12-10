import java.util.Scanner;

public class Main {

    public static int sign(int number) {
        // write your code here
        int posOrNegOrZero = 0;
        if (number < 0) {
            posOrNegOrZero = -1;
        } else if (number > 0) {
            posOrNegOrZero = 1;
        } else if (number == 0) {
            posOrNegOrZero = 0;
        }
        return posOrNegOrZero;
    }

    /* Do not change code below */
    public static void main(String[] args) {
        final Scanner scanner = new Scanner(System.in);
        final int n = scanner.nextInt();
        System.out.println(sign(n));
    }
}