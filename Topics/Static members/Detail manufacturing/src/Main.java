class ManufacturingController {

    private static int counter;

    public static String requestProduct(String product) {
        // write your code here
        counter++;
        return String.format("%d. Requested %s", counter, product);
    }

    public static int getNumberOfProducts() {
        // write your code here
        return counter;
    }
}