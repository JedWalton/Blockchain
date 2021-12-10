import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        // call the method here
        Scanner s = new Scanner(System.in);
        int a = s.nextInt();
        int b = s.nextInt();
        countAreaOfParallelogram(a, b);
    }

    // Do not change code below   
    public static void countAreaOfParallelogram(int b, int h) {
        System.out.println(b * h);
    }
}