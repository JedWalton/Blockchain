import java.time.LocalDate;
import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        // put your code here
        Scanner s = new Scanner(System.in);
        LocalDate date = LocalDate.parse(s.nextLine());
        System.out.print(date.getDayOfYear() + " ");
        System.out.print(date.getDayOfMonth());
    }
}