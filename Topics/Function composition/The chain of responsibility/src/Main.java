import java.security.MessageDigest;
import java.util.Base64;
import java.util.Scanner;


class ChainOfResponsibilityDemo {
    // Don't change the code below
    public static void main(String[] args) throws Exception {

        String data = new Scanner(System.in).nextLine();
        data = "<transaction>" + data + "</transaction>";
        String digest = "";
        try {
            final MessageDigest md5 = MessageDigest.getInstance("MD5");
            final byte[] digestBytes = md5.digest(data.getBytes("UTF-8"));
            digest = new String(Base64.getEncoder().encode(digestBytes));
        } catch (Exception ignored) {
            System.out.println("An error occurred");
        }
        data = data + String.format("<digest>%s</digest>", digest);
        System.out.println("<request>" + data + "</request>");
    }
}