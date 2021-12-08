import java.time.LocalTime;
import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        // put your code here
        Scanner s = new Scanner(System.in);
        String time = s.nextLine();
        int h = s.nextInt();
        int m = s.nextInt();
        LocalTime t1 = LocalTime.parse(time);
        LocalTime t2 = LocalTime.of(h, m);
        int t1seconds = t1.toSecondOfDay();
        int t2seconds = t2.toSecondOfDay();
        LocalTime out = LocalTime.ofSecondOfDay(t1seconds - t2seconds);
        System.out.println(out);
    }
}