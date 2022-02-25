import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;

class Main {
    public static void main(String[] args) {
        // put your code here
        Scanner s = new Scanner(System.in);
        int start = s.nextInt();
        int stop = s.nextInt();
        s.nextInt();
        TreeMap<Integer, String> dict = new TreeMap<>() {{
            while (s.hasNext()) {
                put(s.nextInt(), s.next());
            }
        }};
    dict.subMap(start, true, stop, true)
            .forEach((key, value) -> System.out.println(key + " " + value));
    }
}