import java.util.concurrent.atomic.AtomicInteger;
import java.util.function.*;

class FunctionUtils {

    public static Supplier<Integer> getInfiniteRange() {
        // write your code here
        return new AtomicInteger()::getAndIncrement;
    }

}