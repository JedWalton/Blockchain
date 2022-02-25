import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

class Utils {

    public static List<Integer> sortOddEven(List<Integer> numbers) {
        List<Integer> L1 = new ArrayList<>();
        List<Integer> L2 = new ArrayList<>();
        for (Integer number : numbers) {
            if (number % 2 == 0) {
                L1.add(number);
            } else {
                L2.add(number);
            }
        }
        L1.sort(Comparator.reverseOrder());
        L2.sort(Comparator.naturalOrder());

        L2.addAll(L1);
        return L2;
    }


}