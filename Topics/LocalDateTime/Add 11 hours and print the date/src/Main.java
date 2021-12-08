import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        // put your code here
        Scanner s = new Scanner(System.in);
        LocalDateTime ldt = LocalDateTime.parse(s.nextLine());
        System.out.println(ldt.plusHours(11).toLocalDate());
    }
}