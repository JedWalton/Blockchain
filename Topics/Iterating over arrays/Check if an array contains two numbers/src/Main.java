import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        // put your code here
        Scanner s = new Scanner(System.in);
        int len = s.nextInt();
        int[] array = new int[len];
        int n = 0;
        int m = 0;
        for (int i = 0; i < len; i++) {
            array[i] = s.nextInt();
        }
        n = s.nextInt();
        m = s.nextInt();

        boolean occursNextToEachOther = false;
        for (int j = 0; j < len; j++) {
            if ((j + 1) < len) {
                if (array[j] == n && array[j + 1] == m) {
                    occursNextToEachOther = true;
                } else if (array[j] == m && array[j + 1] == n) {
                    occursNextToEachOther = true;
                }
            }
        }
        System.out.println(occursNextToEachOther);
    }
}