import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        //put your code here
        Scanner sc = new Scanner(System.in);
        int a = sc.nextInt();
        int b = sc.nextInt();
        int[][] x = new int[a][b];
        for (int i = 0; i < a; i++) {
            for (int j = 0; j < b; j++) {
                x[i][j] = sc.nextInt();
            }
        }
        int xd = sc.nextInt();
        boolean found = false;
        int count = 0;
        int row = 0;
        for (int i = 0; i < a; i++) {
            for (int j = 0; j < b; j++) {
                if (!found) {
                    if (x[i][j] == 0) {
                        count++;
                    } else {
                        count = 0;
                    }
                    if (xd == count) {
                        found = true;
                        row = i + 1;
                    }
                }
            }
            count = 0;
        }
        System.out.println(row);
    }
}