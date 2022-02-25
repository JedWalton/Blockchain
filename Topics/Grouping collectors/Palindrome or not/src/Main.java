import java.util.*;
import java.util.stream.Collectors;


class CollectorPalindrome {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        String[] words = scanner.nextLine().split(" ");

        Map<Boolean, List<String>> palindromeOrNo = Arrays.stream(words)
                .collect(
                    // write your collector here
                        Collectors.partitioningBy(word -> word.contentEquals(new StringBuilder(word).reverse()))
                );

        palindromeOrNo = new LinkedHashMap<>(palindromeOrNo);

        System.out.println(palindromeOrNo);
    }
}