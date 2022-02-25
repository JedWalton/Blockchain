import java.util.Scanner;
import java.util.stream.*;

public class Main {

    // Don't change the code below
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int a = scanner.nextInt();
        int b = scanner.nextInt();
        int n = scanner.nextInt();
        int m = scanner.nextInt();

        System.out.println(IntStream.rangeClosed(a, b)
                .filter(e -> e % n == 0 || e % m == 0)
                .sum());
    }
}