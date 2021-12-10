import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        // put your code here
        Scanner s = new Scanner(System.in);
        int len = s.nextInt();
        int count = 0;
        int[] array = new int[len];
        for (int i = 0; i < len; i++) {
            array[i] = s.nextInt();
        }
        int n = s.nextInt();

        for (int j = 0; j < len; j++) {
            if (array[j] == n) {
                count += 1;
            }
        }

        System.out.println(count);
    }
}