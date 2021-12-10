import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        // put your code here
        for (int i = 0; i < 4; i++) {
            int num = scanner.nextInt();
            System.out.print(--num + " ");
        }
    }
}