// You can experiment here, it won’t be checked

import java.util.function.Function;
import java.util.function.IntUnaryOperator;

public class Task {
  public static void main(String[] args) {
    // put your code here

    Function<String, String> operator1 = s -> s + s;
    Function<String, String> operator2 = s -> String.valueOf(s.length());
    Function<String, String> resultOperator = operator1.compose(operator2);
    System.out.println(resultOperator.apply("test"));

  }
}
