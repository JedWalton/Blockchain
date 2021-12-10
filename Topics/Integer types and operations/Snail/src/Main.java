import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int height = scanner.nextInt();
        int upFeet = scanner.nextInt();
        int downFeet = scanner.nextInt();
        System.out.println((height - downFeet - 1) / (upFeet - downFeet) + 1);
    }
}