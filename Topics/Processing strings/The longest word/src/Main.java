import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        // put your code here
        Scanner s = new Scanner(System.in);
        String[] in = s.nextLine().split(" ");
        String longest = "";

        for (String item : in) {
            if (item.length() > longest.length()) {
                longest = item;
            }
        }
        System.out.println(longest);
    }
}