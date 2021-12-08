import java.time.LocalDate;
import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        // put your code here
        Scanner s = new Scanner(System.in);
        int yr = s.nextInt();
        int d = s.nextInt();
        LocalDate date = LocalDate.ofYearDay(yr, d);
        if (date.getDayOfMonth() == 1) {
            System.out.println("true");
        } else {
            System.out.println("false");
        }
    }
}