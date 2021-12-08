import java.time.LocalDateTime;
import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        // put your code here
        Scanner s = new Scanner(System.in);
        LocalDateTime ldt = LocalDateTime.parse(s.nextLine());
        int hoursToSub = s.nextInt();
        int minutesToAdd = s.nextInt();

        System.out.println(ldt.minusHours(hoursToSub).plusMinutes(minutesToAdd));

    }
}