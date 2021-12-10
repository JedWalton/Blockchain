import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        // put your code here
        Scanner s = new Scanner(System.in);
        int n = s.nextInt();
        String[][] array = new String[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (i == (n / 2)
                        || j == (n / 2)
                        || i == j
                        || i == (n - 1) - j) {
                    System.out.print(array[i][j] = "* ");
                } else {
                    System.out.print(array[i][j] = ". ");
                }
            }
            System.out.println();
        }
    }
}