import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        // put your code here
        Scanner scanner = new Scanner(System.in);
        while (true) {
            int num = scanner.nextInt();
            if (num == 0){
                break;
            } else {
                System.out.println(num % 2 == 0 ? "even" : "odd");
            }
        }
    }
}