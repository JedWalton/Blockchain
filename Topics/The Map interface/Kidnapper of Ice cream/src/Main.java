import java.util.*;

class Main {
    public static void main(String[] args) {
        // put your code here
        Scanner s = new Scanner(System.in);
        String line1 = s.nextLine();
        String line2 = s.nextLine();

        Set<String> set = new TreeSet<>();
        String[] stringList = line1.split(" ");
        String[] stringList2 = line2.split(" ");
        for (String string : stringList) {
            set.add(string);
        }

        var map = new TreeMap<String, Integer>();
        for (String word : stringList) {
            int count = map.getOrDefault(word, 0);
            map.put(word, count + 1);
        }

        var map2 = new TreeMap<String, Integer>();
        for (String word : stringList2) {
            int count = map2.getOrDefault(word, 0);
            map2.put(word, count + 1);
        }

        boolean out = true;
        for (String string : stringList2) {
            if (!set.contains(string) || map.get(string) < map2.get(string)) {
                out = false;
                System.out.println("You are busted");
                break;
            }
        }
        if (out) {
            System.out.println("You get money");
        }

    }
}