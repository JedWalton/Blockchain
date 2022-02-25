import java.util.Scanner;
import java.util.stream.Collectors;
import java.util.stream.LongStream;
import java.util.stream.Stream;

class StreamOfPrimitives {

    public static LongStream getLongStream(int n) {
        // write your code here
        return LongStream.concat(
                LongStream.range(-n, 0),
                LongStream.rangeClosed(1L, n));
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = scanner.nextInt();

        String result = getLongStream(n).mapToObj(e -> e)
                .map(Object::toString)
                .collect(Collectors.joining(" "));

        System.out.println(result);
    }
}