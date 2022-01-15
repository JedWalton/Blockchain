import java.io.OutputStream;
import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        // put your code here
        Scanner s = new Scanner(System.in);
        String[] strArr = String.valueOf(s.next()).split("");

        int[] arr = new int[strArr.length];
        for (int i = 0; i < strArr.length; i++) {
            arr[i] = Integer.parseInt(strArr[i]);
        }

        System.out.println(arr[0] + arr[1] + arr[2] == arr[arr.length - 3] + arr[arr.length - 2] + arr[arr.length - 1]
                ? "Lucky" : "Regular");
    }
}