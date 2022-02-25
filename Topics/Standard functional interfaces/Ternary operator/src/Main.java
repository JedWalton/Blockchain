import java.util.function.*;

class Operator {

    public static <T, U> Function<T, U> ternaryOperator(
            Predicate<? super T> condition,
            Function<? super T, ? extends U> ifTrue,
            Function<? super T, ? extends U> ifFalse) {

       Function<T, U>  myFunction;

           myFunction = t -> condition.test(t) ? ifTrue.apply(t) : ifFalse.apply(t);

        return myFunction; // your implementation here

    }
}