import java.time.LocalDate;
import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        // put your code here
        Scanner s = new Scanner(System.in);
        String text = s.nextLine();
        LocalDate now = LocalDate.parse(text);
        System.out.println(now.minusYears(30));
        System.out.println(now.plusYears(30));
    }
}