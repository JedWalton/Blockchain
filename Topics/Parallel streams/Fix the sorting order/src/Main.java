import java.util.Arrays;
import java.util.Scanner;

class ParallelMapping {
    public static void main(String[] args) {
        var scanner = new Scanner(System.in);
        Arrays.stream(scanner.nextLine().split("\\s+"))
                .map(Integer::parseInt)
                .sorted()
                .map(n -> n * 2)
                .parallel()
                .forEachOrdered(System.out::println);
    }
}