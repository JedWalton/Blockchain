import java.time.LocalDate;
import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        // put your code here
        Scanner s = new Scanner(System.in);
        int y = s.nextInt();
        int m = s.nextInt();
        int d = s.nextInt();
        LocalDate date = LocalDate.of(y, m, 1).plusMonths(1);
        System.out.println(date.minusDays(d));
    }
}