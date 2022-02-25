import java.util.*;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {
        new Scanner(System.in)
                .useDelimiter("\\W+")
                .tokens()
                .collect(Collectors.groupingBy(String::toLowerCase, TreeMap::new, Collectors.counting()))
                .entrySet()
                .stream()
                .sorted(Map.Entry.comparingByValue(Comparator.reverseOrder()))
                .limit(10)
                .map(Map.Entry::getKey)
                .forEach(System.out::println);
    }
}