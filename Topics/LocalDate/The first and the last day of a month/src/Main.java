import java.time.LocalDate;
import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        // put your code here
        Scanner s = new Scanner(System.in);
        int yr = s.nextInt();
        int m = s.nextInt();
        LocalDate date = LocalDate.of(yr, m, 1);
        System.out.println(date + " " + date.plusMonths(1).minusDays(1) );
    }
}