import java.util.Scanner;

class MultipleFunction {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        double x = scanner.nextDouble();
        System.out.println(f(x));
    }

    public static double f(double x) {
        //call your implemented methods here.
        double output = 0;
        if (x <= 0) {
            output = f1(x);
        } else if (0 < x && x < 1) {
            output = f2(x);
        } else if (x >= 1) {
            output = f3(x);
        }
        return output;
    }

    //implement your methods here
    public static double f1(double x) {
        //double out = x * x + 1;
        return x * x + 1;
    }
    public static double f2(double x) {
        //x = 1 / x * x;
        return 1 / (x * x);
    }
    public static double f3(double x) {
        //x = (x * x) - 1;
        return x * x - 1;
    }

}