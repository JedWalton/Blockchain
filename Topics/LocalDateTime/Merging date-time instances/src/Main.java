import java.time.LocalDateTime;
import java.util.Scanner;

public class Main {

    public static LocalDateTime merge(LocalDateTime dateTime1, LocalDateTime dateTime2) {
        // write your code here
        int oneYear = dateTime1.getYear();
        int twoYear = dateTime2.getYear();
        int outputYear = Math.max(oneYear, twoYear);

        int oneMonth = dateTime1.getMonthValue();
        int twoMonth = dateTime2.getMonthValue();
        int outputMonth = Math.max(oneMonth, twoMonth);

        int oneDay = dateTime1.getDayOfMonth();
        int twoDay = dateTime2.getDayOfMonth();
        int outputDay = Math.max(oneDay, twoDay);

        int oneHour = dateTime1.getHour();
        int twoHour = dateTime2.getHour();
        int outputHour = Math.max(oneHour, twoHour);

        int oneMinute = dateTime1.getMinute();
        int twoMinute = dateTime2.getMinute();
        int outputMinute = Math.max(oneMinute, twoMinute);

        int oneSecond = dateTime1.getSecond();
        int twoSecond = dateTime2.getSecond();
        int outputSecond = Math.max(oneSecond, twoSecond);


        return LocalDateTime.of(outputYear, outputMonth, outputDay, outputHour, outputMinute, outputSecond);
    }

    /* Do not change code below */
    public static void main(String[] args) {
        final Scanner scanner = new Scanner(System.in);
        final LocalDateTime firstDateTime = LocalDateTime.parse(scanner.nextLine());
        final LocalDateTime secondDateTime = LocalDateTime.parse(scanner.nextLine());
        System.out.println(merge(firstDateTime, secondDateTime));
    }
}