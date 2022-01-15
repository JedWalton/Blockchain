import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        String input = s.nextLine();

        String out = "yes";
        for (int i = 0; i < input.length(); i++) {
            if (input.charAt(input.length() - 1 - i) != input.charAt(i)) {
                out = "no";
            }
        }
        System.out.println(out);
    }
}