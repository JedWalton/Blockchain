import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

class Main {
    public static void main(String[] args) {
        // put your code here
        Scanner s = new Scanner(System.in);
        String first = s.nextLine();
        String second = s.nextLine();

        Pattern pattern = Pattern.compile(second);
        Matcher matcher = pattern.matcher(first);

        int count = 0;
        while (matcher.find()) {
            count++;
        }
        System.out.println(count);
    }
}