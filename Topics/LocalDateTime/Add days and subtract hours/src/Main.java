import java.time.LocalDateTime;
import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        // put your code here
        Scanner s = new Scanner(System.in);
        LocalDateTime ldt = LocalDateTime.parse(s.next());
        int daysToAdd = s.nextInt();
        int hoursToSubtract = s.nextInt();

        System.out.println(ldt.plusDays(daysToAdd).minusHours(hoursToSubtract));
    }
}