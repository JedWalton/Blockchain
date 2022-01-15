import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String s = scanner.next();
        int n = scanner.nextInt();

        if (n > s.length()) {
            System.out.println(s);
        } else {
            String first = s.substring(n);
            String og = s.substring(0, n);
            System.out.println(first.concat(og));
        }

    }
}