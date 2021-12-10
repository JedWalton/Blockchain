import java.util.Scanner;

public class Main {

    public static String prepareFullName(String firstName, String lastName) {

        String output = "if you read this, this function is broken";
        if (lastName != null && firstName != null) {
            output = firstName.concat(" " + lastName);
        } else if (lastName == null) {
            output = firstName;
        } else if (firstName == null) {
            output = lastName;
        }

        return output;
    }

    /* Do not change code below */
    public static void main(String[] args) {
        final Scanner scanner = new Scanner(System.in);

        String firstName = scanner.nextLine();
        firstName = "null".equals(firstName) ? null : firstName;

        String lastName = scanner.nextLine();
        lastName = "null".equals(lastName) ? null : lastName;

        System.out.println(prepareFullName(firstName, lastName));
    }
}