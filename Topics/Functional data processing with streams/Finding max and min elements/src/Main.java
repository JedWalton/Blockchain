import java.util.*;
import java.util.function.*;
import java.util.stream.*;


class MinMax {

    public static <T> void findMinMax(
            Stream<? extends T> stream,
            Comparator<? super T> order,
            BiConsumer<? super T, ? super T> minMaxConsumer) {

        // your implementation here
        List<? extends T> list = stream.collect(Collectors.toList());
        minMaxConsumer.accept(list.stream().min(order).orElse(null), list.stream().max(order).orElse(null));
    }
}