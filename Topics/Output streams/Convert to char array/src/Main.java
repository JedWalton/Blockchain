import java.io.IOException;

class Converter {
    public static char[] convert(String[] words) throws IOException {
        String s = "";
        for (String item : words) {
            s += item;
        }
        return s.toCharArray();
    }
}