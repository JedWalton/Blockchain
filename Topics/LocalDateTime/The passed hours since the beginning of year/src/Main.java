import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;
import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        // put your code here
        Scanner s = new Scanner(System.in);
        LocalDateTime ldt = LocalDateTime.parse(s.nextLine());
        LocalDateTime ldt2 = ldt.withDayOfYear(1).withHour(0).withMinute(0).withSecond(0).withNano(0);
        System.out.println(ChronoUnit.HOURS.between(ldt2, ldt));

    }
}