import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        // put your code here
        Scanner s = new Scanner(System.in);
        int sizeOfArray = s.nextInt();
        int sum = 0;
        for (int i = 0; i < sizeOfArray; i++) {
            int current = s.nextInt();
            sum += current;
        }
        System.out.print(sum);
    }
}