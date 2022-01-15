// You can experiment here, it won’t be checked

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Task {
  public static void main(String[] args) throws FileNotFoundException {
    // put your code here
    String pathToFile = "home/dank/Downloads/q.txt";

    File file = new File(pathToFile);

    try (Scanner scanner = new Scanner(file)) {
      while (scanner.hasNext()) { 
        System.out.print(scanner.nextLine() + " ");
      }
    } catch (FileNotFoundException e) {
      System.out.println("No file found: " + pathToFile);
    }
  }
}
