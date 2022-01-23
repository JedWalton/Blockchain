import java.io.BufferedReader;
import java.io.InputStreamReader;

class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        // start coding here
        String in = reader.readLine();
        in = in.trim();
        reader.close();
        if (in.isEmpty()) {
            System.out.println("0");
        } else {
            String[] arr = in.split("\\s+");
            System.out.println(arr.length);
        }
    }
}