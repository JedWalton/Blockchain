import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;

class Main {
    public static void main(String[] args) throws Exception {
        InputStream inputStream = System.in;
        //create advanced stream to read line, instead of bytes
        BufferedReader br = new BufferedReader(new InputStreamReader(inputStream));
        String line = br.readLine();

        //get all the characters in the String
        char[] chars = line.toCharArray();

        for (char aChar : chars) {
            //use Integer.valueOf to get character's ACII value
            System.out.print(Integer.valueOf(aChar));
        }
    }
}