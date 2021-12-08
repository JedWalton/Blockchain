import java.time.LocalDate;
import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        // put your code here
        Scanner s = new Scanner(System.in);
        String input = s.nextLine();
        LocalDate d = LocalDate.parse(input);
        System.out.println(d.minusDays(10));
    }
}