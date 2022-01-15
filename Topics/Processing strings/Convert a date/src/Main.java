import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        String[] d = s.nextLine().split("-");
        System.out.println(d[1] + "/" + d[2] + "/" + d[0]);
    }
}