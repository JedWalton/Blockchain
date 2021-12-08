import java.time.LocalDate;
import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        // put your code here
        Scanner s = new Scanner(System.in);
        int y = s.nextInt();
        int days1 = s.nextInt();
        int days2 = s.nextInt();
        int days3 = s.nextInt();
        LocalDate daysOneOut = LocalDate.ofYearDay(y, days1);
        LocalDate daysTwoOut = LocalDate.ofYearDay(y, days2);
        LocalDate daysThreeOut = LocalDate.ofYearDay(y, days3);

        System.out.println(daysOneOut);
        System.out.println(daysTwoOut);
        System.out.println(daysThreeOut);




    }
}