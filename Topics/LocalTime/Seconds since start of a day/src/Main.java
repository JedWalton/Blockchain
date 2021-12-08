import java.time.LocalDate;
import java.time.LocalTime;
import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        // put your code here
        Scanner s = new Scanner(System.in);
        int input = s.nextInt();
        //LocalTime time = LocalTime.parse(input);
        System.out.println(LocalTime.ofSecondOfDay(input));
    }
}