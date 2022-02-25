import java.util.Scanner;
import java.util.stream.*;

class ParallelFilteringStream {

    public static LongStream createPrimesFilteringStream(long start, long end) {
        // write your code here
        return LongStream.rangeClosed(start, end).parallel().filter(NumberUtils::isPrime);
    }

    /* Please do not modify the code below */
    public static void main(String[] args) {
        final Scanner scanner = new Scanner(System.in);
        final String[] vals = scanner.nextLine().split(" ");

        final long left = Long.valueOf(vals[0]);
        final long right = Long.valueOf(vals[1]);

        final LongStream stream = createPrimesFilteringStream(left, right);

        if (!stream.isParallel()) {
            throw new NoParallelStreamException(
                "You need to write a parallel stream, not sequential!");
        }

        final Long count = stream.boxed().count();

        System.out.println(count);
    }

    public static class NumberUtils {

        public static boolean isPrime(long n) {
            return n > 1 && LongStream
                    .rangeClosed(2, n - 1)
                    .noneMatch(divisor -> n % divisor == 0);
        }
    }

    static class NoParallelStreamException extends RuntimeException {

        public NoParallelStreamException(String text) {
            super(text);
        }
    }
}