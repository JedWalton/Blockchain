import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;
import java.util.Scanner;


class Main {
    public static void main(String[] args) {
        // put your code here
        Scanner s = new Scanner(System.in);
        LocalDateTime ldt = LocalDateTime.parse(s.nextLine());
        LocalDateTime ldt2 = LocalDateTime.parse(s.nextLine());
        int hours = (int) ChronoUnit.HOURS.between(ldt, ldt2);
        System.out.println(hours);
    }
}