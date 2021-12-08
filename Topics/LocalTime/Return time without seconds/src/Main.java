import java.time.LocalTime;
import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        // put your code here
        Scanner s = new Scanner(System.in);
        String in = s.nextLine();
        LocalTime t = LocalTime.parse(in);
        System.out.println(t.withSecond(0));
    }
}