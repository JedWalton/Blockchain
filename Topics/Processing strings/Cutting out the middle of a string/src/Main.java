import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        String in = s.nextLine();

        int middleIndex = in.length() / 2;

        if (in.length() % 2 == 1) {
            System.out.println(in.substring(0, middleIndex).concat(in.substring(middleIndex + 1)));
        } else {
            System.out.println(in.substring(0, middleIndex - 1).concat(in.substring(middleIndex + 1)));
        }
    }
}