import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        // put your code here
        Scanner s = new Scanner(System.in);
        String str = s.nextLine();

        int count = 0;
        String result = "";

        for (int i = 0; i < str.length(); i++) {
            char a = str.charAt(i);
            count = 1;

            while (i + 1 < str.length() && str.charAt(i) == str.charAt(i + 1)) {
                count++;
                i++;
            }

            result = result.concat(Character.toString(a).concat(Integer.toString(count)));
        }

        System.out.print(result);
    }
}