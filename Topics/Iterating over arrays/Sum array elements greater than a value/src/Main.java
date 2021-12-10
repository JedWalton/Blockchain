import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        // put your code here
        Scanner s = new Scanner(System.in);
        int sizeOfArray = s.nextInt();
        int[] array = new int[sizeOfArray];
        for (int i = 0; i < sizeOfArray; i++) {
            array[i] = s.nextInt();
        }
        int n = s.nextInt();
        int sum = 0;

        for (int j = 0; j < sizeOfArray; j++) {
            if (array[j] > n) {
                sum += array[j];
            }
        }
        System.out.println(sum);
    }
}