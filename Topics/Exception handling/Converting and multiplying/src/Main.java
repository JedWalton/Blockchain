import java.util.InputMismatchException;
import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        // put your code here
        Scanner s = new Scanner(System.in);
        while (s.hasNext()) {
            try {
                int in = s.nextInt();
                if (in == 0) {
                    break;
                }
                System.out.println(in * 10);
            } catch (InputMismatchException e) {
                System.out.println("Invalid user input: " + s.next());
            }
        }
    }
}