// You can experiment here, it won’t be checked

public class Task {
  public static void main(String[] args) {
    // put your code here
    String s = "Hi, world";

    int len = s.length(); // the len is 7

    char theFirstChar = s.charAt(0);  // 'H' has the index 0

    char theFifthChar = s.charAt(4); // 'a' has the index 4

    char theLastChar = s.charAt(s.length() - 1); // 'l' has the index 6

    System.out.println(theLastChar);
  }
}
