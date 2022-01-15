import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        // put your code here
        Scanner s = new Scanner(System.in);
        String input = s.nextLine();

        boolean sorted = true;
        for (int i = 0; i < input.length() - 1; i++) {
            if (input.charAt(i) != input.charAt(i + 1) - 1) {
                sorted = false;
                break;
            }
        }

        System.out.println(sorted);
    }
}