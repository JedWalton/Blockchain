import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int count = 0;
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= i; j++) {
                count++;
                if (count > n) {
                    break;
                }
                System.out.printf("%d ", i);
            }
            if (count > n) {
                break;
            }
        }
    }
}