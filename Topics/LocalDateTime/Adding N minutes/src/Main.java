import java.time.LocalDateTime;
import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        // put your code here
        Scanner s = new Scanner(System.in);
        LocalDateTime ldt = LocalDateTime.parse(s.nextLine());
        int minsToAdd = s.nextInt();
        ldt = ldt.plusMinutes(minsToAdd);
        int year = ldt.getYear();
        int dayOfYear = ldt.getDayOfYear();
        System.out.println(year + " " + dayOfYear + " " +  ldt.toLocalTime().toString());
    }
}