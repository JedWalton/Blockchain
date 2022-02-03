import java.util.Scanner;
import java.util.stream.Stream;

class StringProcessor extends Thread {

    final Scanner scanner = new Scanner(System.in); // use it to read string from the standard input

    @Override
    public void run() {
        Stream.generate(scanner::nextLine)
                .takeWhile(s -> !s.toUpperCase().equals(s))
                .forEach(s -> System.out.println(s.toUpperCase()));
        System.out.println("FINISHED");
    }
}