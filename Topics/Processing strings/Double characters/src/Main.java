import java.util.*;

class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String str = scanner.nextLine();
        StringBuilder str2 = new StringBuilder();

        for (int i = 0; i < str.length(); i++) {
            str2.append(str.charAt(i));
            str2.append(str.charAt(i));
        }
        System.out.println(str2);
    }
}