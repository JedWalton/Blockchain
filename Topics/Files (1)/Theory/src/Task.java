// You can experiment here, it won’t be checked
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Task {
  public static void main(String[] args) throws FileNotFoundException {
    // put your code here
    File file = new File("/home/jed/Downloads/dataset_91007.txt");
    Scanner s = new Scanner(file);

    int greatest = 0;

    while (s.hasNext()) {
      int t = s.nextInt();
      if (greatest < t) {
        greatest = t;
      }
    }
    System.out.println(greatest);
  }
}
