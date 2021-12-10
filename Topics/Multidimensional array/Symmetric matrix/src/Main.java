import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        // put your code here
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[][] matrix = new int[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                matrix[i][j] = sc.nextInt();
            }
        }
        boolean symmetric = false;
        boolean breakCondition = false;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (matrix[i][j] == matrix[j][i]) {
                    symmetric = true;
                } else {
                    breakCondition = true;
                }
            }
        }
        if (symmetric && !breakCondition) {
            System.out.print("YES");
        } else {
            System.out.print("NO");
        }
    }
}